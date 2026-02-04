package ast.tipos;

import ast.definiciones.DefinicionVar;

import java.util.List;

public class TipoFuncion implements Tipo {

    private Tipo tipoRetorno;
    private List<DefinicionVar> parametros;

    public TipoFuncion(Tipo tipoRetorno, List<DefinicionVar> parametros) {
        this.tipoRetorno = tipoRetorno;
        this.parametros = parametros;
    }

    public Tipo getTipoRetorno() {
        return this.tipoRetorno;
    }

    public List<DefinicionVar> getParametros() {
        return this.parametros;
    }
}
