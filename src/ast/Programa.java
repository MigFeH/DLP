package ast;

import ast.definiciones.Definicion;
import visitor.Visitor;

import java.util.List;

public class Programa implements ASTNode {

    private List<Definicion> definiciones;

    public Programa(List<Definicion> definiciones) {
        this.definiciones = definiciones;
    }

    public List<Definicion> getDefiniciones() {
        return this.definiciones;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
