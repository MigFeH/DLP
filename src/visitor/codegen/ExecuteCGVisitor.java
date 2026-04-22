package visitor.codegen;

import ast.definiciones.*;
import ast.expresiones.Expresion;
import ast.sentencia.*;
import ast.Programa;
import ast.tipos.TipoFuncion;
import ast.tipos.TipoInt;
import ast.tipos.TipoVoid;
import codegen.CodeGenerator;

public class ExecuteCGVisitor extends AbstractCGVisitor<Void, Void> {

    // Execute: dominio = Sentencias, Definiciones, Programa (todo menos expresiones y tipos)
    //      Anota el codigo que se ejecuta para una instruccion de alto nivel

    private AddressCGVisitor address;
    private ValueCGVisitor value;

    public ExecuteCGVisitor(CodeGenerator cg) {
        super(cg);
        this.address = new AddressCGVisitor(cg);
        this.value = new ValueCGVisitor(cg);

        this.address.setValueCGVisitor(this.value);
        this.value.setAddressCGVisitor(this.address);
    }

    @Override
    public Void visit(Programa pr, Void p) {
        for(Definicion def: pr.getDefiniciones()) {
            if(def instanceof DefinicionVar) {
                def.accept(this, p);
            }
        }
        cg.newLine();
        cg.invocationToMain();
        for(Definicion def: pr.getDefiniciones()) {
            if(def instanceof DefinicionFunc) {
                def.accept(this, p);
            }
        }
        return null;
    }

    @Override
    public Void visit(Asignacion a, Void p) {
        cg.newLine();
        cg.commentLineNumber(a.getLinea());
        cg.comment(" * Assignment", true);
        a.getIzquierda().accept(address, p);
        a.getDerecha().accept(value, p);
        cg.convertTo(a.getDerecha().getTipo(), a.getIzquierda().getTipo());
        cg.store(a.getIzquierda().getTipo());
        return null;
    }

    /**
     * execute[[If: stmt1 -> expr stmt2* stmt3*]]() =
     * 	    String cond = cg.getLabel();
     * 	    String else = cg.getLabel();
     * 	    cond <:>
     * 	    value[[expr]]() // evaluamos la condición
     * 	    cg.convertTo(expr.type, TipoInt.getInstance());
     * 	    <jz> else
     * 	    stmt2*.forEach(s -> execute[[s]]())
     * 	    <jmp> end
     * 	    else <:>
     * 	    stmt3*.forEach(s -> execute[[s]]())
     * 	    end <:>
     */
    @Override
    public Void visit(If i, Void p) {
        return null;
    }

    @Override
    public Void visit(Input i, Void p) {
        for(Expresion exp: i.getExpresiones()) {
            cg.newLine();
            cg.commentLineNumber(i.getLinea());
            cg.comment(" * Read", true);
            exp.accept(address, p);
            cg.in(exp.getTipo());
            cg.store(exp.getTipo());
        }
        return null;
    }

    @Override
    public Void visit(Log l, Void p) {
        for(Expresion exp: l.getExpresiones()) {
            cg.newLine();
            cg.commentLineNumber(l.getLinea());
            cg.comment(" * Write", true);
            exp.accept(value, p);
            cg.out(exp.getTipo());
        }
        return null;
    }

    @Override
    public Void visit(Return r, Void p) {
        return null;
    }

    /**
     * execute[[While: stmt1 -> expr stmt2*]]() =
     * 	    String cond = cg.getLabel();
     * 	    String end = cg.getLabel();
     * 	    cond <:>
     * 	    value[[expr]]()
     * 	    cg.convertTo(expr.type, TipoInt.getInstance())
     * 	    <jz> end
     * 	    stmt2*.forEach(s -> execute[[s]]())
     * 	    <jmp> cond
     * 	    end <:>
     */
    @Override
    public Void visit(While w, Void p) {
        String cond = cg.getLabel();
        String end = cg.getLabel();
        cg.label(cond);
        w.getCondicion().accept(value, p);
        cg.convertTo(w.getCondicion().getTipo(), TipoInt.getInstance());
        cg.jz(end);
        w.getCuerpo().forEach(s -> s.accept(this, p));
        cg.jmp(cond);
        cg.label(end);
        return null;
    }

    @Override
    public Void visit(DefinicionFunc d, Void p) {
        cg.newLine();
        cg.commentLineNumber(d.getLinea());
        cg.label(d.getNombre());
        cg.comment(" * Parameters", true);
        TipoFuncion tipoFuncion = (TipoFuncion) d.getTipo();

        int bytesParamsTotal = 0;
        for(DefinicionVar param: tipoFuncion.getParametros()) {
            param.accept(this, p);
            bytesParamsTotal += param.getTipo().numberOfBytes();
        }

        cg.comment(" * Local variables", true);
        for(DefinicionVar local: d.getDefinicionesVariables()) {
            local.accept(this, p);
        }

        cg.enter(d.getLocalBytesSum());
        for(Sentencia st: d.getSentencias()) {
            st.accept(this, p);
        }
        cg.ret(
                tipoFuncion.getTipoRetorno() instanceof TipoVoid ?
                        0 : tipoFuncion.getTipoRetorno().numberOfBytes(),
                d.getLocalBytesSum(),
                bytesParamsTotal
        );
        return null;
    }

    @Override
    public Void visit(DefinicionVar d, Void p) {
        cg.comment(" * " + d.getTipo() + " " + d.getNombre() + " (offset " + d.getOffset() + ")", true);
        return null;
    }
}
