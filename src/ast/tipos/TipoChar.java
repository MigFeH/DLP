package ast.tipos;

import ast.locatable.Locatable;
import visitor.Visitor;

public class TipoChar extends AbstractTipo {

    private static TipoChar instance;

    private TipoChar() {}

    public static TipoChar getInstance() {
        if (instance == null) {
            instance = new TipoChar();
        }
        return instance;
    }

    @Override
    public Tipo mustPromotesTo(Tipo other, Locatable localizacionDelError) {
        if(other == getInstance()) {
            return this;
        } else if(other == TipoInt.getInstance()) {
            return other;
        }
        return super.mustPromotesTo(other, localizacionDelError);
    }

    @Override
    public void mustBeSimpleType(Locatable localizacionDelError) {}

    @Override
    public Tipo arithmetic(Tipo other, Locatable localizacionDelError) {
        if(other == getInstance() || other == TipoInt.getInstance()) {
            return TipoInt.getInstance();
        } else if(other == TipoNumber.getInstance()) {
            return other;
        }
        return new ErrorType("El tipo \"char\" no soporta una operacion aritmetica con un tipo \"" + other + "\"", localizacionDelError);
    }

    @Override
    public Tipo cast(Tipo other, Locatable localizacionDelError) {
        if(other.isSimpleType()) {
            return other;
        }
        return new ErrorType("Operacion cast no soportada para el tipo \"char\" siendo casteado al tipo \"" + other + "\"", localizacionDelError);
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
        return 1;
    }

    @Override
    public char suffix() {
        return 'b';
    }

    @Override
    public String toString() {
        return "char";
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
