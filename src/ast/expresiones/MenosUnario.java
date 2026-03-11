package ast.expresiones;

import ast.ASTNode;
import ast.locatable.AbstractLocatable;
import visitor.Visitor;

public class MenosUnario extends AbstractExpresion implements ASTNode {

    private Expresion operando;

    public MenosUnario(int linea, int columna,
                       Expresion operando) {
        super(linea, columna);
        this.operando = operando;
    }

    public Expresion getOperando() {
        return this.operando;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }

}
