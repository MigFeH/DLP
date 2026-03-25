package ast.tipos;

import ast.locatable.Locatable;
import errorhandler.ErrorHandler;
import visitor.Visitor;

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
    public Tipo mustPromotesTo(Tipo other, Locatable localizacionDelError) {
        return this;
    }

    @Override
    public Tipo arithmetic(Tipo other, Locatable localizacionDelError) {
        return new ErrorType("El tipo \"error\" no soporta una operacion aritmetica", localizacionDelError);
    }

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
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
