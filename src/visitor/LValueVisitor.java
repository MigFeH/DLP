package visitor;
import ast.expresiones.*;
import ast.sentencia.*;
import ast.tipos.*;
import ast.tipos.ErrorType;

import java.util.List;

public class LValueVisitor extends AbstractVisitor<Void, Void> { // Void solo acepta null ==> los visit's de este visitor solo recibe parametros y retorna null's

    // lvalue: Si algo PUEDE estar a la izquierda en una asignacion o no

    @Override
    public Void visit(ConstanteInt i, Void pt) {
        super.visit(i, pt);
        i.setLValue(false); // las constantes NUNCA pueden estar a la izquierda de una asignacion
        return null;
    }

    @Override
    public Void visit(ConstanteReal c, Void pt) {
        super.visit(c, pt);
        c.setLValue(false); // las constantes NUNCA pueden estar a la izquierda de una asignacion
        return null;
    }

    @Override
    public Void visit(ConstanteCaracter c, Void pt) {
        super.visit(c, pt);
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
        super.visit(a, pt);
        a.setLValue(false); // una operacion aritmetica NUNCA puede estar a la izquierda de una asignacion. Ej: a+1 = a
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
    public Void visit(Asignacion a, Void pt) {
        super.visit(a, pt);
        if(!a.getIzquierda().getLValue()) { // la asignacion NECESITA que la parte izquierda del igual sea un lValue, es decir, que pueda estar en dicha parte de una asignacion
            new ErrorType("Lvalue required", a);
        }
        return null;
    }

    @Override
    public Void visit(Negacion n, Void pt) {
        super.visit(n, pt);
        n.setLValue(false); // una negacion NO puede estar a la izquierda de una asignacion. Ej: !a = false
        return null;
    }

    @Override
    public Void visit(MenosUnario m, Void pt) {
        super.visit(m, pt);
        m.setLValue(false); // un menos unario NO puede estar a la izquierda de una asignacion. Ej: -a = 3
        return null;
    }

    @Override
    public Void visit(Logico l, Void pt) {
        super.visit(l, pt);
        l.setLValue(false); // una operacion logica NUNCA puede estar a la izquierda de una asignacion
        return null;
    }

    @Override
    public Void visit(Comparador c, Void pt) {
        super.visit(c, pt);
        c.setLValue(false); // una comparacion NUNCA puede estar a la izquierda de una asignacion
        return null;
    }

    @Override
    public Void visit(Cast c, Void pt) {
        super.visit(c, pt);
        c.setLValue(false); // un cast NUNCA puede estar a la izquierda de una asignacion
        return null;
    }

    @Override
    public Void visit(AccesoCampo a, Void pt) {
        super.visit(a, pt);
        a.setLValue(true); // un acceso a un campo PUEDE estar a la izquierda de una asignacion. Ej: persona.edad = 23
        return null;
    }

    @Override
    public Void visit(AccesoArray a, Void pt) {
        super.visit(a, pt);
        a.setLValue(true); // un acceso a un elemento de un array PUEDE estar a la izquierda de una asignacion. Ej: dato[1] = 3
        return null;
    }

    @Override
    public Void visit(Invocacion i, Void pt) {
        super.visit(i, pt);
        i.setLValue(false); // una invocacion a una funcion/metodo NUNCA puede estar a la izquierda de una asignacion. Ej: sumatorio(datos) = 4
        return null;
    }
}
