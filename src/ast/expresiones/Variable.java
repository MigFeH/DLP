package ast.expresiones;

import ast.definiciones.Definicion;
import visitor.Visitor;

public class Variable extends AbstractExpresion {

    private String nombre;
    private Definicion definicion;

    public Variable(int linea, int columna,
                    String nombre) {
        super(linea, columna);
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setDefinicion(Definicion definicion) {
        this.definicion = definicion;
    }

    public Definicion getDefinicion() {
        return definicion;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

}
