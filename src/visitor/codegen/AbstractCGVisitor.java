package visitor.codegen;

import ast.Programa;
import ast.definiciones.DefinicionFunc;
import ast.definiciones.DefinicionVar;
import ast.expresiones.*;
import ast.sentencia.*;
import ast.tipos.*;
import codegen.CodeGenerator;
import visitor.Visitor;

public abstract class AbstractCGVisitor<PT, RT> implements Visitor<PT, RT> {

    protected CodeGenerator cg;

    public AbstractCGVisitor(CodeGenerator cg) {
        this.cg = cg;
    }

    @Override
    public RT visit(Programa p, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(ConstanteInt i, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(Variable v, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(Aritmetico a, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(CampoRecord c, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(TipoArray t, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(TipoChar t, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(TipoFuncion t, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(TipoInt t, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(TipoNumber t, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(TipoRecord t, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(TipoVoid t, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(While w, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(Return r, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(Log l, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(Input i, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(If i, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(Asignacion a, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(Negacion n, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(MenosUnario m, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(Logico l, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(ConstanteReal c, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(ConstanteCaracter c, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(Comparador c, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(Cast c, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(AccesoCampo a, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(AccesoArray a, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(DefinicionVar d, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(DefinicionFunc d, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(Invocacion i, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(ErrorType e, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }

    @Override
    public RT visit(For f, PT pt) {
        throw new UnsupportedOperationException("This string does not supported the operation");
    }
}
