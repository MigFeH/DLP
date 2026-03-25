package ast.tipos;

import ast.locatable.Locatable;
import visitor.Visitor;

public class TipoArray extends AbstractTipo {

    private Tipo tipoElemento;
    private int size;

    public TipoArray(Tipo tipoElemento, int size) {
        this.tipoElemento = tipoElemento;
        this.size = size;
    }

    public Tipo getTipoElemento() {
        return this.tipoElemento;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public Tipo arithmetic(Tipo other, Locatable localizacionDelError) {
        return new ErrorType("El tipo array no soporta una operacion aritmetica", localizacionDelError);
    }

    @Override
    public Tipo squareBrackets(Tipo other, Locatable localizacionDelError) {
        if(!(other.mustPromotesTo(TipoInt.getInstance(), localizacionDelError) instanceof ErrorType)) {
            return tipoElemento;
        }
        return new ErrorType("Operacion acceso array no soportada para el tipo del indice \"" + other + "\"", localizacionDelError);
    }

    @Override
    public String toString() {
        return "array";
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
