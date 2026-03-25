package ast.expresiones;

import ast.locatable.AbstractLocatable;
import ast.tipos.Tipo;

public abstract class AbstractExpresion extends AbstractLocatable implements Expresion {
    private boolean lValue;
    private Tipo tipo;

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

    @Override
    public Tipo getTipo() {
        return this.tipo;
    }

    @Override
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
