package visitor;

import ast.definiciones.Definicion;
import ast.definiciones.DefinicionVar;
import ast.expresiones.Variable;
import ast.tipos.ErrorType;
import ast.tipos.Tipo;

public class TypeCheckingVisitor extends AbstractVisitor<Tipo, Void> {

    @Override
    public Void visit(Variable v, Tipo pt) {
        v.setTipo(v.getDefinicion().getTipo());
        return null;
    }
}
