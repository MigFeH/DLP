package ast.tipos;

import ast.locatable.Locatable;
import visitor.Visitor;

import java.util.List;
import java.util.Optional;

public class TipoRecord extends AbstractTipo {

    private List<CampoRecord> campos;

    public TipoRecord(List<CampoRecord> campos) {
        this.campos = campos;
    }

    public List<CampoRecord> getCampos() {
        return this.campos;
    }

    @Override
    public void mustBeIterable(Tipo tipoIterador, Locatable localizacionDelError) {
        if(tipoIterador instanceof ErrorType) {
            return;
        }

        if(this.campos.stream().filter(c -> c.getTipo().toString().equals(campos.getFirst().getTipo().toString())).toList().size() != this.campos.size()) {
            new ErrorType("El tipo de todos los campos del registro no es el mismo", localizacionDelError);
        } else {
            if(!this.campos.getFirst().getTipo().toString().equals(tipoIterador.toString())) {
                new ErrorType("El tipo del elemento iterador (" + tipoIterador.toString() + ") y del " + this.toString() + " (de " + this.campos.getFirst().getTipo().toString() + "'s) que recorre no son el mismo", localizacionDelError);
            }
        }
    }

    @Override
    public Tipo dot(String fieldName, Locatable localizacionDelError) {
        Optional<CampoRecord> campoRecordAccedido = campos.stream().filter(campoRecord -> campoRecord.getNombre().equals(fieldName)).findFirst();
        return campoRecordAccedido.isPresent() ?
                campoRecordAccedido.get().getTipo()
                    :
                new ErrorType("Campo record \"" + fieldName + "\" no existente", localizacionDelError);
    }

    @Override
    public int numberOfBytes() {
        int sumatorioNumeroBytes = 0;
        for(CampoRecord campo : campos) {
            sumatorioNumeroBytes += campo.getTipo().numberOfBytes();
        }
        return sumatorioNumeroBytes;
    }

    @Override
    public int getNumberOfElements() {
        return this.campos.size();
    }

    @Override
    public int getElementNumberOfBytes(Locatable localizacionDelError) {
        if(this.campos.isEmpty()) {
            new ErrorType("No es posible obtener el numero de bytes de un campo del record por estar vacio dicho record", localizacionDelError);
            return 0;
        }
        return this.campos.getFirst().getTipo().numberOfBytes();
    }

    @Override
    public String toString() {
        return "record";
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
