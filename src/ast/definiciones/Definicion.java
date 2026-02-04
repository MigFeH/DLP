package ast.definiciones;

import ast.locatable.AbstractLocatable;
import ast.tipos.Tipo;

public interface Definicion {
    String getNombre();
    Tipo getTipo();
}
