package ast.tipos;

import ast.locatable.Locatable;

import java.util.List;

public abstract class AbstractTipo implements Tipo {

    /**
     * Comprueba que, dado un tipo (this), DEBE ser logico.
     * En nuesto lenguaje modelamos el tipo boolean con enteros de la siguiente forma:
     *      valor false == 0
     *      valor true != 0
     * Los tipos logicos (que soportan operaciones logicas [int y char] tendran vacío este metodo).
     * Los tipos que NO logicos (que NO soportan la operacion) instanciaran un ErrorType
     * @param localizacionDelError, el locatable que puede contener el error
     * @return true si el tipo this es logico, false en caso contrario
     */
    @Override
    public boolean mustBeLogical(Locatable localizacionDelError) {
        if(!(this instanceof ErrorType)) {
            new ErrorType("El tipo \"" + this + "\" no es de tipo logico", localizacionDelError);
        }
        return false;
    }

    /**
     * Comprueba que, dado un tipo other, el tipo this debe promocionar al tipo other.
     * En caso de no cumplirse lo mencionado se instancia un ErrorType.
     * @param other, el tipo al que debe promocionar el tipo this
     * @param localizacionDelError, el locatable que puede contener el error
     * @return el tipo inferido resultante de la promocion
     */
    @Override
    public Tipo mustPromotesTo(Tipo other, Locatable localizacionDelError) {
        /*
         * Este metodo puede devolver algo si lo usamos en mas sitios y necesitamos saber el "resultado de la promocion"
         * lo usamos en el log, input, return, asignacion, ...
         * */
        if(other instanceof ErrorType) {
            return new ErrorType("El tipo \"" + this + "\" no promociona al tipo \"" + other + "\"", localizacionDelError);
        }
        return other;
    }

    @Override
    public void mustBeSimpleType(Locatable localizacionDelError) {
        // lo USAMOS para comprobar que una funcion retorna y recibe tipos simples
        if(!(this instanceof ErrorType)) {
            new ErrorType("El tipo \"" + this + "\" no es de tipo simple", localizacionDelError);
        }
    }

    @Override
    public void mustBeMain(Locatable localizacionDelError) {
        // lo implementa function y debe comprobar que sea void, que no tenga parametros, que su nombre sea main, etc
        if(!(this instanceof ErrorType)) {
            new ErrorType("El tipo \"" + this + "\" no se corresponde con el tipo de una funcion main", localizacionDelError);
        }
    }

    @Override
    public void mustBeFunctionType(Locatable localizacionDelError) {
        if(!(this instanceof ErrorType)) {
            new ErrorType("El tipo \"" + this + "\" no se corresponde con el tipo de una funcion", localizacionDelError);
        }
    }

    @Override
    public Tipo arithmetic(Tipo other, Locatable localizacionDelError) {
        // other es el tipo de la derecha de la operacion aritmetica. el tipo de la izquierda sera el this. Devuelve el tipo de la expresion resultante (el tipo inferido de la expresion)
        if(other instanceof ErrorType) {
            return other;
        }
        // el this es la parte izquierda de la operacion aritmetica
        return new ErrorType("Operacion aritmetica no soportada para el tipo \"" + this + "\"", localizacionDelError);
    }

    @Override
    public Tipo comparison(Tipo other, Locatable localizacionDelError) {
        Tipo tipoInferido = this.mustPromotesTo(other, localizacionDelError);
        if(!(tipoInferido instanceof ErrorType) && tipoInferido.mustBeLogical(localizacionDelError)) {
            return tipoInferido;
        } else {
            return new ErrorType("Operacion comparacion no soportada para el tipo \"" + this + "\" con el tipo \"" + other + "\"", localizacionDelError);
        }
    }

    @Override
    public Tipo unaryMinus(Locatable localizacionDelError) {
        return new ErrorType("Operacion menos unario no soportada para el tipo \"" + this + "\"", localizacionDelError);
    }

    @Override
    public Tipo squareBrackets(Tipo other, Locatable localizacionDelError) {
        // other es el tipo del indice del array. other debe ser int o promocionar a int. this sera el TipoArray. El tipo que se retorna en este metodo es el tipo de los elementos del array
        return new ErrorType("Operacion acceso array no soportada para el tipo \"" + this + "\"", localizacionDelError);
    }

    @Override
    public Tipo dot(String fieldName, Locatable localizacionDelError) {
        // es la operacion de acceso a campo.
        return new ErrorType("Operacion acceso campo no soportada para el tipo \"" + this + "\"", localizacionDelError);
    }

    @Override
    public Tipo parenthesis(List<Tipo> typeParams, Locatable localizacionDelError) {
        // es la operacion de invocacion a funcion. El tipo que devuelve es el tipo del retorno de la funcion
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
}
