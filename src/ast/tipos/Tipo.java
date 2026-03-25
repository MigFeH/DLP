package ast.tipos;

import ast.ASTNode;
import ast.locatable.Locatable;

import java.util.List;

public interface Tipo extends ASTNode {
    // las comprobaciones (must---()) no devuelven nada
    void mustBeLogical(Locatable localizacionDelError); // comprueba que: dado un tipo debe ser logico. Los tipos que soportan la operacion [int y char tendran vacío este metodo] (OK). Los tipos que NO soportan la operacion => error
    void mustPromotesTo(Tipo other, Locatable localizacionDelError); // lo usamos en el log, input, return, asignacion, ... Este metodo puede devolver algo si lo usamos en mas sitios y necesitamos saber el "resultado de la promocion"
    void mustBeSimpleType(Locatable localizacionDelError); // lo usamos para comprobar que una funcion retorna y recibe tipos simples
    void mustBeMain(); // lo implementa function y debe comprobar que sea void, que no tenga parametros, que su nombre sea main, etc

    // en las expresiones que conlleven un tipo other hay que devolver el tipo inferido
    Tipo aritmetico(Tipo other, Locatable localizacionDelError); // other es el tipo de la derecha de la operacion aritmetica. el tipo de la izquierda sera el this. Devuelve el tipo de la expresion resultante (el tipo inferido de la expresion)
    Tipo comparison(Tipo other, Locatable localizacionDelError);
    Tipo logic();
    Tipo unaryMinus(Locatable localizacionDelError);
    Tipo squareBrackets(Tipo other, Locatable localizacionDelError); // other es el tipo del indice del array. other debe ser int o promocionar a int. this sera el TipoArray. El tipo que se retorna en este metodo es el tipo de los elementos del array
    Tipo dot(String fieldName, Locatable localizacionDelError); // es la operacion de acceso a campo.
    Tipo parenthesis(List<Tipo> typeParams, Locatable localizacionDelError); // es la operacion de invocacion a funcion. El tipo que devuelve es el tipo del retorno de la funcion

}
