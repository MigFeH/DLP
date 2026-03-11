package ast.expresiones;

import ast.locatable.Locatable;

public interface Expresion extends Locatable {
    boolean getLValue();
    void setLValue(boolean value);
}
