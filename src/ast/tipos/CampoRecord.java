package ast.tipos;

import ast.definiciones.DefinicionVar;
import ast.locatable.AbstractLocatable;

public class CampoRecord extends AbstractLocatable {

    private DefinicionVar campo;

    public CampoRecord(int linea, int columna, DefinicionVar campo) {
        super(linea, columna);
        this.campo = campo;
    }

    public DefinicionVar getCampo() {
        return campo;
    }

    public void setCampo(DefinicionVar campo) {
        this.campo = campo;
    }
}
