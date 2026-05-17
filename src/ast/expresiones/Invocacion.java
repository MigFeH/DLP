package ast.expresiones;

import ast.sentencia.Sentencia;
import visitor.Visitor;

import java.util.List;

public class Invocacion extends AbstractExpresion implements Sentencia {

    private Variable invocado;
    private List<Expresion> argumentos;

    public Invocacion(int linea, int columna,
                      Variable invocado,
                      List<Expresion> argumentos) {
        super(linea, columna);
        this.invocado = invocado;
        this.argumentos = argumentos;
    }

    public Variable getInvocado() {
        return this.invocado;
    }

    public List<Expresion> getArgumentos() {
        return this.argumentos;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }

}
