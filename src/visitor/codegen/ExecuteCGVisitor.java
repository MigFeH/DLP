package visitor.codegen;

import ast.definiciones.*;
import ast.sentencia.*;
import ast.Programa;
import codegen.CodeGenerator;

public class ExecuteCGVisitor extends AbstractCGVisitor<Void, Void> {

    private AddressCGVisitor address;
    private ValueCGVisitor value;

    public ExecuteCGVisitor(CodeGenerator cg) {
        super(cg);
        this.address = new AddressCGVisitor(cg);
        this.value = new ValueCGVisitor(cg);
    }

    @Override
    public Void visit(Programa p, Void p) {
        return null;
    }

    @Override
    public Void visit(Asignacion a, Void p) {
        a.getIzquierda().accept(address, p);
        a.getDerecha().accept(value, p);
        cg.convertTo(a.getDerecha().getTipo(), a.getIzquierda().getTipo());
        cg.store(a.getIzquierda().getTipo());
        return null;
    }

    @Override
    public Void visit(If i, Void p) {
        return null;
    }

    @Override
    public Void visit(Input i, Void p) {
        return null;
    }

    @Override
    public Void visit(Log l, Void p) {
        return null;
    }

    @Override
    public Void visit(Return r, Void p) {
        return null;
    }

    @Override
    public Void visit(While w, Void p) {
        return null;
    }

    @Override
    public Void visit(DefinicionFunc d, Void p) {
        return null;
    }

    @Override
    public Void visit(DefinicionVar d, Void p) {
        return null;
    }
}
