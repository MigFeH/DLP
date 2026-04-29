package visitor.codegen;

import ast.expresiones.*;
import ast.tipos.TipoFuncion;
import codegen.CodeGenerator;

public class ValueCGVisitor extends AbstractCGVisitor<Void, Void> {

    // Value: dominio = Expression
    //      Calcula el valor de la expresion y me lo deja en el tope de la pila

    private AddressCGVisitor address;

    public ValueCGVisitor(CodeGenerator cg) {
        super(cg);
    }

    public void setAddressCGVisitor(AddressCGVisitor address) {
        this.address = address;
    }

    /**
     * value[[AccessoArray: expresion1 -> expresion2 expresion3]]() =
     *      address[[expresion1]]()
     *      <load + expresion1.type.suffix()>
     */
    @Override
    public Void visit(AccesoArray a, Void p) {
        a.accept(address, p);
        cg.load(a.getTipo());
        return null;
    }

    /**
     * value[[AccesoCampo: expresion1 -> expresion2 ID]]() =
     *      address[[expresion1]]()
     *      <load + expresion1.type.suffix()>
     */
    @Override
    public Void visit(AccesoCampo a, Void p) {
        a.accept(address, p);
        cg.load(a.getTipo());
        return null;
    }

    /**
     * value[[Aritmetico: expresion1 -> expresion2 (+|-|*|/|%) expresion3]]() =
     *      value[[expresion2]]()
     *      cg.convertTo(expresion2.type, expresion1.type);
     *      value[[expresion3]]()
     *      cg.convertTo(expresion3.type, expresion1.type);
     *      cg.arithmetic(expresion1.getOperador(), expresion1.type);
     */
    @Override
    public Void visit(Aritmetico a, Void p) {
        a.getIzquierda().accept(this, p);
        cg.convertTo(a.getIzquierda().getTipo(), a.getTipo());
        a.getDerecha().accept(this, p);
        cg.convertTo(a.getDerecha().getTipo(), a.getTipo());
        cg.arithmetic(a.getOperador(), a.getTipo());
        return null;
    }

    /**
     * value[[Cast: expresion1 -> expresion2 tipo]]() =
     *      value[[expresion2]]()
     *      cg.convertTo(expresion2.type, tipo);
     */
    @Override
    public Void visit(Cast c, Void p) {
        c.getIzquierda().accept(this, p);
        cg.convertTo(c.getIzquierda().getTipo(), c.getDerecha());
        return null;
    }

    /**
     * value[[Comparador: expresion1 -> expresion2 (>|>=|<|<=|!=|==) expresion3]]() =
     *      value[[expresion2]]()
     *      cg.convertTo(expresion2.type, expresion1.type);
     *      value[[expresion3]]()
     *      cg.convertTo(expresion3.type, expresion1.type);
     *      cg.comparison(expresion1.getOperador(), expresion1.type);
     */
    @Override
    public Void visit(Comparador c, Void p) {
        c.getIzquierda().accept(this, p);
        cg.convertTo(c.getIzquierda().getTipo(), c.getTipo());
        c.getDerecha().accept(this, p);
        cg.convertTo(c.getDerecha().getTipo(), c.getTipo());
        cg.comparison(c.getOperador(), c.getTipo());
        return null;
    }

    /**
     * value[[ConstanteCaracter: expresion -> CHAR_CONSTANT]]() =
     *      <push + expresion.type.suffix()> expresion.getValor()
     */
    @Override
    public Void visit(ConstanteCaracter c, Void p) {
        cg.push(c.getTipo(), (int) c.getValor());
        return null;
    }

    /**
     * value[[ConstanteInt: expresion -> INT_CONSTANT]]() =
     *      <push + expresion.type.suffix()> expresion.getValor()
     */
    @Override
    public Void visit(ConstanteInt c, Void p) {
        cg.push(c.getTipo(), c.getValor());
        return null;
    }

    /**
     * value[[ConstanteReal: expresion -> REAL_CONSTANT]]() =
     *      <push + expresion.type.suffix()> expresion.getValor()
     */
    @Override
    public Void visit(ConstanteReal c, Void p) {
        cg.push(c.getTipo(), c.getValor());
        return null;
    }

    /**
     * value[[Invocacion: expresion1 -> expresion2 expresion3*]]() =
     * 	    for(int i = 0; i < expresion3*.size(); i++) {
     * 		    value[[expresion3*.get(i)]]()
     *
     * 		    cg.convertTo(expresion3*.get(i).type, expresion2.type.parameters.get(i).type);
     * 	    }
     *
     * 	    <call> expresion2.name
     */
    @Override
    public Void visit(Invocacion i, Void p) {
        for(int index = 0; index < i.getArgumentos().size(); index++) {
            i.getArgumentos().get(index).accept(this, p);

            TipoFuncion tipoFuncion = (TipoFuncion) i.getInvocado().getDefinicion().getTipo();
            cg.convertTo(
                    i.getArgumentos().get(index).getTipo(),
                    tipoFuncion.getParametros().get(index).getTipo()
            );
        }

        cg.call(i.getInvocado().getNombre());

        return null;
    }

    /**
     * value[[Logico: expresion1 -> expresion2 (&& | ||) expresion3]]() =
     *      value[[expresion2]]()
     *      value[[expresion3]]()
     *      cg.logical(expresion1.getOperador());
     */
    @Override
    public Void visit(Logico l, Void p) {
        l.getIzquierda().accept(this, p);
        l.getDerecha().accept(this, p);
        cg.logical(l.getOperador());
        return null;
    }

    @Override
    public Void visit(MenosUnario m, Void p) {
        return null;
    }

    /**
     * value[[Negacion: expresion1 -> expresion2]]() =
     *      value[[expresion2]]()
     *      cg.logical("!");
     */
    @Override
    public Void visit(Negacion n, Void p) {
        n.getOperando().accept(this, p);
        cg.logical("!");
        return null;
    }

    /**
     * value[[Variable: expresion -> ID]]() =
     *      address[[expresion]]()
     *      <load + expresion.type.suffix()>
     */
    @Override
    public Void visit(Variable v, Void p) {
        v.accept(address, p);
        cg.load(v.getTipo());
        return null;
    }
}
