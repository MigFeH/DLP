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
    public Tipo mustPromotesTo(Tipo other, Locatable localizacionDelError) {
        if(other == getInstance() || other == TipoChar.getInstance()) {
            return this;
        } else if(other == TipoNumber.getInstance()) {
            return other;
        }
        return super.mustPromotesTo(other, localizacionDelError);
    }

    @Override
    public void mustBeLogical(Locatable localizacionDelError) {}

    @Override
    public void mustBeSimpleType(Locatable localizacionDelError) {}

    @Override
    public Tipo arithmetic(Tipo other, Locatable localizacionDelError) {
        if(other == getInstance() || other == TipoChar.getInstance()) {
            return this;
        } else if(other == TipoNumber.getInstance()) {
            return other;
        }
        return new ErrorType("El tipo \"int\" no soporta una operacion aritmetica con un tipo \"" + other + "\"", localizacionDelError);
    }

    @Override
    public Tipo unaryMinus(Locatable localizacionDelError) {
        return this;
    }

    @Override
    public Tipo cast(Tipo other, Locatable localizacionDelError) {
        if(other == getInstance() || other == TipoChar.getInstance() || other == TipoNumber.getInstance()) {
            return other;
        }
        return new ErrorType("Operacion cast no soportada para el tipo \"int\" siendo casteado al tipo \"" + other + "\"", localizacionDelError);
    }

    @Override
    public Tipo logical(Tipo other, Locatable localizacionDelError) {
        if(other == TipoInt.getInstance()) {
            return this;
        }
        return new ErrorType("El tipo \"int\" junto al tipo \"" + other + "\" no forman un tipo logico", localizacionDelError);
    }

    @Override
    public Tipo logical(Locatable localizacionDelError) {
        return this;
    }

    @Override
    public int numberOfBytes() {
        return 2;
    }

    @Override
    public String toString() {
        return "int";
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
