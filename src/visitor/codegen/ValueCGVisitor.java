package visitor.codegen;

import ast.expresiones.*;
import ast.tipos.Tipo;
import ast.tipos.TipoFuncion;
import ast.tipos.TipoInt;
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
        // obtenemos la dir de memoria del elemento del array accedido y lo dejamos en el tope de la pila
        a.accept(address, p);

        // popeamos la dir de memoria del tope de la pila y apilamos el valor almacenado en esa dir de memoria en el tope de la pila
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
        // obtenemos la dir de memoria del campo del record accedido y lo dejamos en el tope de la pila
        a.accept(address, p);

        // popeamos la dir de memoria del tope de la pila y apilamos el valor almacenado en esa dir de memoria en el tope de la pila
        cg.load(a.getTipo());
        return null;
    }

    /**
     * value[[Aritmetico: expresion1 -> expresion2 (+|-|*|/|%) expresion3]]() =
     *      value[[expresion2]]()
     *      cg.convertTo(expresion2.type, expresion1.type);
     *      value[[expresion3]]()
     *      cg.convertTo(expresion3.type, expresion1.type);
     *      cg.arithmetic(expresion1.operador, expresion1.type);
     */
    @Override
    public Void visit(Aritmetico a, Void p) {
        // obtenemos el valor de la parte izq de la operacion aritmetica y lo dejamos en el tope de la pila
        a.getIzquierda().accept(this, p);

        // convertimos el tipo de la parte izq de la operacion aritmetica en el tipo del resultado de la operacion aritmetica
        cg.convertTo(a.getIzquierda().getTipo(), a.getTipo());

        // obtenemos el valor de la parte der de la operacion aritmetica y lo dejamos en el tope de la pila
        a.getDerecha().accept(this, p);

        // convertimos el tipo de la parte der de la operacion aritmetica en el tipo del resultado de la operacion aritmetica
        cg.convertTo(a.getDerecha().getTipo(), a.getTipo());

        // popeamos dos veces la pila, llevamos a cabo la operacion aritmetica y dejamos en el tope de la pila el resultado de la operacion aritmetica
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
        // obtenemos el valor de la parte izq del cast y lo dejamos en el tope de la pila
        c.getIzquierda().accept(this, p);

        // popeamos y convertimos el tipo del valor de la parte izq del cast en el tipo de la parte der del cast y lo dejamos en el tope de la pila
        cg.convertTo(c.getIzquierda().getTipo(), c.getDerecha());
        return null;
    }

    /**
     * value[[Comparador: expresion1 -> expresion2 (>|>=|<|<=|!=|==) expresion3]]() =
     *      Tipo tipoDominante = expresion1.type.getTipoDominante(expresion2.type, expresion3.type);
     *      value[[expresion2]]()
     *      cg.convertTo(expresion2.type, tipoDominante);
     *      value[[expresion3]]()
     *      cg.convertTo(expresion3.type, tipoDominante);
     *      cg.comparison(expresion1.operador, tipoDominante);
     */
    @Override
    public Void visit(Comparador c, Void p) {
        Tipo tipoDominante = c.getTipo().getTipoDominante(c.getIzquierda().getTipo(), c.getDerecha().getTipo(), c);

        // obtenemos el valor de la parte izq del comparador y lo dejamos en el tope de la pila
        c.getIzquierda().accept(this, p);

        // popeamos y convertimos el tipo del valor de la parte izq del comparador en el tipo dominante de la comparacion y lo dejamos en el tope de la pila
        cg.convertTo(c.getIzquierda().getTipo(), tipoDominante);

        // obtenemos el valor de la parte der del comparador y lo dejamos en el tope de la pila
        c.getDerecha().accept(this, p);

        // popeamos y convertimos el tipo del valor de la parte der del comparador en el tipo dominante de la comparacion y lo dejamos en el tope de la pila
        cg.convertTo(c.getDerecha().getTipo(), tipoDominante);

        // popeamos dos veces la pila, llevamos a cabo la comparacion y dejamos en el tope de la pila el resultado de la comparacion
        cg.comparison(c.getOperador(), tipoDominante);
        return null;
    }


    /**
     * value[[ConstanteCaracter: expresion -> CHAR_CONSTANT]]() =
     *      <push> expresion.type.suffix() expresion.valor
     */
    @Override
    public Void visit(ConstanteCaracter c, Void p) {
        // dejamos en el tope de la pila el valor de la constante de tipo caracter
        cg.push(c.getTipo(), (int) c.getValor());
        return null;
    }

    /**
     * value[[ConstanteInt: expresion -> INT_CONSTANT]]() =
     *      <push> expresion.type.suffix() expresion.valor
     */
    @Override
    public Void visit(ConstanteInt c, Void p) {
        // dejamos en el tope de la pila el valor de la constante de tipo int
        cg.push(c.getTipo(), c.getValor());
        return null;
    }

    /**
     * value[[ConstanteReal: expresion -> REAL_CONSTANT]]() =
     *      <push> expresion.type.suffix() expresion.valor
     */
    @Override
    public Void visit(ConstanteReal c, Void p) {
        // dejamos en el tope de la pila el valor de la constante de tipo real
        cg.push(c.getTipo(), c.getValor());
        return null;
    }

    /**
     * value[[Invocacion: expresion1 -> expresion2 expresion3*]]() =
     * 	    for(int i = 0; i < expresion3*.size(); i++) {
     * 		    value[[expresion3*.get(i)]]()
     * 		    cg.convertTo(expresion3*.get(i).type, expresion2.type.parameters.get(i).type);
     * 	    }
     * 	    <call> expresion2.name
     */
    @Override
    public Void visit(Invocacion i, Void p) {
        // procesamos los valores de los argumentos de la invocacion
        for(int index = 0; index < i.getArgumentos().size(); index++) {

            // obtenemos el valor del argumento i-esimo de la invocacion y lo dejamos en el tope de la pila
            i.getArgumentos().get(index).accept(this, p);

            TipoFuncion tipoFuncion = (TipoFuncion) i.getInvocado().getDefinicion().getTipo();

            // popeamos y convertimos el tipo del valor del argumento i-esimo de la invocacion en el tipo del parámetro i-esimo de la definicion de la funcion que se invoca y lo dejamos en el tope de la pila
            cg.convertTo(
                    i.getArgumentos().get(index).getTipo(),
                    tipoFuncion.getParametros().get(index).getTipo()
            );
        }

        // invocamos a la funcion
        cg.call(i.getInvocado().getNombre());
        return null;
    }

    /**
     * value[[Logico: expresion1 -> expresion2 (&& | ||) expresion3]]() =
     *      value[[expresion2]]()
     *      value[[expresion3]]()
     *      cg.logical(expresion1.operador);
     */
    @Override
    public Void visit(Logico l, Void p) {
        // obtenemos el valor de la parte izq de la operacion logica y lo dejamos en el tope de la pila
        l.getIzquierda().accept(this, p);

        // obtenemos el valor de la parte der de la operacion logica y lo dejamos en el tope de la pila
        l.getDerecha().accept(this, p);

        // popeamos una o dos veces la pila, llevamos a cabo la operacion logica y dejamos en el tope de la pila el resultado de la operacion logica
        cg.logical(l.getOperador());
        return null;
    }

    /**
     * value[[MenosUnario: expresion1 -> expresion2]]() =
     *      value[[expresion2]]()
     *      cg.convertTo(expresion2.type, expresion1.type)
     *      <pushi> 0
     *      cg.arithmetic("-", expresion2.type)
     */
    @Override
    public Void visit(MenosUnario m, Void p) {
        // obtenemos el valor del operando del menos unario y lo dejamos en el tope de la pila
        m.getOperando().accept(this, p);

        // popeamos y convertimos el tipo del valor del operando del menos unario en el tipo del resultado de la operacion menos unario y lo dejamos en el tope de la pila
        cg.convertTo(m.getOperando().getTipo(), m.getTipo());

        // dejamos en el tope de la pila una entero de valor 0
        cg.push(TipoInt.getInstance(), 0);

        // popeamos dos veces la pila, llevamos a cabo la operacion aritmetica y dejamos en el tope de la pila el resultado de la operacion aritmetica
        cg.arithmetic("-", m.getOperando().getTipo());
        return null;
    }

    /**
     * value[[Negacion: expresion1 -> expresion2]]() =
     *      value[[expresion2]]()
     *      cg.logical("!");
     */
    @Override
    public Void visit(Negacion n, Void p) {
        // obtenemos el valor del operando de la negacion y lo dejamos en el tope de la pila
        n.getOperando().accept(this, p);

        // popeamos una vez la pila, llevamos a cabo la operacion logica y dejamos en el tope de la pila el resultado de la operacion logica
        cg.logical("!");
        return null;
    }

    /**
     * value[[Variable: expresion -> ID]]() =
     *      address[[expresion]]()
     *      <load> expresion.type.suffix()
     */
    @Override
    public Void visit(Variable v, Void p) {
        // obtenemos la dir de memoria de la variable y la dejamos en el tope de la pila
        v.accept(address, p);

        // popeamos la dir de memoria de la pila y dejamos en el tope de la pila el contenido almacenado en la dir de memoria popeada
        cg.load(v.getTipo());
        return null;
    }
}
