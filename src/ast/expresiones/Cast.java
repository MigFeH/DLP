package ast.expresiones;

import ast.ASTNode;
import ast.locatable.AbstractLocatable;
import ast.tipos.Tipo;
import visitor.Visitor;

public class Cast extends AbstractExpresion implements ASTNode {

    private Expresion izquierda;
    private Tipo derecha;

    public Cast(int linea, int columna,
                Expresion izquierda,
                Tipo derecha) {
        super(linea, columna);
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    public Expresion getIzquierda() {
        return this.izquierda;
    }

    public Tipo getDerecha() {
        return this.derecha;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
