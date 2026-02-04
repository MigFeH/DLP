package ast.expresiones;

import ast.locatable.AbstractLocatable;

public class MenosUnario extends AbstractLocatable implements Expresion {

    private Expresion operando;

    public MenosUnario(int linea, int columna,
                       Expresion operando) {
        super(linea, columna);
        this.operando = operando;
    }

    public Expresion getOperando() {
        return this.operando;
    }

}
