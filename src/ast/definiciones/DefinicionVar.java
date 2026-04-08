package ast.definiciones;

import ast.ASTNode;
import ast.tipos.Tipo;
import visitor.Visitor;

public class DefinicionVar extends AbstractDefinicion implements ASTNode {

    private int offset;

    public DefinicionVar(int linea, int columna,
                         Tipo tipo, String nombre) {
        super(linea, columna, tipo, nombre);
    }

    public DefinicionVar(int linea, int columna,
                         String nombre, Tipo tipo) {
        this(linea, columna, tipo, nombre);
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }

}
