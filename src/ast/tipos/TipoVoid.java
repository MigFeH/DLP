package ast.tipos;

public class TipoVoid implements Tipo {

    private static TipoVoid instance;

    private TipoVoid() {}

    public static TipoVoid getInstance() {
        if (instance == null) {
            instance = new TipoVoid();
        }
        return instance;
    }
}
