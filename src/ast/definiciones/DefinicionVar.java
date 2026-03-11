package ast.definiciones;

import ast.ASTNode;
import ast.tipos.Tipo;
import visitor.Visitor;

public class DefinicionVar extends AbstractDefinicion implements ASTNode {

    public DefinicionVar(int linea, int columna,
                         Tipo tipo, String nombre) {
        super(linea, columna, tipo, nombre);
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }

}
