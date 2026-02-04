package ast.expresiones;

import ast.locatable.AbstractLocatable;

public class Variable extends AbstractLocatable implements Expresion {

    private String nombre;

    public Variable(int linea, int columna,
                    String nombre) {
        super(linea, columna);
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

}
