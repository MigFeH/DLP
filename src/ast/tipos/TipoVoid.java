package ast.tipos;

import ast.ASTNode;
import visitor.Visitor;

public class TipoVoid implements Tipo, ASTNode {

    private static TipoVoid instance;

    private TipoVoid() {}

    public static TipoVoid getInstance() {
        if (instance == null) {
            instance = new TipoVoid();
        }
        return instance;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
