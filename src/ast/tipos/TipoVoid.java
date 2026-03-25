package ast.tipos;

import visitor.Visitor;

public class TipoVoid extends AbstractTipo {

    private static TipoVoid instance;

    private TipoVoid() {}

    public static TipoVoid getInstance() {
        if (instance == null) {
            instance = new TipoVoid();
        }
        return instance;
    }

    @Override
    public String toString() {
        return "void";
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
