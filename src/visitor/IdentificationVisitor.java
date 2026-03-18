package visitor;

import ast.Programa;
import ast.definiciones.Definicion;
import ast.definiciones.DefinicionFunc;
import ast.definiciones.DefinicionVar;
import ast.expresiones.*;
import ast.sentencia.*;
import ast.tipos.*;
import symboltable.SymbolTable;

public class IdentificationVisitor extends AbstractVisitor<Void, Void> {

    private SymbolTable st = new SymbolTable();

    @Override
    public Void visit(Variable v, Void pt) {
        // recorremos el AST (sus hijos)
        super.visit(v, pt);

        // calculamos sus atributos: enlazar la variable con su definicion


        // realizamos sus comprobaciones
        return null;
    }

    @Override
    public Void visit(Aritmetico a, Void pt) {
        return null;
    }

    @Override
    public Void visit(CampoRecord c, Void pt) {
        return null;
    }

    @Override
    public Void visit(TipoArray t, Void pt) {
        return null;
    }

    @Override
    public Void visit(TipoChar t, Void pt) {
        return null;
    }

    @Override
    public Void visit(TipoFuncion t, Void pt) {
        return null;
    }

    @Override
    public Void visit(TipoInt t, Void pt) {
        return null;
    }

    @Override
    public Void visit(TipoNumber t, Void pt) {
        return null;
    }

    @Override
    public Void visit(TipoRecord t, Void pt) {
        return null;
    }

    @Override
    public Void visit(TipoVoid t, Void pt) {
        return null;
    }

    @Override
    public Void visit(While w, Void pt) {
        return null;
    }

    @Override
    public Void visit(Return r, Void pt) {
        return null;
    }

    @Override
    public Void visit(Log l, Void pt) {
        return null;
    }

    @Override
    public Void visit(Input i, Void pt) {
        return null;
    }

    @Override
    public Void visit(If i, Void pt) {
        return null;
    }

    @Override
    public Void visit(Asignacion a, Void pt) {
        return null;
    }

    @Override
    public Void visit(Negacion n, Void pt) {
        return null;
    }

    @Override
    public Void visit(MenosUnario m, Void pt) {
        return null;
    }

    @Override
    public Void visit(Logico l, Void pt) {
        return null;
    }

    @Override
    public Void visit(ConstanteReal c, Void pt) {
        return null;
    }

    @Override
    public Void visit(ConstanteCaracter c, Void pt) {
        return null;
    }

    @Override
    public Void visit(Comparador c, Void pt) {
        return null;
    }

    @Override
    public Void visit(Cast c, Void pt) {
        return null;
    }

    @Override
    public Void visit(AccesoCampo a, Void pt) {
        return null;
    }

    @Override
    public Void visit(AccesoArray a, Void pt) {
        return null;
    }

    @Override
    public Void visit(DefinicionVar d, Void pt) {
        return null;
    }

    @Override
    public Void visit(DefinicionFunc d, Void pt) {
        set
                insert
                visit()
                reset
        return null;
    }

    @Override
    public Void visit(Invocacion i, Void pt) {
        return null;
    }

    @Override
    public Void visit(ErrorType e, Void pt) {
        return null;
    }
}
