package ast.expresiones;

import ast.locatable.AbstractLocatable;
import ast.sentencia.Sentencia;

import java.util.List;

public class Invocacion extends AbstractLocatable implements Expresion, Sentencia {

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

}
