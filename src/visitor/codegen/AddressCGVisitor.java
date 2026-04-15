package visitor.codegen;

import ast.definiciones.DefinicionVar;
import ast.expresiones.Variable;
import codegen.CodeGenerator;

public class AddressCGVisitor extends AbstractCGVisitor<Void, Void> {

    // Address: dominio = Variables, ArrayAccess, FieldAccess (son los l-values)
    //      Calcula la direccion de memoria del l-value y me la deja en el tope de la pila

    public AddressCGVisitor(CodeGenerator cg) {
        super(cg);
    }

    @Override
    public Void visit(Variable v, Void p) {
        DefinicionVar definicion = (DefinicionVar) v.getDefinicion();
        if(definicion.getScope() == 0) {
            // variables globales
            cg.push('a', definicion.getOffset());
        } else {
            // variables locales y parametros
            cg.pushBP();
            cg.push('i', definicion.getOffset());
            cg.add('i');
        }
        return null;
    }
}
