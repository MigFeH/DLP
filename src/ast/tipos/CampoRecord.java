package ast.tipos;

import ast.definiciones.DefinicionVar;
import ast.locatable.AbstractLocatable;

public class CampoRecord extends AbstractLocatable {

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

}
