package ast.expresiones;

import ast.locatable.Locatable;
import ast.tipos.Tipo;

public interface Expresion extends Locatable {
    boolean getLValue();
    void setLValue(boolean value);
    Tipo getTipo();
    void setTipo(Tipo tipo);
}
