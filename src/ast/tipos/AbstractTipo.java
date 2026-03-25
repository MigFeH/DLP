package ast.tipos;

import ast.locatable.Locatable;

public abstract class AbstractTipo implements Tipo {

    @Override
    public void mustBeLogical(Locatable localizacionDelError) {
        new ErrorType("El tipo " + this + " no es de tipo logico", localizacionDelError);
    }

    @Override
    public Tipo aritmetico(Tipo other, Locatable localizacionDelError) {
        if(other instanceof ErrorType) {
            return other;
        }

        // el this es la parte izquierda de la operacion aritmetica
        return new ErrorType("Operacion aritmetica no soportada para el tipo " + this, localizacionDelError);
    }

}
