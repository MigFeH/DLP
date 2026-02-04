package ast.expresiones;

import ast.locatable.AbstractLocatable;
import ast.tipos.simples.TipoSimple;

public class Cast extends AbstractLocatable implements Expresion{

    private Expresion convertir;
    private TipoSimple nuevoTipo;

    public Cast(int linea, int columna,
                Expresion convertir,
                TipoSimple nuevoTipo) {
        super(linea, columna);
        this.convertir = convertir;
        this.nuevoTipo = nuevoTipo;
    }

    public Expresion getConvertir() {
        return this.convertir;
    }

    public TipoSimple getNuevoTipo() {
        return this.nuevoTipo;
    }

}
