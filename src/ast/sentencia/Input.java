package ast.sentencia;

import ast.locatable.AbstractLocatable;

import java.util.List;

public class Input extends AbstractLocatable implements Sentencia {

    private List<Expresion> expresiones;

    public Input(int linea, int columna,
                 List<Expresion> expresiones) {
        super(linea, columna);
        this.expresiones = expresiones;
    }

    public List<Expresion> getExpresiones() {
        return this.expresiones;
    }

}
