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
    public Tipo dot(String fieldName, Locatable localizacionDelError) {
        Optional<CampoRecord> campoRecordAccedido = campos.stream().filter(campoRecord -> campoRecord.getNombre().equals(fieldName)).findFirst();
        return campoRecordAccedido.isPresent() ?
                campoRecordAccedido.get().getTipo()
                    :
                new ErrorType("Campo record \"" + fieldName + "\" no existente", localizacionDelError);
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
