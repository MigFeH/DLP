package ast.constantes;

import ast.locatable.AbstractLocatable;

public class ConstanteCaracter extends AbstractLocatable {

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
