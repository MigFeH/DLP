package ast.expresiones;

import visitor.Visitor;

public class Negacion extends AbstractExpresion {

    private Expresion operando;

    public Negacion(int linea, int columna,
                    Expresion operando) {
        super(linea, columna);
        this.operando = operando;
    }

    public Expresion getOperando() {
        return this.operando;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
