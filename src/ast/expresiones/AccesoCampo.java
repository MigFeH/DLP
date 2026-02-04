package ast.expresiones;

import ast.locatable.AbstractLocatable;

public class AccesoCampo extends AbstractLocatable implements Expresion {

    private Expresion izquierda;
    private String nombreCampo;

    public AccesoCampo(int linea, int columna,
                       Expresion izquierda,
                       String nombreCampo) {
        super(linea, columna);
        this.izquierda = izquierda;
        this.nombreCampo = nombreCampo;
    }

    public Expresion getIzquierda() {
        return this.izquierda;
    }

    public String getNombreCampo() {
        return this.nombreCampo;
    }

}
