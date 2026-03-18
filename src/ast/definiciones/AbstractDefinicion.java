package ast.definiciones;

import ast.locatable.AbstractLocatable;
import ast.tipos.Tipo;

public abstract class AbstractDefinicion extends AbstractLocatable implements Definicion {

    private Tipo tipo;
    private String nombre;
    private int scope;

    public AbstractDefinicion(int linea, int columna,
                              Tipo tipo, String nombre) {
        super(linea, columna);
        this.tipo = tipo;
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public Tipo getTipo() {
        return this.tipo;
    }

    @Override
    public int getScope() {
        return scope;
    }

    @Override
    public void setScope(int scope) {
        this.scope = scope;
    }
}
