package ast.sentencia;

import ast.expresiones.Expresion;
import ast.locatable.AbstractLocatable;

import java.util.List;

public class Log extends AbstractLocatable implements Sentencia {

    private List<Expresion> expresiones;

    public Log(int linea, int columna,
               List<Expresion> expresiones) {
        super(linea, columna);
        this.expresiones = expresiones;
    }

    public List<Expresion> getExpresiones() {
        return this.expresiones;
    }
}
