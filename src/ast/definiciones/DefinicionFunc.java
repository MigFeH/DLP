package ast.definiciones;

import ast.ASTNode;
import ast.sentencia.Sentencia;
import ast.tipos.Tipo;
import visitor.Visitor;

import java.util.List;

public class DefinicionFunc extends AbstractDefinicion implements ASTNode {

    private List<DefinicionVar> definicionesVariables; // la alternativa es eliminar esta lista y hacer que DefinicionVar implemente la interfaz Sentencia
    private List<Sentencia> sentencias;
    private int localBytesSum;

    public DefinicionFunc(int linea, int columna,
                          Tipo tipo, String nombre,
                          List<DefinicionVar> definicionesVariables,
                          List<Sentencia> sentencias) {
        super(linea, columna, tipo, nombre);
        this.definicionesVariables = definicionesVariables;
        this.sentencias  = sentencias;
    }

    public List<DefinicionVar> getDefinicionesVariables() {
        return this.definicionesVariables;
    }

    public List<Sentencia> getSentencias() {
        return this.sentencias;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }

    public void setLocalBytesSum(int localBytesSum) {
        this.localBytesSum = localBytesSum;
    }

    public int getLocalBytesSum() {
        return this.localBytesSum;
    }
}
