package ast.sentencia;

import ast.ASTNode;
import ast.expresiones.Expresion;
import ast.locatable.AbstractLocatable;
import visitor.Visitor;

import java.util.List;

public class If extends AbstractLocatable implements Sentencia, ASTNode {

    private Expresion condicion;
    private List<Sentencia> cuerpo;
    private List<Sentencia> cuerpoElse;

    public If(int linea, int columna,
              Expresion condicion,
              List<Sentencia> cuerpo,
              List<Sentencia> cuerpoElse) {
        super(linea, columna);
        this.condicion = condicion;
        this.cuerpo = cuerpo;
        this.cuerpoElse = cuerpoElse;
    }

    public Expresion getCondicion() {
        return this.condicion;
    }

    public List<Sentencia> getCuerpo() {
        return this.cuerpo;
    }

    public List<Sentencia> getCuerpoElse() {
        return this.cuerpoElse;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
