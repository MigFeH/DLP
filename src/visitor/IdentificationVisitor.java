package visitor;

import ast.definiciones.DefinicionFunc;
import ast.definiciones.DefinicionVar;
import ast.expresiones.*;
import ast.tipos.*;
import symboltable.SymbolTable;

public class IdentificationVisitor extends AbstractVisitor<Void, Void> {

    private SymbolTable st = new SymbolTable();

    @Override
    public Void visit(Variable v, Void pt) {
        // no tiene hijos ==> no los recorremos

        // calculamos sus atributos: enlazar la variable con su definicion
        v.setDefinicion(st.find(v.getNombre()));

        // realizamos sus comprobaciones: variable definida antes de ser usada
        if(v.getDefinicion() == null) {
            new ErrorType("variable '" + v.getNombre() + "' not defined", v);
        }

        return null;
    }

    @Override
    public Void visit(DefinicionVar d, Void pt) {
        // recorremos el AST (sus hijos)
        super.visit(d, pt);

        // calculamos sus atributos: calcular el ambito en el que se define la variable
        d.setScope(st.getScope());

        // realizamos sus comprobaciones: definicion unica de la variable en el ambito en el que se encuentra
        if(!st.insert(d)) {
            new ErrorType("variable '" + d.getNombre() + "' already defined in the scope value " + d.getScope(), d);
        }

        return null;
    }

    @Override
    public Void visit(DefinicionFunc d, Void pt) {
        // recorremos el AST (sus hijos)
        st.set();
        super.visit(d, pt);
        st.reset();

        // calculamos sus atributos: calcular el ambito en el que se define la funcion
        d.setScope(st.getScope());

        // realizamos sus comprobaciones: definicion unica de la funcion en el ambito en el que se encuentra
        if(!st.insert(d)) {
            new ErrorType("function '" + d.getNombre() + "' already defined in the scope value " + d.getScope(), d);
        }

        return null;
    }

    @Override
    public Void visit(Invocacion i, Void pt) {
        // recorremos el AST (sus hijos)
        i.getArgumentos().forEach(arg -> arg.accept(this, pt));

        // no hay atributos que calcular

        // realizamos sus comprobaciones: funcion definida antes de ser usada
        if(st.find(i.getInvocado().getNombre()) == null) {
            new ErrorType("function '" + i.getInvocado().getNombre() + "' not defined", i);
        }

        return null;
    }
}
