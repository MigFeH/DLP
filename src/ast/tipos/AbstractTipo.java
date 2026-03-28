package ast.tipos;

import ast.locatable.Locatable;

import java.util.List;

public abstract class AbstractTipo implements Tipo {

    /**
     * Comprueba que el tipo DEBE ser logico, en caso de no serlo se instancia un ErrorType.
     * En nuesto lenguaje modelamos el tipo boolean con enteros de la siguiente forma:
     *      valor false == 0
     *      valor true != 0
     * @param localizacionDelError, el locatable que puede contener el error
     */
    @Override
    public void mustBeLogical(Locatable localizacionDelError) {
        new ErrorType("El tipo \"" + this + "\" no es de tipo logico", localizacionDelError);
    }

    /**
     * Comprueba que, dado un tipo other, el tipo this DEBE promocionar al tipo other, y devuelve el tipo inferido
     * resultante de la promocion.
     * @param other, el tipo al que debe promocionar el tipo this
     * @param localizacionDelError, el locatable que puede contener el error
     * @return el tipo inferido resultante de la promocion, o una instancia de ErrorType en caso de que:
     *      - No es posible realizar la promocion de tipos por incompatibilidad
     */
    @Override
    public Tipo mustPromotesTo(Tipo other, Locatable localizacionDelError) {
        if(other instanceof ErrorType) {
            return other;
        }
        return new ErrorType("El tipo \"" + this + "\" no promociona al tipo \"" + other + "\"", localizacionDelError);
    }

    /**
     * Comprueba que el tipo this sea un tipo simple/built-in (TipoInt, TipoNumber o TipoChar),
     * en caso de no serlo instancia un ErrorType.
     * @param localizacionDelError, el locatable que puede contener el error
     */
    @Override
    public void mustBeSimpleType(Locatable localizacionDelError) {
        new ErrorType("El tipo \"" + this + "\" no es de tipo simple", localizacionDelError);
    }

    /**
     * Comprueba que el tipo this sea un TipoFuncion y que la definicion de la funcion de dicho tipo se corresponda
     * con una serie de requisitos propios de una funcion main:
     *      - Tipo de retorno => void
     *      - Parametros que recibe => ninguno
     *      - Nombre de la funcion => main (not case sensitive)
     * En caso de no cumplirse algo de lo mencionado anteriormente instancia un ErrorType
     * @param localizacionDelError, el locatable que puede contener el error
     */
    @Override
    public void mustBeMain(Locatable localizacionDelError) {
        new ErrorType("El tipo \"" + this + "\" no se corresponde con el tipo de una funcion main", localizacionDelError);
    }

    /**
     * Comprueba que el tipo this sea un TipoFuncion y que la definicion de la funcion de dicho tipo cumpla con una serie de requisitos:
     *      - Tanto el tipo de los parametros como el de retorno (si no es void) deben ser tipos simples/built-in (TipoInt, TipoNumber o TipoChar)
     * En caso de no cumplirse algo de lo mencionado anteriormente instancia un ErrorType
     * @param localizacionDelError, el locatable que puede contener el error
     */
    @Override
    public void mustBeFunctionType(Locatable localizacionDelError) {
        new ErrorType("El tipo \"" + this + "\" no se corresponde con el tipo de una funcion", localizacionDelError);
    }

    /**
     * Realiza la comprobacion de tipos de una operacion aritmetica (+, -, *, /, %) y devuelve el tipo resultante de la
     * inferencia de tipos de la operacion.
     * En caso de no ser posible realizar la operacion aritmetica por falta de compatibilidad de, al menos, uno de los
     * operandos o cualquier otra circunstancia instancia un ErrorType
     * @param other, el segundo operando de la operacion aritmetica
     * @param localizacionDelError, el locatable que puede contener el error
     * @return el tipo inferido resultante de la operacion aritmetica, o una instancia de ErrorType en caso de no ser
     * posible realizar la operacion aritmetica
     */
    @Override
    public Tipo arithmetic(Tipo other, Locatable localizacionDelError) {
        if(other instanceof ErrorType) {
            return other;
        }
        return new ErrorType("Operacion aritmetica no soportada para el tipo \"" + this + "\"", localizacionDelError);
    }

    /**
     * Realiza la comprobacion de tipos de una operacion de comparacion (>, >=, <, <=, !=, ==) y devuelve el tipo
     * resultante de la inferencia de tipos de la operacion.
     * En caso de no ser posible realizar la operacion de comparacion por falta de compatibilidad de, al menos, uno de
     * los operandos instancia un ErrorType
     * @param other, el segundo operando de la operacion de comparacion
     * @param localizacionDelError, el locatable que puede contener el error
     * @return el tipo inferido resultante de la operacion de comparacion, o una instancia de ErrorType en caso de no
     * ser posible realizar la operacion de comparacion
     */
    @Override
    public Tipo comparison(Tipo other, Locatable localizacionDelError) {
        if(other instanceof ErrorType) {
            return other;
        }
        return this.mustPromotesTo(other, localizacionDelError);
    }

