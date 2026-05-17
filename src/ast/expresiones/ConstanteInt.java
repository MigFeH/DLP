package ast.expresiones;

import visitor.Visitor;

public class ConstanteInt extends AbstractExpresion {

    private int valor;

    public ConstanteInt(int linea, int columna,
                        int valor) {
        super(linea, columna);
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
