package ast.tipos;

import ast.ASTNode;
import ast.definiciones.DefinicionVar;
import visitor.Visitor;

import java.util.List;

public class TipoFuncion implements Tipo, ASTNode {

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

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
