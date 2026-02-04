package ast.sentencia;

import ast.locatable.AbstractLocatable;

import java.util.List;

public class While extends AbstractLocatable implements Sentencia {

    private Expresion condicion;
    private List<Sentencia> cuerpo;

    public While(int linea, int columna,
                 Expresion condicion,
                 List<Sentencia> cuerpo) {
        super(linea, columna);
        this.condicion = condicion;
        this.cuerpo = cuerpo;
    }
}
