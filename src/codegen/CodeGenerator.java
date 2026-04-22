package codegen;

import ast.tipos.Tipo;
import ast.tipos.TipoChar;
import ast.tipos.TipoInt;
import ast.tipos.TipoNumber;

import java.io.IOException;
import java.io.PrintWriter;

public class CodeGenerator {

    /**
     * plantillas:
     *  Execute: dominio = Sentencias, Definiciones, Programa (todo menos expresiones y tipos)
     *      Anota el codigo que se ejecuta para una instruccion de alto nivel
     *  Value: dominio = Expression
     *      Calcula el valor de la expresion y me lo deja en el tope de la pila
     *  Address: dominio = Variables, ArrayAccess, FieldAccess (son los l-values)
     *      Calcula la direccion de memoria del l-value y me la deja en el tope de la pila
     */

    private PrintWriter out;
    private int contadorIdLabel = 0;

    public CodeGenerator(String outputFilename, String sourceFilename) {
        try {
            this.out = new PrintWriter(outputFilename);
        } catch(IOException e) {
            System.err.println("Error oppening the file " + outputFilename + ".");
            System.exit(-1);
        }
        this.source(sourceFilename);
    }

    public void source(String sourceFilename) {
        this.newLine();
        out.println("#source \"" + sourceFilename + "\"");
        this.newLine();
    }

    public void convertTo(Tipo from, Tipo to) {
        if(from.suffix() == to.suffix()) return;

        if(from == TipoChar.getInstance() && to == TipoNumber.getInstance()) {
            out.println("\t" + from.suffix() + "2" + TipoInt.getInstance().suffix());
            out.println("\t" + TipoInt.getInstance().suffix() + "2" + to.suffix());
        } else {
            out.println("\t" + from.suffix() + "2" + to.suffix());
        }
        out.flush();
    }

    public void store(Tipo tipo) {
        out.println("\tstore" + tipo.suffix());
        out.flush();
    }

    public <T> void push(Tipo tipo, T value) {
        out.println("\tpush" + tipo.suffix() + "\t" + value);
        out.flush();
    }

    public void pusha(int value) {
        out.println("\tpusha\t" + value);
        out.flush();
    }

    public void pushBP() {
        out.println("\tpush\tbp");
        out.flush();
    }

    public void comment(String line) {
        out.println("'" + line);
        out.flush();
    }

    public void comment(String line, Boolean tabulation) {
        if(tabulation != null && tabulation) out.print("\t");
        this.comment(line);
    }

    public void commentLineNumber(int number) {
        out.println("#line\t" + number);
        out.flush();
    }

    public void newLine() {
        out.println();
        out.flush();
    }

    public void label(String nombre) {
        out.println(" " + nombre + ":");
        out.flush();
    }

    public void enter(int bytes) {
        out.println("\tenter\t" + bytes);
        out.flush();
    }

    public void ret(int returnBytes, int localBytes, int paramBytes) {
        out.println("\tret " + returnBytes + ", " + localBytes + ", " + paramBytes);
        out.flush();
    }

    public void in(Tipo tipo) {
        out.println("\tin" + tipo.suffix());
        out.flush();
    }

    public void out(Tipo tipo) {
        out.println("\tout" + tipo.suffix());
        out.flush();
    }

    public void invocationToMain() {
        this.comment(" Invocation to the main function");
        out.println("call main");
        out.println("halt");
        this.newLine();
    }

    public void arithmetic(String operador, Tipo tipo) {
        switch(operador) {
            case "+":
                this.add(tipo);
                break;

            case "-":
                this.sub(tipo);
                break;

            case "*":
                this.mul(tipo);
                break;

            case "/":
                this.div(tipo);
                break;

            case "%":
                this.mod(tipo);
                break;
        }
    }

    public void mod(Tipo tipo) {
        out.println("\tmod" + tipo.suffix());
        out.flush();
    }

    public void div(Tipo tipo) {
        out.println("\tdiv" + tipo.suffix());
        out.flush();
    }

    public void mul(Tipo tipo) {
        out.println("\tmul" + tipo.suffix());
        out.flush();
    }

    public void sub(Tipo tipo) {
        out.println("\tsub" + tipo.suffix());
        out.flush();
    }

    public void add(Tipo tipo) {
        out.println("\tadd" + tipo.suffix());
        out.flush();
    }

    public void comparison(String operador, Tipo tipo) {
        switch(operador) {
            case ">":
                out.println("\tgt" + tipo.suffix());
                break;

            case "<":
                out.println("\tlt" + tipo.suffix());
                break;

            case ">=":
                out.println("\tge" + tipo.suffix());
                break;

            case "<=":
                out.println("\tle" + tipo.suffix());
                break;

            case "==":
                out.println("\teq" + tipo.suffix());
                break;

            case "!=":
                out.println("\tne" + tipo.suffix());
                break;
        }
        out.flush();
    }

    public void logical(String operador) {
        switch(operador) {
            case "&&":
                out.println("\tand");
                break;

            case "||":
                out.println("\tor");
                break;

            case "!":
                out.println("\tnot");
                break;
        }
        out.flush();
    }

    public void load(Tipo tipo) {
        out.println("\tload" + tipo.suffix());
        out.flush();
    }

    public String getLabel() {
        return "label" + contadorIdLabel++;
    }

    public void jmp(String label) {
        out.println("\tjmp " + label);
        out.flush();
    }

    public void jz(String label) {
        out.println("\tjz " + label);
        out.flush();
    }
}
