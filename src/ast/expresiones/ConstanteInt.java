package ast.expresiones;

import ast.locatable.AbstractLocatable;

public class ConstanteInt extends AbstractLocatable implements Expresion {

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
