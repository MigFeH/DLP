package ast.sentencia;

import ast.ASTNode;
import ast.expresiones.Expresion;
import ast.locatable.AbstractLocatable;
import visitor.Visitor;

import java.util.List;

public class While extends AbstractLocatable implements Sentencia, ASTNode {

    private Expresion condicion;
    private List<Sentencia> cuerpo;

    public While(int linea, int columna,
                 Expresion condicion,
                 List<Sentencia> cuerpo) {
        super(linea, columna);
        this.condicion = condicion;
        this.cuerpo = cuerpo;
    }

    public Expresion getCondicion() {
        return this.condicion;
    }

    public List<Sentencia> getCuerpo() {
        return this.cuerpo;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }

}
