package ast.definiciones;

import ast.locatable.AbstractLocatable;

public class AbstractDefinicion extends AbstractLocatable implements Definicion {

    private String tipo;
    private String nombre;

    public AbstractDefinicion(int linea, int columna,
                              String tipo, String nombre) {
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
}
