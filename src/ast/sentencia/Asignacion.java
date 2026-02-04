package ast.sentencia;

import ast.locatable.AbstractLocatable;

public class Asignacion extends AbstractLocatable implements Sentencia {

    private Expresion izquierda;
    private Expresion derecha;

    public Asignacion(int linea, int columna,
                      Expresion izquierda, Expresion derecha) {
        super(linea, columna);
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    public Expresion getIzquierda() {
        return this.izquierda;
    }

    public Expresion getDerecha() {
        return this.derecha;
    }

}
