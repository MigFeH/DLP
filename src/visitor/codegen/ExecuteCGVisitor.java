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
        // procesamos las definiciones de variables globales
        for(Definicion def: pr.getDefiniciones()) {
            if(def instanceof DefinicionVar) {
                def.accept(this, p);
            }
        }

        cg.newLine();
        cg.invocationToMain(); // hacemos el call a main despues de las variables globales y hacemos el halt

        // procesamos las funciones definidas
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
     *      <store> expresion1.type.suffix()
     */
    @Override
    public Void visit(Asignacion a, Void p) {
        cg.newLine();
        cg.commentLineNumber(a.getLinea());
        cg.comment(" * Assignment", true);

        // obtenemos la dir de memoria de la parte izquierda de la asignacion y la dejamos en el tope de la pila
        a.getIzquierda().accept(address, p);

        // obtenemos el valor de la parte derecha de la asignacion y lo dejamos en el tope de la pila
        a.getDerecha().accept(value, p);

        // convertimos el tipo de la parte derecha de la asignacion en el tipo de la parte izquierda de la asignacion
        cg.convertTo(a.getDerecha().getTipo(), a.getIzquierda().getTipo());

        // almacenamos en la direccion de memoria de la parte izquierda de la asignacion el valor de la parte derecha de la asignacion
        cg.store(a.getIzquierda().getTipo());
        return null;
    }

    /**
     * execute[[If: sentencia1 -> expresion sentencia2* sentencia3*]]() =
     * 	    String labelElse = cg.getLabel();
     * 	    String end = cg.getLabel();
     * 	    value[[expresion]]()
     * 	    cg.convertTo(expresion.type, TipoInt.getInstance());
     * 	    <jz> else
     * 	    sentencia2*.forEach(s -> execute[[s]]())
     * 	    <jmp> end
     * 	    else <:>
     * 	    sentencia3*.forEach(s -> execute[[s]]())
     * 	    end <:>
     */
    @Override
    public Void visit(If i, Void p) {
        // obtenemos label para la seccion del else
        String labelElse = cg.getLabel();

        // obtenemos label para la seccion posterior a la seccion del else
        String end = cg.getLabel();

        // evaluamos la condicion y dejamos el resultado en el tope de la pila
        i.getCondicion().accept(value, p);

        // convertimos el tipo de la condicion en el tipo int (que es con el que modelamos los booleanos)
        cg.convertTo(i.getCondicion().getTipo(), TipoInt.getInstance());

        // saltamos al else si la condicion se evaluo a false (valor 0)
        cg.jz(labelElse);

        // ejecutamos el cuerpo de la condicion true
        i.getCuerpo().forEach(s -> s.accept(this, p));

        // saltamos al end (seccion posterior a la seccion else)
        cg.jmp(end);

        // escribimos la label del else
        cg.label(labelElse);

        // ejecutamos el cuerpo de la condicion false (cuerpo else)
        i.getCuerpoElse().forEach(s -> s.accept(this, p));

        // escribimos la label del end (seccion posterior a la seccion else)
        cg.label(end);
        return null;
    }

    /**
     * execute[[Input: sentencia -> expresion*]]() =
     *      for(Expresion exp: expresion*) {
     *          <#line> sentencia.getLinea()
     *          <' * Read>
     *          address[[exp]]()
     *          <in> exp.type.suffix()
     *          <store> exp.type.suffix()
     *      }
     */
    @Override
    public Void visit(Input i, Void p) {
        // procesamos los argumentos del input
        for(Expresion exp: i.getExpresiones()) {
            cg.newLine();
            cg.commentLineNumber(i.getLinea());
            cg.comment(" * Read", true);

            // obtenemos la dir de memoria del argumento i-esimo y lo dejamos en el tope de la pila
            exp.accept(address, p);

            // obtenemos el valor introducido por teclado y lo dejamos en el tope de la pila
            cg.in(exp.getTipo());

            // almacenamos en la direccion de memoria del argumento i-esimo el valor introducido por teclado
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
     *          <out> exp.type.suffix()
     *      }
     */
    @Override
    public Void visit(Log l, Void p) {
        // procesamos los argumentos del log
        for(Expresion exp: l.getExpresiones()) {
            cg.newLine();
            cg.commentLineNumber(l.getLinea());
            cg.comment(" * Write", true);

            // obtenemos el valor del argumento i-esimo y lo dejamos en el tope de la pila
            exp.accept(value, p);

            // desapila el valor de la pila y lo muestra por consola
            cg.out(exp.getTipo());
        }
        return null;
    }

    /**
     * execute[[Return: sentencia -> expresion]](DefinicionFuncion def) =
     *      value[[expresion]]()
     *      cg.convertTo(expresion.type, def.type.returnType);
     *      int bytesParamsTotal = 0;
     *      for(DefinicionVar param: def.type.parameters) {
     *          bytesParamsTotal += param.type.numberOfBytes();
     *      }
     *      <ret> def.type.returnType.numberOfBytes(), def.getLocalBytesSum, bytesParamsTotal
     */
    @Override
    public Void visit(Return r, Void p) {
        // obtenemos el valor a retornar y lo dejamos en el tope de la pila
        r.getExpresion().accept(value, p);

        TipoFuncion tipoFuncion = (TipoFuncion) def.getTipo();

        // convertimos el tipo del valor a retornar en el tipo de retorno de la definicion de la funcion
        cg.convertTo(r.getExpresion().getTipo(), tipoFuncion.getTipoRetorno());

        int bytesParamsTotal = 0;
        for(DefinicionVar param: tipoFuncion.getParametros()) {
            bytesParamsTotal += param.getTipo().numberOfBytes();
        }

        cg.ret(
                tipoFuncion.getTipoRetorno().numberOfBytes(), // total de bytes del tipo de retorno
                def.getLocalBytesSum(), // total de bytes de las variables locales
                bytesParamsTotal // total de bytes de los parametros
        );

        return null;
    }

    /**
     * execute[[While: sentencia1 -> expresion sentencia2*]]() =
     * 	    String cond = cg.getLabel();
     * 	    String end = cg.getLabel();
     * 	    cond <:>
     * 	    value[[expresion]]()
     * 	    cg.convertTo(expresion.type, TipoInt.getInstance())
     * 	    <jz> end
     * 	    sentencia2*.forEach(s -> execute[[s]]())
     * 	    <jmp> cond
     * 	    end <:>
     */
    @Override
    public Void visit(While w, Void p) {
        // obtenemos label para la seccion de la condicion
        String cond = cg.getLabel();

        // obtenemos label para la seccion posterior a la del cuerpo del while
        String end = cg.getLabel();

        // escribimos la label de la condicion
        cg.label(cond);

        // evaluamos la condicion y dejamos el resultado en el tope de la pila
        w.getCondicion().accept(value, p);

        // convertimos el tipo de la condicion en el tipo int (que es con el que modelamos los booleanos)
        cg.convertTo(w.getCondicion().getTipo(), TipoInt.getInstance());

        // hace pop en la pila y saltamos a la label end si el valor popeado es 0
        cg.jz(end);

        // procesamos el cuerpo del while
        w.getCuerpo().forEach(s -> s.accept(this, p));

        // hacemos salto incondicional a la label de la condicion
        cg.jmp(cond);

        // escribimos la label de la seccion end
        cg.label(end);
        return null;
    }

    /**
     * execute[[DefinicionFunc: definicion1 -> tipo ID definicion2* sentencia*]]() =
     *      <#line> definicion1.getLinea()
     *      ID <:>
     *      <' * Parameters>
     *      int bytesParamsTotal = 0;
     *      for(DefinicionVar param: tipo.getParametros()) {
     *          execute[[param]]()
     *          bytesParamsTotal += param.type.numberOfBytes();
     *      }
     *      <' * Local variables>
     *      for(DefinicionVar local: definicion2*) {
     *          execute[[local]]()
     *      }
     *      <enter> definicion1.getLocalBytesSum()
     *      for(Sentencia st: sentencia*) {
     *          execute[[st]](definicion1);
     *      }
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

        // procesamos los parametros de la definicion de la funcion
        int bytesParamsTotal = 0;
        for(DefinicionVar param: tipoFuncion.getParametros()) {
            param.accept(this, p);
            bytesParamsTotal += param.getTipo().numberOfBytes();
        }

        // procesamos las variables locales de la definicion de la funcion
        cg.comment(" * Local variables", true);
        for(DefinicionVar local: d.getDefinicionesVariables()) {
            local.accept(this, p);
        }

        // reservamos memoria para las variables locales
        cg.enter(d.getLocalBytesSum());

        // procesamos las sentencias de la definicion de la funcion
        this.def = d;
        for(Sentencia st: d.getSentencias()) {
            st.accept(this, p);
        }

        if(tipoFuncion.getTipoRetorno() == TipoVoid.getInstance()) {
            cg.ret(
                    0, // total de bytes del tipo de retorno
                    d.getLocalBytesSum(), // total de bytes de las variables locales
                    bytesParamsTotal //  total de bytes de los parametros
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
     * 	    if (expresion1.type.returnType != TipoVoid.getInstance()) {
     * 		    <pop> expresion1.type.returnType.suffix()
     * 	    }
     */
    @Override
    public Void visit(Invocacion i, Void p) {
        // apilamos los argumentos en el tope de la pila y hacemos el call a la funcion invocada
        i.accept(value, p);

        TipoFuncion tipoFuncion = (TipoFuncion) i.getInvocado().getDefinicion().getTipo();

        // desapilamos el valor retornado por la invocacion
        if (tipoFuncion.getTipoRetorno() != TipoVoid.getInstance()) {
            cg.pop(tipoFuncion.getTipoRetorno());
        }

        return null;
    }

    /**
     * execute[[DoWhile: sentencia1 -> sentencia2* expresion]]() =
     *      String labelInicio = cg.getLabel();
     *      labelInicio <:>
     *      sentencia2*.forEach(s -> execute[[s]]())
     *      value[[expresion]]()
     *      cg.convertTo(expresion.type, TipoInt.getInstance());
     *      <jnz> labelInicio
     */
    @Override
    public Void visit(DoWhile d, Void p) {
        String labelInicio = cg.getLabel();
        cg.label(labelInicio);
        d.getCuerpo().forEach(s -> s.accept(this, p));
        d.getCondicion().accept(this.value, p);
        cg.convertTo(d.getCondicion().getTipo(), TipoInt.getInstance());
        cg.jnz(labelInicio);
        return null;
    }
}
