package ast.sentencia;

import ast.locatable.AbstractLocatable;

import java.util.List;

public class Return extends AbstractLocatable implements Sentencia {

    private Expresion expresion;

    public Return(int linea, int columna,
                  Expresion expresion) {
        super(linea, columna);
        this.expresion = expresion;
    }

    public Expresion getExpresion() {
        return this.expresion;
    }
}
