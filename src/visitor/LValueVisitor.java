package visitor;

import ast.Programa;
import ast.definiciones.Definicion;
import ast.definiciones.DefinicionFunc;
import ast.definiciones.DefinicionVar;
import ast.expresiones.*;
import ast.sentencia.*;
import ast.tipos.*;
import ast.tipos.ErrorType;

import java.util.List;

public class LValueVisitor implements Visitor<Void, Void> { // Void solo acepta null ==> los visit's de este visitor solo recibe parametros y retorna null's

    // lvalue: Si algo PUEDE estar a la izquierda en una asignacion o no

    @Override
    public Void visit(Programa p, Void pt) {
        for(Definicion def : p.getDefiniciones()) {
            def.accept(this, pt);
        }
        return null;
    }

    @Override
    public Void visit(ConstanteInt i, Void pt) {
        // no tiene hijos ==> no los recorremos
        i.setLValue(false); // las constantes NUNCA pueden estar a la izquierda de una asignacion
        return null;
    }

    @Override
    public Void visit(ConstanteReal c, Void pt) {
        // no tiene hijos ==> no los recorremos
        c.setLValue(false); // las constantes NUNCA pueden estar a la izquierda de una asignacion
        return null;
    }

    @Override
    public Void visit(ConstanteCaracter c, Void pt) {
        // no tiene hijos ==> no los recorremos
        c.setLValue(false); // las constantes NUNCA pueden estar a la izquierda de una asignacion
        return null;
    }

    @Override
    public Void visit(Variable v, Void pt) {
        // no tiene hijos ==> no los recorremos
        v.setLValue(true); // las variables PUEDEN estar a la izquierda de una asignacion
        return null;
    }

    @Override
    public Void visit(Aritmetico a, Void pt) {
        a.getIzquierda().accept(this, pt);
        a.getDerecha().accept(this, pt);
        a.setLValue(false); // una operacion aritmetica NUNCA puede estar a la izquierda de una asignacion. Ej: a+1 = a
        return null;
    }

    @Override
    public Void visit(CampoRecord c, Void pt) {
        c.getTipo().accept(this, pt);
        return null;
    }

    @Override
    public Void visit(TipoArray t, Void pt) {
        t.getTipoElemento().accept(this, pt);
        return null;
    }

    @Override
    public Void visit(TipoChar t, Void pt) {
        // no tiene hijos ==> no los recorremos
        return null;
    }

    @Override
    public Void visit(TipoFuncion t, Void pt) {
        t.getTipoRetorno().accept(this, pt);
        t.getParametros().forEach(p -> p.accept(this, pt));
        return null;
    }

    @Override
    public Void visit(TipoInt t, Void pt) {
        // no tiene hijos ==> no los recorremos
        return null;
    }

    @Override
    public Void visit(TipoNumber t, Void pt) {
        // no tiene hijos ==> no los recorremos
        return null;
    }

    @Override
    public Void visit(TipoRecord t, Void pt) {
        t.getCampos().forEach(campo -> campo.accept(this, pt));
        return null;
    }

    @Override
    public Void visit(TipoVoid t, Void pt) {
        // no tiene hijos ==> no los recorremos
        return null;
    }

    @Override
    public Void visit(While w, Void pt) {
        w.getCondicion().accept(this, pt);
        w.getCuerpo().forEach(sentencia -> sentencia.accept(this, pt));
        return null;
    }

    @Override
    public Void visit(Return r, Void pt) {
        r.getExpresion().accept(this, pt);
        return null;
    }

    @Override
    public Void visit(Log l, Void pt) {
        l.getExpresiones().forEach(expresion -> expresion.accept(this, pt));
        return null;
    }

    @Override
    public Void visit(Input i, Void pt) {
        for(Expresion e : i.getExpresiones()) {
            e.accept(this, pt);
            if(!e.getLValue()) {
                new ErrorType("Lvalue required", e);
            }
        }
        return null;
    }

    @Override
    public Void visit(If i, Void pt) {
        i.getCondicion().accept(this, pt);
        i.getCuerpo().forEach(sentencia -> sentencia.accept(this, pt));
        i.getCuerpoElse().forEach(sentencia -> sentencia.accept(this, pt));
        return null;
    }

    @Override
    public Void visit(Asignacion a, Void pt) {
        a.getIzquierda().accept(this, pt);
        a.getDerecha().accept(this, pt);
        if(!a.getIzquierda().getLValue()) { // la asignacion NECESITA que la parte izquierda del igual sea un lValue, es decir, que pueda estar en dicha parte de una asignacion
            new ErrorType("Lvalue required", a);
        }
        return null;
    }

    @Override
    public Void visit(Negacion n, Void pt) {
        n.getOperando().accept(this, pt);
        n.setLValue(false); // una negacion NO puede estar a la izquierda de una asignacion. Ej: !a = false
        return null;
    }

    @Override
    public Void visit(MenosUnario m, Void pt) {
        m.getOperando().accept(this, pt);
        m.setLValue(false); // un menos unario NO puede estar a la izquierda de una asignacion. Ej: -a = 3
        return null;
    }

    @Override
    public Void visit(Logico l, Void pt) {
        l.getIzquierda().accept(this, pt);
        l.getDerecha().accept(this, pt);
        l.setLValue(false); // una operacion logica NUNCA puede estar a la izquierda de una asignacion
        return null;
    }

    @Override
    public Void visit(Comparador c, Void pt) {
        c.getIzquierda().accept(this, pt);
        c.getDerecha().accept(this, pt);
        c.setLValue(false); // una comparacion NUNCA puede estar a la izquierda de una asignacion
        return null;
    }

    @Override
    public Void visit(Cast c, Void pt) {
        c.getIzquierda().accept(this, pt);
        c.getDerecha().accept(this, pt);
        c.setLValue(false); // un cast NUNCA puede estar a la izquierda de una asignacion
        return null;
    }

    @Override
    public Void visit(AccesoCampo a, Void pt) {
        a.getIzquierda().accept(this, pt);
        a.setLValue(true); // un acceso a un campo PUEDE estar a la izquierda de una asignacion. Ej: persona.edad = 23
        return null;
    }

    @Override
    public Void visit(AccesoArray a, Void pt) {
        a.getIzquierda().accept(this, pt);
        a.getDerecha().accept(this, pt);
        a.setLValue(true); // un acceso a un elemento de un array PUEDE estar a la izquierda de una asignacion. Ej: dato[1] = 3
        return null;
    }

    @Override
    public Void visit(DefinicionVar d, Void pt) {
        d.getTipo().accept(this, pt);
        return null;
    }

    @Override
    public Void visit(DefinicionFunc d, Void pt) {
        d.getDefinicionesVariables().forEach(varDef -> varDef.accept(this, pt));
        d.getSentencias().forEach(sentencia -> sentencia.accept(this, pt));
        d.getTipo().accept(this, pt);
        return null;
    }

    @Override
    public Void visit(Invocacion i, Void pt) {
        i.getInvocado().accept(this, pt);
        i.getArgumentos().forEach(arg -> arg.accept(this, pt));
        i.setLValue(false); // una invocacion a una funcion/metodo NUNCA puede estar a la izquierda de una asignacion. Ej: sumatorio(datos) = 4
        return null;
    }

    @Override
    public Void visit(ErrorType e, Void pt) {
        return null;
    }
}
