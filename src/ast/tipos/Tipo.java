package ast.tipos;

import ast.ASTNode;
import ast.locatable.Locatable;

import java.util.List;

public interface Tipo extends ASTNode {
    boolean mustBeLogical(Locatable localizacionDelError);
    Tipo mustPromotesTo(Tipo other, Locatable localizacionDelError);
    void mustBeSimpleType(Locatable localizacionDelError);
    void mustBeMain(Locatable localizacionDelError);
    void mustBeFunctionType(Locatable localizacionDelError);

    Tipo arithmetic(Tipo other, Locatable localizacionDelError);
    Tipo comparison(Tipo other, Locatable localizacionDelError);
    Tipo unaryMinus(Locatable localizacionDelError);
    Tipo squareBrackets(Tipo other, Locatable localizacionDelError); // other es el tipo del indice del array. other debe ser int o promocionar a int. this sera el TipoArray. El tipo que se retorna en este metodo es el tipo de los elementos del array
    Tipo dot(String fieldName, Locatable localizacionDelError); // es la operacion de acceso a campo.
    Tipo parenthesis(List<Tipo> typeParams, Locatable localizacionDelError); // es la operacion de invocacion a funcion. El tipo que devuelve es el tipo del retorno de la funcion
    Tipo cast(Tipo other, Locatable localizacionDelError);
    Tipo logical(Tipo other, Locatable localizacionDelError);
    Tipo logical(Locatable localizacionDelError);
}
