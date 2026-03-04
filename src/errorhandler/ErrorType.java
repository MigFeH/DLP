package errorhandler;

import ast.locatable.Locatable;
import ast.tipos.Tipo;

public class ErrorType implements Tipo {

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
}
