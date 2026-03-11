package ast.tipos;

import ast.ASTNode;
import visitor.Visitor;

import java.util.List;

public class TipoRecord implements Tipo, ASTNode {

    private List<CampoRecord> campos;

    public TipoRecord(List<CampoRecord> campos) {
        this.campos = campos;
    }

    public List<CampoRecord> getCampos() {
        return this.campos;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
