package visitor;

import ast.definiciones.DefinicionFunc;
import ast.definiciones.DefinicionVar;
import ast.tipos.CampoRecord;
import ast.tipos.TipoFuncion;
import ast.tipos.TipoRecord;

public class OffsetVisitor extends AbstractVisitor<Boolean, Void> {

    private int globalBytesAcumulator;
    private int paramBytesAcumulador;
    private int localBytesAcumulator;

    @Override
    public Void visit(DefinicionVar d, Boolean pt) {
        super.visit(d, pt);

        if(d.getScope() == 0) {
            d.setOffset(globalBytesAcumulator);
            globalBytesAcumulator += d.getTipo().numberOfBytes();
        } else {
            if(pt) { // el padre es el TipoFuncion. La variable es un parametro
                d.setOffset(4 + paramBytesAcumulador);
                paramBytesAcumulador += d.getTipo().numberOfBytes();
            } else { // el padre es el DefinicionFunc. La variable es una variable local
                d.setOffset(-localBytesAcumulator);
                localBytesAcumulator += d.getTipo().numberOfBytes();
            }
        }

        return null;
    }

    @Override
    public Void visit(TipoFuncion t, Boolean pt) {
        // calculamos el offset de los parametros con un for-each y un acumulador local

        // recorrer los param de der a izq (NO VISITAMOS LOS HIJOS CON SUPER AQUI)
        for(int i = t.getParametros().size() - 1; i >= 0; i--) {
            t.getParametros().get(i).accept(this, true);
        }

        paramBytesAcumulador = 0;

        return null;
    }

    @Override
    public Void visit(DefinicionFunc d, Boolean aBoolean) {
        localBytesAcumulator = 0;

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
}
