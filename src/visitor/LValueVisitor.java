package visitor;

import ast.Programa;
import ast.definiciones.Definicion;
import ast.definiciones.DefinicionFunc;
import ast.definiciones.DefinicionVar;
import ast.expresiones.*;
import ast.sentencia.*;
import ast.tipos.*;

public class LValueVisitor implements Visitor<Void, Void> { // Void solo acepta null ==> los visit's de este visitor solo recibe parametros y retorna null's

    @Override
    public Void visit(Programa p, Void unused) {
        for(Definicion def : p.getDefiniciones()) {
            def.accept(this, unused);
        }
        return null;
    }

    @Override
    public Void visit(ConstanteInt i, Void unused) {
        i.setLValue(false);
        return null;
    }

    @Override
    public Void visit(Variable v, Void unused) {
        v.setLValue(true);
        return null;
    }

    @Override
    public Void visit(Aritmetico a, Void unused) {
        a.getIzquierda().accept(this, unused);
        a.getDerecha().accept(this, unused);
        a.setLValue(false);
        return null;
    }

    @Override
    public Void visit(CampoRecord campoRecord, Void tp) {
        return null;
    }

    @Override
    public Void visit(TipoArray tipoArray, Void unused) {
        return null;
    }

    @Override
    public Void visit(TipoChar tipoChar, Void unused) {
        return null;
    }

    @Override
    public Void visit(TipoFuncion tipoFuncion, Void unused) {
        return null;
    }

    @Override
    public Void visit(TipoInt tipoInt, Void unused) {
        return null;
    }

    @Override
    public Void visit(TipoNumber tipoNumber, Void unused) {
        return null;
    }

    @Override
    public Void visit(TipoRecord tipoRecord, Void unused) {
        return null;
    }

    @Override
    public Void visit(TipoVoid tipoVoid, Void unused) {
        return null;
    }

    @Override
    public Void visit(While aWhile, Void unused) {
        return null;
    }

    @Override
    public Void visit(Return aReturn, Void unused) {
        return null;
    }

    @Override
    public Void visit(Log log, Void unused) {
        return null;
    }

    @Override
    public Void visit(Input input, Void unused) {
        return null;
    }

    @Override
    public Void visit(If anIf, Void unused) {
        return null;
    }

    @Override
    public Void visit(Asignacion asignacion, Void unused) {
        asignacion.getIzquierda().accept(this, unused);
        asignacion.getDerecha().accept(this, unused);
        //asignacion; // VAS POR AQUI
        return null;
    }

    @Override
    public Void visit(Negacion negacion, Void unused) {
        return null;
    }

    @Override
    public Void visit(MenosUnario menosUnario, Void unused) {
        return null;
    }

    @Override
    public Void visit(Logico logico, Void unused) {
        return null;
    }

    @Override
    public Void visit(ConstanteReal constanteReal, Void unused) {
        return null;
    }

    @Override
    public Void visit(ConstanteCaracter constanteCaracter, Void unused) {
        return null;
    }

    @Override
    public Void visit(Comparador comparador, Void unused) {
        return null;
    }

    @Override
    public Void visit(Cast cast, Void unused) {
        return null;
    }

    @Override
    public Void visit(AccesoCampo accesoCampo, Void unused) {
        return null;
    }

    @Override
    public Void visit(AccesoArray accesoArray, Void unused) {
        return null;
    }

    @Override
    public Void visit(DefinicionVar definicionVar, Void unused) {
        return null;
    }

    @Override
    public Void visit(DefinicionFunc definicionFunc, Void unused) {
        return null;
    }

    @Override
    public Void visit(Invocacion invocacion, Void unused) {
        return null;
    }
}
