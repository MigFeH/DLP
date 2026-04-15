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

    public void store(char suffix) {
        out.println("\tstore" + suffix);
        out.flush();
    }

    public <T> void push(char suffix, T value) {
        out.println("\tpush" + suffix + "\t" + value);
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

    public void in(char suffix) {
        out.println("\tin" + suffix);
        out.flush();
    }

    public void out(char suffix) {
        out.println("\tout" + suffix);
        out.flush();
    }

    public void invocationToMain() {
        this.comment(" Invocation to the main function");
        out.println("call main");
        out.println("halt");
        this.newLine();
    }

    public void arithmetic(String operador, char suffix) {
        switch(operador) {
            case "+":
                this.add(suffix);
                break;

            case "-":
                this.sub(suffix);
                break;

            case "*":
                this.mul(suffix);
                break;

            case "/":
                this.div(suffix);
                break;

            case "%":
                this.mod(suffix);
                break;
        }
    }

    public void mod(char suffix) {
        out.println("\tmod" + suffix);
        out.flush();
    }

    public void div(char suffix) {
        out.println("\tdiv" + suffix);
        out.flush();
    }

    public void mul(char suffix) {
        out.println("\tmul" + suffix);
        out.flush();
    }

    public void sub(char suffix) {
        out.println("\tsub" + suffix);
        out.flush();
    }

    public void add(char suffix) {
        out.println("\tadd" + suffix);
        out.flush();
    }

    public void comparison(String operador, char suffix) {
        switch(operador) {
            case ">":
                out.println("\tgt" + suffix);
                break;

            case "<":
                out.println("\tlt" + suffix);
                break;

            case ">=":
                out.println("\tge" + suffix);
                break;

            case "<=":
                out.println("\tle" + suffix);
                break;

            case "==":
                out.println("\teq" + suffix);
                break;

            case "!=":
                out.println("\tne" + suffix);
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

    public void load(char suffix) {
        out.println("\tload" + suffix);
        out.flush();
    }
}
