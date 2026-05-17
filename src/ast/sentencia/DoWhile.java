package ast.sentencia;

import ast.expresiones.Expresion;
import ast.locatable.AbstractLocatable;
import visitor.Visitor;

import java.util.List;

public class DoWhile extends AbstractLocatable implements Sentencia {

    private List<Sentencia> cuerpo;
    private Expresion condicion;

    public DoWhile(int linea, int columna,
                   List<Sentencia> cuerpo,
                   Expresion condicion) {
        super(linea, columna);
        this.cuerpo = cuerpo;
        this.condicion = condicion;
    }

    public List<Sentencia> getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(List<Sentencia> cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Expresion getCondicion() {
        return condicion;
    }

    public void setCondicion(Expresion condicion) {
        this.condicion = condicion;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
