package ast.constantes;

import ast.locatable.AbstractLocatable;

public class ConstanteReal extends AbstractLocatable {

    private double valor;

    public ConstanteReal(int linea, int columna,
                         double valor) {
        super(linea, columna);
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}
