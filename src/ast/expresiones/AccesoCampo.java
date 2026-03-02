package ast.expresiones;

import ast.locatable.AbstractLocatable;

public class AccesoCampo extends AbstractLocatable implements Expresion {

    private Expresion izquierda;
    private String derecha; // la parte derecha del punto

    public AccesoCampo(int linea, int columna,
                       Expresion izquierda,
                       String derecha) {
        super(linea, columna);
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    public Expresion getIzquierda() {
        return this.izquierda;
    }

    public String getDerecha() {
        return this.derecha;
    }

}
