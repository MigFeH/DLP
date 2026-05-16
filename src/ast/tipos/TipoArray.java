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
    public Tipo squareBrackets(Tipo other, Locatable localizacionDelError) {
        if(other == TipoInt.getInstance() || other == TipoChar.getInstance()) {
            return this.tipoElemento;
        }
        return super.squareBrackets(other, localizacionDelError);
    }

    @Override
    public int numberOfBytes() {
        return tipoElemento.numberOfBytes() * size;
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
