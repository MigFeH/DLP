package visitor.codegen;

import ast.definiciones.*;
import ast.expresiones.Expresion;
import ast.expresiones.Invocacion;
import ast.sentencia.*;
import ast.Programa;
import ast.tipos.TipoFuncion;
import ast.tipos.TipoInt;
import ast.tipos.TipoVoid;
import codegen.CodeGenerator;

public class ExecuteCGVisitor extends AbstractCGVisitor<Void, Void> {

    // Execute: dominio = Sentencias, Definiciones, Programa (todo menos expresiones y tipos)
    //      Anota el codigo que se ejecuta para una instruccion de alto nivel (y, al contrario que value, limpia la pila)

    // Esta clase ExecuteCGVisitor es el "orquestador"

    private AddressCGVisitor address;
    private ValueCGVisitor value;

    private DefinicionFunc def;

    public ExecuteCGVisitor(CodeGenerator cg) {
        super(cg);
        this.address = new AddressCGVisitor(cg);
        this.value = new ValueCGVisitor(cg);

        this.address.setValueCGVisitor(this.value);
        this.value.setAddressCGVisitor(this.address);
    }

    /**
     * execute[[Programa: programa -> definicion*]]() =
     *      for(Definicion def: definicion*) {
     *          if(def instanceof DefinicionVar) {
     *              execute[[def]]()
     *          }
     *      }
     *      cg.invocationToMain();
     *      for(Definicion def: definicion*) {
     *          if(def instanceof DefinicionFunc) {
     *              execute[[def]]()
     *          }
     *      }
     */
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

    /**
     * execute[[Asignacion: sentencia -> expresion1 expresion2]]() =
     *      <#line> sentencia.getLinea()
     *      <' * Assignment>
     *      address[[expresion1]]()
     *      value[[expresion2]]()
     *      cg.convertTo(expresion2.type, expresion1.type);
     *      <store + expresion1.type.suffix()>
     */
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
     * 	    String end = cg.getLabel();
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
        String cond = cg.getLabel();
        String labelElse = cg.getLabel();
        String end = cg.getLabel();
        cg.label(cond);
        i.getCondicion().accept(value, p);
        cg.convertTo(i.getCondicion().getTipo(), TipoInt.getInstance());
        cg.jz(labelElse);
        i.getCuerpo().forEach(s -> s.accept(this, p));
        cg.jmp(end);
        cg.label(labelElse);
        i.getCuerpoElse().forEach(s -> s.accept(this, p));
        cg.label(end);
        return null;
    }

    /**
     * execute[[Input: sentencia -> expresion*]]() =
     *      for(Expresion exp: expresion*) {
     *          <#line> sentencia.getLinea()
     *          <' * Read>
     *          address[[exp]]()
     *          <in + exp.type.suffix()>
     *          <store + exp.type.suffix()>
     *      }
     */
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

    /**
     * execute[[Log: sentencia -> expresion*]]() =
     *      for(Expresion exp: expresion*) {
     *          <#line> sentencia.getLinea()
     *          <' * Write>
     *          value[[exp]]()
     *          <out + exp.type.suffix()>
     *      }
     */
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

    /**
     * execute[[Return: sentencia -> expresion]](DefinicionFuncion def) =
     *      value[[expresion]]()
     *
     *      cg.convertTo(expresion.type, def.type.returnType);
     *
     *      int bytesParamsTotal = 0;
     *      for(DefinicionVar param: def.type.parameters) {
     *          bytesParamsTotal += param.type.numberOfBytes();
     *      }
     *
     *      <ret> def.type.returnType.numberOfBytes(), def.getLocalBytesSum, bytesParamsTotal
     */
    @Override
    public Void visit(Return r, Void p) {
        r.getExpresion().accept(value, p);
        TipoFuncion tipoFuncion = (TipoFuncion) def.getTipo();

        cg.convertTo(r.getExpresion().getTipo(), tipoFuncion.getTipoRetorno());

        int bytesParamsTotal = 0;
        for(DefinicionVar param: tipoFuncion.getParametros()) {
            bytesParamsTotal += param.getTipo().numberOfBytes();
        }

        cg.ret(
                tipoFuncion.getTipoRetorno().numberOfBytes(),
                def.getLocalBytesSum(),
                bytesParamsTotal
        );

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

    /**
     * execute[[DefinicionFunc: definicion1 -> tipo ID definicion2* sentencia*]]() =
     *      <#line> definicion1.getLinea()
     *      ID <:>
     *      <' * Parameters>
     *
     *      int bytesParamsTotal = 0;
     *      for(DefinicionVar param: tipo.getParametros()) {
     *          execute[[param]]()
     *          bytesParamsTotal += param.type.numberOfBytes();
     *      }
     *
     *      <' * Local variables>
     *      for(DefinicionVar local: definicion2*) {
     *          execute[[local]]()
     *      }
     *
     *      <enter> definicion1.getLocalBytesSum()
     *      for(Sentencia st: sentencia*) {
     *          execute[[st]](definicion1);
     *      }
     *
     *      if(type.returnType == TipoVoid.getInstance()) {
     *          <ret> (
     *              0,
     *              definicion1.getLocalBytesSum(),
     *              bytesParamsTotal
     *          )
     *      }
     */
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
        this.def = d;
        for(Sentencia st: d.getSentencias()) {
            st.accept(this, p);
        }

        if(tipoFuncion.getTipoRetorno() == TipoVoid.getInstance()) {
            cg.ret(
                    0,
                    d.getLocalBytesSum(),
                    bytesParamsTotal
            );
        }
        return null;
    }

    /**
     * execute[[DefinicionVar: definicion -> tipo ID]]() =
     *      <' * > tipo ID <(offset > + definicion.getOffset() <)>
     */
    @Override
    public Void visit(DefinicionVar d, Void p) {
        cg.comment(" * " + d.getTipo() + " " + d.getNombre() + " (offset " + d.getOffset() + ")", true);
        return null;
    }

    /**
     * execute[[Invocacion: sentencia -> expresion1 expresion2*]]() =
     *      value[[(Expresion) sentencia]]()
     *
     * 	    if (expresion1.type.returnType != TipoVoid.getInstance()) {
     * 		    <pop> expresion1.type.returnType.suffix()
     * 	    }
     */
    @Override
    public Void visit(Invocacion i, Void p) {
        i.accept(value, p);
        TipoFuncion tipoFuncion = (TipoFuncion) i.getInvocado().getDefinicion().getTipo();

        if (tipoFuncion.getTipoRetorno() != TipoVoid.getInstance()) {
            cg.pop(tipoFuncion.getTipoRetorno());
        }

        return null;
    }
}
