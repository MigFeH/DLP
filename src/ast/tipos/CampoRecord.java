package ast.tipos;

import ast.locatable.AbstractLocatable;
import visitor.Visitor;

public class CampoRecord extends AbstractLocatable {

    private Tipo tipo;
    private String nombre;
    private int offset;

    public CampoRecord(int linea, int columna, Tipo tipo, String nombre) {
        super(linea, columna);
        this.tipo = tipo;
        this.nombre = nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
