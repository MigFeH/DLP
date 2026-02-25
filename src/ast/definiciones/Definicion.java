package ast.definiciones;

import ast.locatable.AbstractLocatable;
import ast.locatable.Locatable;
import ast.tipos.Tipo;

public interface Definicion extends Locatable {
    String getNombre();
    Tipo getTipo();
}
