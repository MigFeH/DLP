package ast.expresiones;

import ast.locatable.AbstractLocatable;

public class Comparador extends AbstractLocatable implements Expresion {

    private Expresion izquierda;
    private Expresion derecha;

    public Comparador(int linea, int columna,
                      Expresion izquierda,
                      Expresion derecha) {
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
