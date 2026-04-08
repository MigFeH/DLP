package ast.tipos;

import ast.ASTNode;
import ast.locatable.Locatable;

import java.util.List;

public interface Tipo extends ASTNode {
    void mustBeLogical(Locatable localizacionDelError);
    Tipo mustPromotesTo(Tipo other, Locatable localizacionDelError);
    void mustBeSimpleType(Locatable localizacionDelError);
    void mustBeMain(Locatable localizacionDelError);
    void mustBeFunctionType(Locatable localizacionDelError);

    Tipo arithmetic(Tipo other, Locatable localizacionDelError);
    Tipo comparison(Tipo other, Locatable localizacionDelError);
    Tipo unaryMinus(Locatable localizacionDelError);
    Tipo squareBrackets(Tipo other, Locatable localizacionDelError);
    Tipo dot(String fieldName, Locatable localizacionDelError);
    Tipo parenthesis(List<Tipo> typeParams, Locatable localizacionDelError);
    Tipo cast(Tipo other, Locatable localizacionDelError);
    Tipo logical(Tipo other, Locatable localizacionDelError);
    Tipo logical(Locatable localizacionDelError);

    int numberOfBytes();
}
