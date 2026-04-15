package visitor.codegen;

import ast.expresiones.*;
import codegen.CodeGenerator;

public class ValueCGVisitor extends AbstractCGVisitor<Void, Void> {

    private AddressCGVisitor address;

    public ValueCGVisitor(CodeGenerator cg) {
        super(cg);
        this.address = new AddressCGVisitor(cg);
    }

    @Override
    public Void visit(AccesoArray a, Void p) {
        return null;
    }

    @Override
    public Void visit(AccesoCampo a, Void p) {
        return null;
    }

    @Override
    public Void visit(Aritmetico a, Void p) {
        return null;
    }

    @Override
    public Void visit(Cast c, Void p) {
        return null;
    }

    @Override
    public Void visit(Comparador c, Void p) {
        return null;
    }

    @Override
    public Void visit(ConstanteCaracter c, Void p) {
        return null;
    }

    @Override
    public Void visit(ConstanteInt c, Void p) {
        return null;
    }

    @Override
    public Void visit(ConstanteReal c, Void p) {
        return null;
    }

    @Override
    public Void visit(Invocacion i, Void p) {
        return null;
    }

    @Override
    public Void visit(Logico l, Void p) {
        return null;
    }

    @Override
    public Void visit(MenosUnario m, Void p) {
        return null;
    }

    @Override
    public Void visit(Negacion n, Void p) {
        return null;
    }

    @Override
    public Void visit(Variable v, Void p) {
        v.accept(address, p);
        cg.load(v.getTipo().suffix());
        return null;
    }
}
