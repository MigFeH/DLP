package ast.tipos;

import ast.locatable.Locatable;
import visitor.Visitor;

public class TipoNumber extends AbstractTipo {

    private static TipoNumber instance;

    private TipoNumber() {}

    public static TipoNumber getInstance() {
        if (instance == null) {
            instance = new TipoNumber();
        }
        return instance;
    }

    @Override
    public Tipo mustPromotesTo(Tipo other, Locatable localizacionDelError) {
        if(other == TipoNumber.getInstance()) {
            return this;
        }
        return super.mustPromotesTo(other, localizacionDelError);
    }

    @Override
    public void mustBeSimpleType(Locatable localizacionDelError) {}

    @Override
    public Tipo arithmetic(Tipo other, Locatable localizacionDelError) {
        if(other.isSimpleType()) {
            return this;
        }
        return new ErrorType("El tipo \"number\" no soporta una operacion aritmetica con un tipo \"" + other + "\"", localizacionDelError);
    }

    @Override
    public Tipo unaryMinus(Locatable localizacionDelError) {
        return this;
    }

    @Override
    public Tipo cast(Tipo other, Locatable localizacionDelError) {
        if(other.isSimpleType()) {
            return other;
        }
        return super.cast(other, localizacionDelError);
    }

    @Override
    public Tipo comparison(Tipo other, Locatable localizacionDelError) {
        if(other.isSimpleType()) {
            return TipoInt.getInstance();
        }
        return super.comparison(other, localizacionDelError);
    }

    @Override
    public boolean isSimpleType() {
        return true;
    }

    @Override
    public int numberOfBytes() {
        return 4;
    }

    @Override
    public char suffix() {
        return 'f';
    }

    @Override
    public String toString() {
        return "number";
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
