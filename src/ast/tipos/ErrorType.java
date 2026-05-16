package ast.tipos;

import ast.locatable.Locatable;
import errorhandler.ErrorHandler;
import visitor.Visitor;

import java.util.List;

public class ErrorType extends AbstractTipo {

    private String causa; // la causa del error
    private Locatable localizacion; // la localizacion en la que se ha producido el error (la construccion en la que se ha producido el error)

    public ErrorType(String causa, Locatable localizacion) {
        this.causa = causa;
        this.localizacion = localizacion;

        ErrorHandler.getInstance().addError(this); // para registrar el error automaticamente tras crearlo
    }

    @Override
    public String toString() {
        return "Error: " + causa + " at line: " + localizacion.getLinea() + " column: " + localizacion.getColumna();
    }

    @Override
    public void mustBeSimpleType(Locatable localizacionDelError) {}

    @Override
    public void mustBeMain(Locatable localizacionDelError) {}

    @Override
    public void mustBeFunctionType(Locatable localizacionDelError) {}

    @Override
    public Tipo mustPromotesTo(Tipo other, Locatable localizacionDelError) {
        return this;
    }

    @Override
    public Tipo comparison(Tipo other, Locatable localizacionDelError) {
        return this;
    }

    @Override
    public Tipo unaryMinus(Locatable localizacionDelError) {
        return this;
    }

    @Override
    public Tipo squareBrackets(Tipo other, Locatable localizacionDelError) {
        return this;
    }

    @Override
    public Tipo dot(String fieldName, Locatable localizacionDelError) {
        return this;
    }

    @Override
    public Tipo arithmetic(Tipo other, Locatable localizacionDelError) { return this; }

    @Override
    public Tipo cast(Tipo other, Locatable localizacionDelError) {
        return this;
    }

    @Override
    public Tipo logical(Tipo other, Locatable localizacionDelError) {
        return this;
    }

    @Override
    public Tipo logical(Locatable localizacionDelError) {
        return this;
    }

    @Override
    public Tipo parenthesis(List<Tipo> typeParams, Locatable localizacionDelError) {
        return this;
    }

    @Override
    public void mustBeLogical(Locatable localizacionDelError) {}

    @Override
    public Tipo ternaryOperator(Tipo tipoSalidaTrue, Tipo tipoSalidaFalse, Locatable localizacionDelError) {
        return this;
    }

    @Override
    public Tipo mustBeSameType(Tipo other, Locatable localizacionDelError) {
        return this;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
