package ast.sentencia;

import ast.expresiones.Expresion;
import ast.locatable.AbstractLocatable;

import java.util.List;

public class If extends AbstractLocatable implements Sentencia {

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

}
