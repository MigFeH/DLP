package visitor.codegen;

import ast.expresiones.*;
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
     *      <load> expresion1.type.suffix()
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
     *      <load> expresion1.type.suffix()
     */
    @Override
    public Void visit(AccesoCampo a, Void p) {
        a.accept(address, p);
        cg.load(a.getTipo());
        return null;
    }

    /**
     * value[[Aritmetico: expresion1 -> expresion2 ID expresion3]]() =
     *      value[[expresion2]]()
     *      cg.convertTo(expresion2.type, expresion1.type);
     *      value[[expresion3]]()
     *      cg.convertTo(expresion3.type, expresion1.type);
     *      cg.arithmetic(ID, expresion1.type);
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

    @Override
    public Void visit(Comparador c, Void p) {
        c.getIzquierda().accept(this, p);
        cg.convertTo(c.getIzquierda().getTipo(), c.getTipo());
        c.getDerecha().accept(this, p);
        cg.convertTo(c.getDerecha().getTipo(), c.getTipo());
        cg.comparison(c.getOperador(), c.getTipo());
        return null;
    }

    @Override
    public Void visit(ConstanteCaracter c, Void p) {
        cg.push(c.getTipo(), (int) c.getValor());
        return null;
    }

    @Override
    public Void visit(ConstanteInt c, Void p) {
        cg.push(c.getTipo(), c.getValor());
        return null;
    }

    @Override
    public Void visit(ConstanteReal c, Void p) {
        cg.push(c.getTipo(), c.getValor());
        return null;
    }

    @Override
    public Void visit(Invocacion i, Void p) {
        return null;
    }

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

    @Override
    public Void visit(Negacion n, Void p) {
        n.getOperando().accept(this, p);
        cg.logical("!");
        return null;
    }

    @Override
    public Void visit(Variable v, Void p) {
        v.accept(address, p);
        cg.load(v.getTipo());
        return null;
    }
}
