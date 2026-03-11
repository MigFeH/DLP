package ast.tipos;

import ast.ASTNode;
import visitor.Visitor;

public class TipoInt implements Tipo, ASTNode {

    private static TipoInt instance;

    private TipoInt() {}

    public static TipoInt getInstance() {
        if (instance == null) {
            instance = new TipoInt();
        }
        return instance;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
