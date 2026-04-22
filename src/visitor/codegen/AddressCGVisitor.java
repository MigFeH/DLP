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
     * 	    address[[expr2]]() // la dirección del struct (es la dir base para poder calcular la dir del campo al que queremos acceder, ya que es relativa a la dir del struct)
     * 	    <pushi> expr2.type.getField(ID).offset // pusheamos (meter en la pila) el offset del campo al que queremos acceder)
     * 	    <addi> // sumamos la dir base del struct + offset del campo al que queremos acceder => el resultado es la dir base del campo al que queremos acceder
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
     * 	    address[[expr2]]() // la dirección del array (es la dir base para poder calcular la dir de la posición a la que queremos acceder, ya que es relativa a la dir del array)
     * 	    value[[expr3]]() // el valor del índice
     * 	    cg.convertTo(expr3.type, TipoInt.getInstance()) // para no permitir a['a']
     * 	    <pushi> expr1.type.numberOfBytes() // expr1 es a[0], y su tipo es el tipo de los elementos del array
     * 	    <muli> //índice * numberOfBytes del tipo de elementos del array
     * 	    <addi> // la multiplicación anterior + dirección base del array => el resultado es la dir base de la posición a la que queremos acceder
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
