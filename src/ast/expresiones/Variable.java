package ast.expresiones;

import ast.ASTNode;
import ast.locatable.AbstractLocatable;
import visitor.Visitor;

public class Variable extends AbstractExpresion implements ASTNode {

    private String nombre;

    public Variable(int linea, int columna,
                    String nombre) {
        super(linea, columna);
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

}
