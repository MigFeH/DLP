package ast.expresiones;

import ast.locatable.AbstractLocatable;

public class Negacion extends AbstractLocatable implements Expresion {

    private Expresion operando;

    public Negacion(int linea, int columna,
                    Expresion operando) {
        super(linea, columna);
        this.operando = operando;
    }

    public Expresion getOperando() {
        return this.operando;
    }
}
