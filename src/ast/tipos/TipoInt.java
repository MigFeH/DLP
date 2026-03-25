package ast.tipos;

import ast.locatable.Locatable;
import visitor.Visitor;

public class TipoInt extends AbstractTipo {

    private static TipoInt instance;

    private TipoInt() {}

    public static TipoInt getInstance() {
        if (instance == null) {
            instance = new TipoInt();
        }
        return instance;
    }

    @Override
    public void mustBeLogical(Locatable localizacionDelError) {}

    @Override
    public Tipo aritmetico(Tipo other, Locatable localizacionDelError) {
        if(other == getInstance() || other == TipoChar.getInstance()) {
            return this;
        } else if(other == TipoNumber.getInstance()) {
            return other;
        }
        return new ErrorType("El tipo entero no soporta una operacion aritmetica con un tipo " + other + " a la derecha", localizacionDelError);
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