    /**
     * Realiza la comprobacion de tipos de un cambio de signo para un operando numerico de TipoInt o TipoNumber y
     * devuelve el mismo tipo del operando si es compatible con la operacion de cambio de signo
     * @param localizacionDelError, el locatable que puede contener el error
     * @return una instancia de TipoInt o TipoNumber en funcion del tipo del operando (respectivamente), o una instancia
     * de ErrorType en caso de no ser el operando de TipoInt o TipoNumber
     */
    @Override
    public Tipo unaryMinus(Locatable localizacionDelError) {
        return new ErrorType("Operacion menos unario no soportada para el tipo \"" + this + "\"", localizacionDelError);
    }

    /**
     * Realiza la comprobacion de tipos de un acceso a un elemento de un array y devuelve el tipo de dicho elemento.
     * @param other, el tipo de elemento que sera utilizado como indice para el acceso al elemento del array
     *               (el tipo de este parametro debe ser TipoInt o promocionar a este)
     * @param localizacionDelError, el locatable que puede contener el error
     * @return el tipo de elemento del array, o una instancia de ErrorType en caso de que:
     *      - La operacion de acceso a array no se este aplicando a un array
     *      - El tipo del indice (other) no sea de TipoInt o se promocione a este
     */
    @Override
    public Tipo squareBrackets(Tipo other, Locatable localizacionDelError) {
        if(other instanceof ErrorType) {
            return other;
        }
        return new ErrorType("Operacion acceso array no soportada para el tipo \"" + this + "\"", localizacionDelError);
    }

    /**
     * Realiza la comprobacion de tipos de un acceso a un campo de un record y devuelve el tipo de dicho campo.
     * @param fieldName, el nombre del campo del record al que se quiere acceder
     *                   (el nombre del campo debe estar definido para el record desde el que se accede)
     * @param localizacionDelError, el locatable que puede contener el error
     * @return el tipo del campo accedido del record, o una instancia de ErrorType en caso de que:
     *      - La operacion de acceso a un campo de un record no se este aplicando a un record
     *      - El campo al que se trata acceder no esta definido para el record
     */
    @Override
    public Tipo dot(String fieldName, Locatable localizacionDelError) {
        return new ErrorType("Operacion acceso campo no soportada para el tipo \"" + this + "\"", localizacionDelError);
    }

    /**
     * Realiza la comprobacion de tipos de una invocacion a una funcion y devuelve el tipo de retorno de dicha funcion.
     * @param typeParams, la lista de los tipos de los parametros pasados a la funcion invocada
     * @param localizacionDelError, el locatable que puede contener el error
     * @return el tipo de retorno de la funcion invocada, o una instancia de ErrorType en caso de que:
     *      - La operacion de invocacion a una funcion no se este aplicando a una funcion
     *      - El numero de parametros suministrados a la funcion invocada != el numero de parametros declarados en ella
     *      - El tipo de, al menos, un parametro suministrado no infiere al tipo del mismo definido en la funcion
     */
    @Override
    public Tipo parenthesis(List<Tipo> typeParams, Locatable localizacionDelError) {
        return new ErrorType("Operacion invocacion no soportada para el tipo \"" + this + "\"", localizacionDelError);
    }

    /**
     * Realiza la comprobacion de tipos de una conversion explicita a tipos simples/built-in (TipoInt, TipoChar o TipoNumber)
     * y devuelve el tipo al que se ha convertido de forma explicita
     * @param other, el tipo simple/built-in (TipoInt, TipoChar o TipoNumber) al que se quiere convertir el tipo this
     * @param localizacionDelError, el locatable que puede contener el error
     * @return el tipo al que se ha convertido de forma explicita, o una instancia de ErrorType en caso de que:
     *      - La operacion de conversion explicita a tipos simples/built-in no se este aplicando a un tipo
     */
    @Override
    public Tipo cast(Tipo other, Locatable localizacionDelError) {
        if(other instanceof ErrorType) {
            return other;
        }
        return new ErrorType("Operacion cast no soportada para el tipo \"" + this + "\" siendo casteado al tipo \"" + other + "\"", localizacionDelError);
    }

    /**
     * Realiza la comprobacion de tipos de una operacion logica (&&, ||) y devuelve el tipo inferido de dicha operacion
     * @param other, el tipo del segundo operando
     *               (el tipo del segundo operando debe ser un tipo logico (TipoInt))
     * @param localizacionDelError, el locatable que puede contener el error
     * @return el tipo inferido de la operacion logica, o una instancia de ErrorType en caso de que:
     *      - El tipo de, al menos, uno de los operandos no sea logico (TipoInt)
     */
    @Override
    public Tipo logical(Tipo other, Locatable localizacionDelError) {
        if(other instanceof ErrorType) {
            return other;
        }
        return new ErrorType("El tipo \"" + this + "\" junto al tipo \"" + other + "\" no forman un tipo logico", localizacionDelError);
    }

    /**
     * Realiza la comprobacion de tipos de una operacion de negacion logica (!) y devuelve el tipo del operando
     * si es logico (TipoInt)
     * @param localizacionDelError, el locatable que puede contener el error
     * @return el tipo del operando de la operacion de negacion logica, o una instancia de ErrorType en caso de que:
     *      - El tipo del operando no sea logico (TipoInt)
     */
    @Override
    public Tipo logical(Locatable localizacionDelError) {
        return new ErrorType("El tipo \"" + this + "\" no es un tipo logico", localizacionDelError);
    }
}
