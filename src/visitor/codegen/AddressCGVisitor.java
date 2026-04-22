package visitor.codegen;

import ast.definiciones.DefinicionVar;
import ast.expresiones.AccesoArray;
import ast.expresiones.AccesoCampo;
import ast.expresiones.Variable;
import ast.tipos.CampoRecord;
import ast.tipos.TipoInt;
import ast.tipos.TipoRecord;
import codegen.CodeGenerator;

public class AddressCGVisitor extends AbstractCGVisitor<Void, Void> {

    // Address: dominio = Variables, ArrayAccess, FieldAccess (son los l-values)
    //      Calcula la direccion de memoria del l-value y me la deja en el tope de la pila

    private ValueCGVisitor value;

    public AddressCGVisitor(CodeGenerator cg) {
        super(cg);
    }

    public void setValueCGVisitor(ValueCGVisitor value) {
        this.value = value;
    }

    /**
     * address[[Variable: exp -> ID]]() =
     *      if(exp.definition.scope == 0) {
     * 			<pusha> exp.definition.offset
     * 		} else {
     * 			<push bp>
     * 			<pushi> exp.definition.offset
     * 			<addi>
     *      }
     */
    @Override
    public Void visit(Variable v, Void p) {
        DefinicionVar definicion = (DefinicionVar) v.getDefinicion();
        if(definicion.getScope() == 0) {
            // variables globales
            cg.pusha(definicion.getOffset());
        } else {
            // variables locales y parametros
            cg.pushBP();
            cg.push(TipoInt.getInstance(), definicion.getOffset());
            cg.add(TipoInt.getInstance());
        }
        return null;
    }

    /**
     * address[[AccesoCampo: expr1 -> expr2 ID]]() =
     * 	    address[[expr2]]()
     * 	    <pushi> expr2.type.getField(ID).offset
     * 	    <addi>
     */
    @Override
    public Void visit(AccesoCampo a, Void p) {
        a.getIzquierda().accept(this, p);
        for(CampoRecord campoRecord : ((TipoRecord) a.getIzquierda().getTipo()).getCampos()) {
            if(campoRecord.getNombre().equals(a.getDerecha())) {
                cg.push(TipoInt.getInstance(), campoRecord.getOffset());
                break;
            }
        }
        cg.add(TipoInt.getInstance());
        return null;
    }

    /**
     * address[[AccesoArray: expr1 -> expr2 expr3]]() =
     * 	    address[[expr2]]()
     * 	    value[[expr3]]()
     * 	    cg.convertTo(expr3.type, TipoInt.getInstance())
     * 	    <pushi> expr1.type.numberOfBytes()
     * 	    <muli>
     * 	    <addi>
     */
    @Override
    public Void visit(AccesoArray a, Void p) {
        a.getIzquierda().accept(this, p);
        a.getDerecha().accept(value, p);
        cg.convertTo(a.getDerecha().getTipo(), TipoInt.getInstance());
        cg.push(TipoInt.getInstance(), a.getTipo().numberOfBytes());
        cg.mul(TipoInt.getInstance());
        cg.add(TipoInt.getInstance());
        return null;
    }
}
