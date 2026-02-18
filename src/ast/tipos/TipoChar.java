package ast.tipos;

public class TipoChar implements Tipo {

    private static TipoChar instance;

    private TipoChar() {}

    public static TipoChar getInstance() {
        if (instance == null) {
            instance = new TipoChar();
        }
        return instance;
    }
}
