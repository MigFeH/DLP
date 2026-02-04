package ast.tipos;

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
}
