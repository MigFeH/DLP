package ast.locatable;

public abstract class AbstractLocatable implements Locatable {

    private int linea;
    private int columna;

    public AbstractLocatable(int linea, int columna) {
        this.linea = linea;
        this.columna = columna;
    }

    @Override
    public int getLinea() {
        return this.linea;
    }

    @Override
    public int getColumna() {
        return this.columna;
    }
}
