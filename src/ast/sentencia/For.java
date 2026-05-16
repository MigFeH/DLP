package ast.sentencia;

import ast.expresiones.Expresion;
import ast.locatable.AbstractLocatable;
import visitor.Visitor;

import java.util.List;

public class For extends AbstractLocatable implements Sentencia {

    private List<Sentencia> inicio;
    private Expresion fin;
    private Sentencia salto;
    private List<Sentencia> cuerpo;

    public For(int linea, int columna,
               List<Sentencia> inicio, Expresion fin, Sentencia salto,
               List<Sentencia> cuerpo) {
        super(linea, columna);
        this.inicio = inicio;
        this.fin = fin;
        this.salto = salto;
        this.cuerpo = cuerpo;
    }

    public boolean isVariableInicioDefinidaInFor() {
        return this.inicio.size() > 1;
    }

    public List<Sentencia> getInicio() {
        return inicio;
    }

    public void setInicio(List<Sentencia> inicio) {
        this.inicio = inicio;
    }

    public Expresion getFin() {
        return fin;
    }

    public void setFin(Expresion fin) {
        this.fin = fin;
    }

    public Sentencia getSalto() {
        return salto;
    }

    public void setSalto(Sentencia salto) {
        this.salto = salto;
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
