package ast.tipos;

import ast.ASTNode;
import visitor.Visitor;

public class TipoNumber implements Tipo, ASTNode {

    private static TipoNumber instance;

    private TipoNumber() {}

    public static TipoNumber getInstance() {
        if (instance == null) {
            instance = new TipoNumber();
        }
        return instance;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
