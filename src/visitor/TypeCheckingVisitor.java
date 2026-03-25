package visitor;

import ast.Programa;
import ast.definiciones.DefinicionFunc;
import ast.definiciones.DefinicionVar;
import ast.expresiones.*;
import ast.sentencia.*;
import ast.tipos.*;

public class TypeCheckingVisitor extends AbstractVisitor<Tipo, Void> {

    @Override
    public Void visit(Variable v, Tipo pt) {
        // no tiene hijos ==> no los recorremos

        // calculamos sus atributos
        v.setTipo(v.getDefinicion().getTipo());

        // no hay comprobaciones que realizar

        return null;
    }

    @Override
    public Void visit(ConstanteInt i, Tipo tipo) {
        // recorremos el AST (sus hijos)
        super.visit(i, tipo);

        // calculamos sus atributos
        i.setTipo(TipoInt.getInstance());

        // no hay comprobaciones que realizar

        return null;
    }

    @Override
    public Void visit(ConstanteReal c, Tipo tipo) {
        // recorremos el AST (sus hijos)
        super.visit(c, tipo);

        // calculamos sus atributos
        c.setTipo(TipoNumber.getInstance());

        // no hay comprobaciones que realizar

        return null;
    }

    @Override
    public Void visit(ConstanteCaracter c, Tipo tipo) {
        // recorremos el AST (sus hijos)
        super.visit(c, tipo);

        // calculamos sus atributos
        c.setTipo(TipoChar.getInstance());

        // no hay comprobaciones que realizar

        return null;
    }

    @Override
    public Void visit(Aritmetico a, Tipo tipo) {
        // recorremos el AST (sus hijos)
        super.visit(a, tipo);

        // calculamos sus atributos
        a.setTipo(a.getIzquierda().getTipo().arithmetic(a.getDerecha().getTipo(), a));

        // no hay comprobaciones que realizar

        return null;
    }

    @Override
    public Void visit(CampoRecord c, Tipo tipo) {
        return super.visit(c, tipo);
    }

    @Override
    public Void visit(TipoArray t, Tipo tipo) {
        return super.visit(t, tipo);
    }

    @Override
    public Void visit(TipoChar t, Tipo tipo) {
        return super.visit(t, tipo);
    }

    @Override
    public Void visit(TipoFuncion t, Tipo tipo) {
        return super.visit(t, tipo);
    }

    @Override
    public Void visit(TipoInt t, Tipo tipo) {
        return super.visit(t, tipo);
    }

    @Override
    public Void visit(TipoNumber t, Tipo tipo) {
        return super.visit(t, tipo);
    }

    @Override
    public Void visit(TipoRecord t, Tipo tipo) {
        return super.visit(t, tipo);
    }

    @Override
    public Void visit(TipoVoid t, Tipo tipo) {
        return super.visit(t, tipo);
    }

    @Override
    public Void visit(While w, Tipo tipo) {
        // recorremos el AST (sus hijos)
        super.visit(w, tipo);

        // no hay atributos que calcular

        // realizamos sus comprobaciones
        w.getCondicion().getTipo().mustBeLogical(w);

        return null;
    }

    @Override
    public Void visit(Return r, Tipo tipo) {
        // recorremos el AST (sus hijos)
        super.visit(r, tipo);

        // no hay atributos que calcular

        // realizamos sus comprobaciones
        r.getExpresion().getTipo().mustPromotesTo(tipo, r);

        return null;
    }

    @Override
    public Void visit(Log l, Tipo tipo) {
        // recorremos el AST (sus hijos)
        super.visit(l, tipo);

        // calculamos sus atributos

        // realizamos sus comprobaciones
        l.getExpresiones().forEach(expresion -> expresion.getTipo().mustBeSimpleType(l));

        return null;
    }

    @Override
    public Void visit(Input i, Tipo tipo) {
        return super.visit(i, tipo);
    }

    @Override
    public Void visit(If i, Tipo tipo) {
        return super.visit(i, tipo);
    }

    @Override
    public Void visit(Asignacion a, Tipo tipo) {
        return super.visit(a, tipo);
    }

    @Override
    public Void visit(Negacion n, Tipo tipo) {
        return super.visit(n, tipo);
    }

    @Override
    public Void visit(MenosUnario m, Tipo tipo) {
        return super.visit(m, tipo);
    }

    @Override
    public Void visit(Logico l, Tipo tipo) {
        return super.visit(l, tipo);
    }

    @Override
    public Void visit(Comparador c, Tipo tipo) {
        return super.visit(c, tipo);
    }

    @Override
    public Void visit(Cast c, Tipo tipo) {
        return super.visit(c, tipo);
    }

    @Override
    public Void visit(AccesoCampo a, Tipo tipo) {
        return super.visit(a, tipo);
    }

    @Override
    public Void visit(AccesoArray a, Tipo tipo) {
        return super.visit(a, tipo);
    }

    @Override
    public Void visit(DefinicionVar d, Tipo tipo) {
        return super.visit(d, tipo);
    }

    @Override
    public Void visit(DefinicionFunc d, Tipo tipo) {
        // recorremos el AST (sus hijos)
        super.visit(d, tipo);

        // calculamos sus atributos

        // realizamos sus comprobaciones
        if(d.getNombre().equalsIgnoreCase("main")) {
            d.getTipo().mustBeMain();
        } else {
            d.getTipo().mustBeFunctionType();
        }

        return null;
    }

    @Override
    public Void visit(Invocacion i, Tipo tipo) {
        return super.visit(i, tipo);
    }

    @Override
    public Void visit(ErrorType e, Tipo tipo) {
        return super.visit(e, tipo);
    }
}
