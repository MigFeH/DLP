package ast.definiciones;

import ast.sentencia.Sentencia;

import java.util.List;

public class DefinicionFunc extends AbstractDefinicion {

    private List<DefinicionVar> definicionesVariables;
    private List<Sentencia> sentencias;

    public DefinicionFunc(int linea, int columna,
                          Tipo tipo, String nombre,
                          List<DefinicionVar> definicionesVariables,
                          List<Sentencia> sentencias) {
        super(linea, columna, tipo, nombre);
        this.definicionesVariables = definicionesVariables;
        this.sentencias  = sentencias;
    }

}
