package visitor.codegen;

import ast.Programa;
import ast.definiciones.DefinicionFunc;
import ast.definiciones.DefinicionVar;
import ast.tipos.CampoRecord;
import ast.tipos.TipoFuncion;
import ast.tipos.TipoRecord;
import visitor.semantic.AbstractVisitor;

public class OffsetVisitor extends AbstractVisitor<Boolean, Void> {


    /**
     * |----------------------------|
     * |                            |
     * |    Memoria estatica:       |
     * |        variables globales  |
     * |                            |
     * |----------------------------|
     * |                            |
     * |    Memoria dinamica:       |
     * |        variables locales,  |
     * |        campos de record    |
     * |        y parametros        |
     * |                            |
     * | ---------------------------|
     */

    private int globalBytesAcumulator;
    private int paramBytesAcumulator;
    private int localBytesAcumulator;

    @Override
    public Void visit(DefinicionVar d, Boolean pt) {
        super.visit(d, pt);

        if(d.getScope() == 0) {
            d.setOffset(globalBytesAcumulator);
            globalBytesAcumulator += d.getTipo().numberOfBytes();
        } else {
            if(pt) { // el padre es el TipoFuncion. La variable es un parametro
                d.setOffset(4 + paramBytesAcumulator);
                paramBytesAcumulator += d.getTipo().numberOfBytes();
            } else { // el padre es el DefinicionFunc. La variable es una variable local
                localBytesAcumulator += d.getTipo().numberOfBytes();
                d.setOffset(-localBytesAcumulator);
            }
        }

        return null;
    }

    @Override
    public Void visit(TipoFuncion t, Boolean pt) {
        paramBytesAcumulator = 0;

        for(int i = t.getParametros().size() - 1; i >= 0; i--) {
            t.getParametros().get(i).accept(this, true);
        }

        return null;
    }

    @Override
    public Void visit(DefinicionFunc d, Boolean pt) {
        localBytesAcumulator = 0;

        d.getTipo().accept(this, pt);
        for(DefinicionVar definicionVar : d.getDefinicionesVariables()) {
            definicionVar.accept(this, false);
        }

        d.setLocalBytesSum(localBytesAcumulator);

        return null;
    }

    @Override
    public Void visit(TipoRecord t, Boolean pt) {
        super.visit(t, pt);

        int recordFieldBytesAcumulator = 0;
        for(CampoRecord campo : t.getCampos()) {
            campo.setOffset(recordFieldBytesAcumulator);
            recordFieldBytesAcumulator += campo.getTipo().numberOfBytes();
        }

        return null;
    }

    @Override
    public Void visit(Programa p, Boolean pt) {
        super.visit(p, pt);

        p.setGlobalBytes(this.globalBytesAcumulator);

        return null;
    }
}
