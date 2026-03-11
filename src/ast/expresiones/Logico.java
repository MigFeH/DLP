package ast.expresiones;

import ast.ASTNode;
import ast.locatable.AbstractLocatable;
import visitor.Visitor;

public class Logico extends AbstractExpresion implements ASTNode {

    private Expresion izquierda;
    private String operador;
    private Expresion derecha;

    public Logico(int linea, int columna,
                  Expresion izquierda,
                  String operador,
                  Expresion derecha) {
        super(linea, columna);
        this.izquierda = izquierda;
        this.operador = operador;
        this.derecha = derecha;
    }

    public Expresion getIzquierda() {
        return this.izquierda;
    }

    public String getOperador() {
        return this.operador;
    }

    public Expresion getDerecha() {
        return this.derecha;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
