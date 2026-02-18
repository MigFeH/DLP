package ast.expresiones;

import ast.locatable.AbstractLocatable;
import ast.tipos.Tipo;

public class Cast extends AbstractLocatable implements Expresion{

    private Expresion izquierda;
//    private TipoSimple nuevoTipo; // cambiar a type
    private Tipo derecha;

    public Cast(int linea, int columna,
                Expresion izquierda,
                Tipo derecha) {
        super(linea, columna);
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    public Expresion getIzquierda() {
        return this.izquierda;
    }

    public Tipo getDerecha() {
        return this.derecha;
    }

}
