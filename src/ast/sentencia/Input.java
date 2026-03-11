package ast.sentencia;

import ast.ASTNode;
import ast.expresiones.Expresion;
import ast.locatable.AbstractLocatable;
import visitor.Visitor;

import java.util.List;

public class Input extends AbstractLocatable implements Sentencia, ASTNode {

    private List<Expresion> expresiones;

    public Input(int linea, int columna,
                 List<Expresion> expresiones) {
        super(linea, columna);
        this.expresiones = expresiones;
    }

    public List<Expresion> getExpresiones() {
        return this.expresiones;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
