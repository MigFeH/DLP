package ast.expresiones;

import ast.locatable.AbstractLocatable;

public class AccesoCampo extends AbstractLocatable implements Expresion {

    private Expresion izquierda;
//    private String nombreCampo;
    private Expresion derecha;

    public AccesoCampo(int linea, int columna,
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
