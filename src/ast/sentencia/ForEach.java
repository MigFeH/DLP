package ast.sentencia;

import ast.expresiones.Expresion;
import ast.locatable.AbstractLocatable;
import visitor.Visitor;

import java.util.List;

public class ForEach extends AbstractLocatable implements Sentencia {

    private Expresion iterador;
    private Expresion datos;
    private List<Sentencia> cuerpo;

    public ForEach(int linea, int columna,
                   Expresion iterador, Expresion datos,
                   List<Sentencia> cuerpo) {
        super(linea, columna);
        this.iterador = iterador;
        this.datos = datos;
        this.cuerpo = cuerpo;
    }

    public Expresion getIterador() {
        return iterador;
    }

    public void setIterador(Expresion iterador) {
        this.iterador = iterador;
    }

    public Expresion getDatos() {
        return datos;
    }

    public void setDatos(Expresion datos) {
        this.datos = datos;
    }

    public List<Sentencia> getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(List<Sentencia> cuerpo) {
        this.cuerpo = cuerpo;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
