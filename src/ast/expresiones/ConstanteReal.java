package ast.expresiones;

import visitor.Visitor;

public class ConstanteReal extends AbstractExpresion {

    private double valor;

    public ConstanteReal(int linea, int columna,
                         double valor) {
        super(linea, columna);
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
