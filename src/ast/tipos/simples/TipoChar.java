package ast.tipos.simples;

public class TipoChar implements TipoSimple {

    private static TipoChar instance;

    private TipoChar() {}

    public static TipoChar getInstance() {
        if (instance == null) {
            instance = new TipoChar();
        }
        return instance;
    }
}
