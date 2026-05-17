package ast.sentencia;

import ast.expresiones.Expresion;
import ast.locatable.AbstractLocatable;
import visitor.Visitor;

public class Return extends AbstractLocatable implements Sentencia {

    private Expresion expresion;

    public Return(int linea, int columna,
                  Expresion expresion) {
        super(linea, columna);
        this.expresion = expresion;
    }

    public Expresion getExpresion() {
        return this.expresion;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
