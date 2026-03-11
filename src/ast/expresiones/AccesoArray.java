package ast.expresiones;

import ast.ASTNode;
import visitor.Visitor;

public class AccesoArray extends AbstractExpresion implements ASTNode {

    private Expresion izquierda;
    private Expresion derecha; // la parte derecha es el interior de []

    public AccesoArray(int linea, int columna,
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

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }

}
