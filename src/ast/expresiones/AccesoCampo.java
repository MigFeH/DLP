package ast.expresiones;

import ast.ASTNode;
import ast.locatable.AbstractLocatable;
import visitor.Visitor;

public class AccesoCampo extends AbstractExpresion implements ASTNode {

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

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }

}
