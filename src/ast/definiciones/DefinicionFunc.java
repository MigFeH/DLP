package ast.definiciones;

import ast.locatable.AbstractLocatable;

import java.util.List;

public class DefinicionFunc extends AbstractLocatable implements Definicion {

    private Tipo tipo;
    private String nombre;

    private List<DefinicionVar> definicionesVariables;
    private List<Sentencia> sentencias;

    public DefinicionFunc(int linea, int columna,
                          Tipo tipo, String nombre,
                          List<DefinicionVar> definicionesVariables,
                          List<Sentencia> sentencias) {
        super(linea, columna);
        this.tipo = tipo;
        this.nombre = nombre;
        this.definicionesVariables = definicionesVariables;
        this.sentencias  = sentencias;
    }


    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public Tipo getTipo() {
        return this.tipo;
    }
}
