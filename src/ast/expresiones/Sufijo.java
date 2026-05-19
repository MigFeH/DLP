package ast.expresiones;

import ast.sentencia.Sentencia;
import visitor.Visitor;

public class Sufijo extends AbstractExpresion implements Sentencia {

    private Expresion operando;
    private String operador;

    public Sufijo(int linea, int columna,
                  Expresion operando, String operador) {
        super(linea, columna);
        this.operando = operando;
        this.operador = operador;
    }

    public Expresion getOperando() {
        return operando;
    }

    public void setOperando(Expresion operando) {
        this.operando = operando;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
