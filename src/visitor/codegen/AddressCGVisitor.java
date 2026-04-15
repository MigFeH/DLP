package visitor.codegen;

import ast.definiciones.DefinicionVar;
import ast.expresiones.Variable;
import codegen.CodeGenerator;

public class AddressCGVisitor extends AbstractCGVisitor<Void, Void> {

    // Calcula la direccion de memoria del l-value y me la deja en el tope de la pila

    public AddressCGVisitor(CodeGenerator cg) {
        super(cg);
    }

    @Override
    public Void visit(Variable v, Void unused) {
        cg.push(v.getDefinicion().getTipo(), ((DefinicionVar) v.getDefinicion()).getOffset());
        return null;
    }
}
