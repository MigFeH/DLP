package ast.expresiones;

import ast.ASTNode;
import ast.locatable.AbstractLocatable;
import visitor.Visitor;

public class ConstanteCaracter extends AbstractExpresion implements ASTNode {

    private char valor;

    public ConstanteCaracter(int linea, int columna,
                             char valor) {
        super(linea, columna);
        this.valor = valor;
    }

    public char getValor() {
        return valor;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
