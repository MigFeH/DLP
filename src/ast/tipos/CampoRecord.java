package ast.tipos;

import ast.ASTNode;
import ast.definiciones.DefinicionVar;
import ast.locatable.AbstractLocatable;
import visitor.Visitor;

public class CampoRecord extends AbstractLocatable implements ASTNode {

    private Tipo tipo;
    private String nombre;

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

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
