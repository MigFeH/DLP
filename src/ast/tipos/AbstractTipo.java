package ast.tipos;

import ast.locatable.Locatable;

import java.util.List;

public abstract class AbstractTipo implements Tipo {

    @Override
    public void mustBeLogical(Locatable localizacionDelError) {
        new ErrorType("El tipo \"" + this + "\" no es de tipo logico", localizacionDelError);
    }

    @Override
    public Tipo mustPromotesTo(Tipo other, Locatable localizacionDelError) {
        if(other instanceof ErrorType) {
            return other;
        }
        return new ErrorType("El tipo \"" + this + "\" no promociona al tipo \"" + other + "\"", localizacionDelError);
    }

    @Override
    public void mustBeSimpleType(Locatable localizacionDelError) {
        new ErrorType("El tipo \"" + this + "\" no es de tipo simple", localizacionDelError);
    }

    @Override
    public void mustBeMain(Locatable localizacionDelError) {
        new ErrorType("El tipo \"" + this + "\" no se corresponde con el tipo de una funcion main", localizacionDelError);
    }

    @Override
    public void mustBeFunctionType(Locatable localizacionDelError) {
        new ErrorType("El tipo \"" + this + "\" no se corresponde con el tipo de una funcion", localizacionDelError);
    }

    @Override
    public void mustBeIterable(Tipo tipoIterador, Locatable localizacionDelError) {
        new ErrorType("El tipo \"" + this + "\" no es iterable", localizacionDelError);
    }

    @Override
    public Tipo arithmetic(Tipo other, Locatable localizacionDelError) {
        if(other instanceof ErrorType) {
            return other;
        }
        return new ErrorType("Operacion aritmetica no soportada para el tipo \"" + this + "\"", localizacionDelError);
    }

    @Override
    public Tipo comparison(Tipo other, Locatable localizacionDelError) {
        if(other instanceof ErrorType) {
            return other;
        }
        return new ErrorType("Operacion comparacion no soportada para el tipo \"" + this + "\"", localizacionDelError);
    }

    @Override
    public Tipo unaryMinus(Locatable localizacionDelError) {
        return new ErrorType("Operacion menos unario no soportada para el tipo \"" + this + "\"", localizacionDelError);
    }

    @Override
    public Tipo squareBrackets(Tipo other, Locatable localizacionDelError) {
        if(other instanceof ErrorType) {
            return other;
        }
        return new ErrorType("Operacion acceso array no soportada para el tipo \"" + this + "\"", localizacionDelError);
    }

    @Override
    public Tipo dot(String fieldName, Locatable localizacionDelError) {
        return new ErrorType("Operacion acceso campo no soportada para el tipo \"" + this + "\"", localizacionDelError);
    }

    @Override
    public Tipo parenthesis(List<Tipo> typeParams, Locatable localizacionDelError) {
        return new ErrorType("Operacion invocacion no soportada para el tipo \"" + this + "\"", localizacionDelError);
    }

    @Override
    public Tipo cast(Tipo other, Locatable localizacionDelError) {
        if(other instanceof ErrorType) {
            return other;
        }
        return new ErrorType("Operacion cast no soportada para el tipo \"" + this + "\" siendo casteado al tipo \"" + other + "\"", localizacionDelError);
    }

    @Override
    public Tipo logical(Tipo other, Locatable localizacionDelError) {
        if(other instanceof ErrorType) {
            return other;
        }
        return new ErrorType("El tipo \"" + this + "\" junto al tipo \"" + other + "\" no forman un tipo logico", localizacionDelError);
    }

    @Override
    public Tipo logical(Locatable localizacionDelError) {
        return new ErrorType("El tipo \"" + this + "\" no es un tipo logico", localizacionDelError);
    }

    @Override
    public int numberOfBytes() {
        throw new UnsupportedOperationException();
    }

    @Override
    public char suffix() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isSimpleType() {
        return false;
    }

    @Override
    public int getNumberOfElements() {
        throw new UnsupportedOperationException();
    }
}
