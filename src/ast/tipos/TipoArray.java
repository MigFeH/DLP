package ast.tipos;

import visitor.Visitor;

public class TipoArray implements Tipo {

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
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
