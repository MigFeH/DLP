package ast.tipos;

import java.util.List;

public class TipoRecord implements Tipo {

    private List<CampoRecord> campos;

    public TipoRecord(List<CampoRecord> campos) {
        this.campos = campos;
    }

    public List<CampoRecord> getCampos() {
        return campos;
    }
}
