package ast.tipos.simples;

public class TipoVoid implements TipoSimple {

    private static TipoVoid instance;

    private TipoVoid() {}

    public static TipoVoid getInstance() {
        if (instance == null) {
            instance = new TipoVoid();
        }
        return instance;
    }
}
