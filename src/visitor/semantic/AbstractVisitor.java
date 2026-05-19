package visitor.semantic;

import ast.Programa;
import ast.definiciones.Definicion;
import ast.definiciones.DefinicionFunc;
import ast.definiciones.DefinicionVar;
import ast.expresiones.*;
import ast.sentencia.*;
import ast.tipos.*;
import visitor.Visitor;

public abstract class AbstractVisitor<PT, RT> implements Visitor<PT, RT> {

    @Override
    public RT visit(Programa p, PT pt) {
        for(Definicion def : p.getDefiniciones()) {
            def.accept(this, pt);
        }
        return null;
    }

    @Override
    public RT visit(ConstanteInt i, PT pt) {
        // no tiene hijos ==> no los recorremos
        return null;
    }

    @Override
    public RT visit(ConstanteReal c, PT pt) {
        // no tiene hijos ==> no los recorremos
        return null;
    }

    @Override
    public RT visit(ConstanteCaracter c, PT pt) {
        // no tiene hijos ==> no los recorremos
        return null;
    }

    @Override
    public RT visit(Aritmetico a, PT pt) {
        a.getIzquierda().accept(this, pt);
        a.getDerecha().accept(this, pt);
        return null;
    }

    @Override
    public RT visit(CampoRecord c, PT pt) {
        c.getTipo().accept(this, pt);
        return null;
    }

    @Override
    public RT visit(TipoArray t, PT pt) {
        t.getTipoElemento().accept(this, pt);
        return null;
    }

    @Override
    public RT visit(TipoChar t, PT pt) {
        // no tiene hijos ==> no los recorremos
        return null;
    }

    @Override
    public RT visit(TipoFuncion t, PT pt) {
        t.getTipoRetorno().accept(this, pt);
        t.getParametros().forEach(p -> p.accept(this, pt));
        return null;
    }

    @Override
    public RT visit(TipoInt t, PT pt) {
        // no tiene hijos ==> no los recorremos
        return null;
    }

    @Override
    public RT visit(TipoNumber t, PT pt) {
        // no tiene hijos ==> no los recorremos
        return null;
    }

    @Override
    public RT visit(TipoRecord t, PT pt) {
        t.getCampos().forEach(campo -> campo.accept(this, pt));
        return null;
    }

    @Override
    public RT visit(TipoVoid t, PT pt) {
        // no tiene hijos ==> no los recorremos
        return null;
    }

    @Override
    public RT visit(While w, PT pt) {
        w.getCondicion().accept(this, pt);
        w.getCuerpo().forEach(sentencia -> sentencia.accept(this, pt));
        return null;
    }

    @Override
    public RT visit(Return r, PT pt) {
        r.getExpresion().accept(this, pt);
        return null;
    }

    @Override
    public RT visit(Log l, PT pt) {
        l.getExpresiones().forEach(expresion -> expresion.accept(this, pt));
        return null;
    }

    @Override
    public RT visit(Input i, PT pt) {
        i.getExpresiones().forEach(expresion -> expresion.accept(this, pt));
        return null;
    }

    @Override
    public RT visit(If i, PT pt) {
        i.getCondicion().accept(this, pt);
        i.getCuerpo().forEach(sentencia -> sentencia.accept(this, pt));
        i.getCuerpoElse().forEach(sentencia -> sentencia.accept(this, pt));
        return null;
    }

    @Override
    public RT visit(Asignacion a, PT pt) {
        a.getIzquierda().accept(this, pt);
        a.getDerecha().accept(this, pt);
        return null;
    }

    @Override
    public RT visit(Negacion n, PT pt) {
        n.getOperando().accept(this, pt);
        return null;
    }

    @Override
    public RT visit(MenosUnario m, PT pt) {
        m.getOperando().accept(this, pt);
        return null;
    }

    @Override
    public RT visit(Logico l, PT pt) {
        l.getIzquierda().accept(this, pt);
        l.getDerecha().accept(this, pt);
        return null;
    }

    @Override
    public RT visit(Comparador c, PT pt) {
        c.getIzquierda().accept(this, pt);
        c.getDerecha().accept(this, pt);
        return null;
    }

    @Override
    public RT visit(Cast c, PT pt) {
        c.getIzquierda().accept(this, pt);
        c.getDerecha().accept(this, pt);
        return null;
    }

    @Override
    public RT visit(AccesoCampo a, PT pt) {
        a.getIzquierda().accept(this, pt);
        return null;
    }

    @Override
    public RT visit(AccesoArray a, PT pt) {
        a.getIzquierda().accept(this, pt);
        a.getDerecha().accept(this, pt);
        return null;
    }

    @Override
    public RT visit(DefinicionVar d, PT pt) {
        d.getTipo().accept(this, pt);
        return null;
    }

    @Override
    public RT visit(DefinicionFunc d, PT pt) {
        d.getTipo().accept(this, pt);
        d.getDefinicionesVariables().forEach(varDef -> varDef.accept(this, pt));
        d.getSentencias().forEach(sentencia -> sentencia.accept(this, pt));
        return null;
    }

    @Override
    public RT visit(Invocacion i, PT pt) {
        i.getInvocado().accept(this, pt);
        i.getArgumentos().forEach(arg -> arg.accept(this, pt));
        return null;
    }

    @Override
    public RT visit(ErrorType e, PT pt) {
        return null;
    }

    @Override
    public RT visit(Variable v, PT pt) {
        // no tiene hijos ==> no los recorremos
        return null;
    }

    @Override
    public RT visit(Sufijo s, PT pt) {
        s.getOperando().accept(this, pt);
        return null;
    }
}
