package visitor.semantic;

import ast.definiciones.DefinicionFunc;
import ast.definiciones.DefinicionVar;
import ast.expresiones.*;
import ast.sentencia.For;
import ast.tipos.*;
import symboltable.SymbolTable;

public class IdentificationVisitor extends AbstractVisitor<DefinicionFunc, Void> {

    private SymbolTable st = new SymbolTable();

    @Override
    public Void visit(DefinicionVar d, DefinicionFunc pt) {
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
    public Void visit(DefinicionFunc d, DefinicionFunc pt) {
        // recorremos el AST (sus hijos)
        st.set();
        super.visit(d, d);
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
    public Void visit(Variable v, DefinicionFunc pt) {
        // no tiene hijos ==> no los recorremos

        // calculamos sus atributos: enlazar la variable con su definicion
        v.setDefinicion(st.find(v.getNombre()));

        // realizamos sus comprobaciones: variable definida antes de ser usada
        if(v.getDefinicion() == null) {
            DefinicionVar errorDefinition =
                    new DefinicionVar(
                        v.getLinea(),
                        v.getColumna(),
                        new ErrorType("variable '" + v.getNombre() + "' not defined", v),
                        v.getNombre());
            v.setDefinicion(errorDefinition);
        }
        return null;
    }

    @Override
    public Void visit(For f, DefinicionFunc pt) {
        // recorremos el AST (sus hijos)
        if(f.isVariableInicioDefinidaInFor()) {
            st.set();
            super.visit(f, pt);
            pt.getDefinicionesVariables().add((DefinicionVar) f.getInicio().getFirst());
        } else {
            f.getInicio().forEach(s -> s.accept(this, pt));
            f.getFin().accept(this, pt);
            f.getSalto().accept(this, pt);
            st.set();
            f.getCuerpo().forEach(s -> s.accept(this, pt));
        }
        st.reset();

        // no hay atributos que calcular


        // no hay comprobaciones que realizar

        return null;
    }
}
