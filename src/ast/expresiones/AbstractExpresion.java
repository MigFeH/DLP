package ast.expresiones;

import ast.locatable.AbstractLocatable;

public abstract class AbstractExpresion extends AbstractLocatable implements Expresion {
    private boolean lValue;

    public AbstractExpresion(int linea, int columna) {
        super(linea, columna);
    }

    @Override
    public boolean getLValue() {
        return this.lValue;
    }

    @Override
    public void setLValue(boolean value) {
        this.lValue = value;
    }
}
