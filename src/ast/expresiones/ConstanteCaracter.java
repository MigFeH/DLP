package ast.expresiones;

import ast.locatable.AbstractLocatable;

public class ConstanteCaracter extends AbstractLocatable implements Expresion {

    private char valor;

    public ConstanteCaracter(int linea, int columna,
                             char valor) {
        super(linea, columna);
        this.valor = valor;
    }

    public char getValor() {
        return valor;
    }
}
