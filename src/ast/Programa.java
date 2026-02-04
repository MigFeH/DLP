package ast;

import ast.definiciones.Definicion;

import java.util.List;

public class Programa {

    private List<Definicion> definiciones;

    public Programa(List<Definicion> definiciones) {
        this.definiciones = definiciones;
    }

    public List<Definicion> getDefiniciones() {
        return this.definiciones;
    }

}
