package ast.tipos;

import visitor.Visitor;

public class TipoChar implements Tipo {

    private static TipoChar instance;

    private TipoChar() {}

    public static TipoChar getInstance() {
        if (instance == null) {
            instance = new TipoChar();
        }
        return instance;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
