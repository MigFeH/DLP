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
        if(other == TipoInt.getInstance() || other == TipoNumber.getInstance()) {
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
        if(other == TipoInt.getInstance() || other == TipoChar.getInstance()) {
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
        if(other.isSimpleType()) {
            return other;
        }
        return super.cast(other, localizacionDelError);
    }

    @Override
    public boolean isSimpleType() {
        return true;
    }

    @Override
    public Tipo logical(Tipo other, Locatable localizacionDelError) {
        if(other == TipoInt.getInstance() || other == TipoChar.getInstance()) {
            return this;
        }
        return super.logical(other, localizacionDelError);
    }

    @Override
    public Tipo comparison(Tipo other, Locatable localizacionDelError) {
        if(other.isSimpleType()) {
            return this;
        }
        return super.comparison(other, localizacionDelError);
    }

    @Override
    public Tipo logical(Locatable localizacionDelError) {
        return this;
    }

    @Override
    public Tipo getTipoDominante(Tipo tipo1, Tipo tipo2, Locatable localizacionDelError) {
        if(tipo1 instanceof ErrorType || tipo2 instanceof ErrorType) {
            return super.getTipoDominante(tipo1, tipo2, localizacionDelError);
        }

        if(tipo1 == TipoNumber.getInstance() || tipo2 == TipoNumber.getInstance()) {
            return TipoNumber.getInstance();
        }
        return this;
    }

    @Override
    public int numberOfBytes() {
        return 2;
    }

    @Override
    public char suffix() {
        return 'i';
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
