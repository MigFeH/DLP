package ast.constantes;

import ast.locatable.AbstractLocatable;

public class ConstanteInt extends AbstractLocatable {

    private int valor;

    public ConstanteInt(int linea, int columna,
                        int valor) {
        super(linea, columna);
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
