package ast.sentencia;

import ast.expresiones.Expresion;
import ast.locatable.AbstractLocatable;
import visitor.Visitor;

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

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
