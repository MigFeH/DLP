package codegen;

import ast.tipos.Tipo;

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
        this.source(sourceFilename); // #source "input.txt"

        // al final de cada metodo hay que hacer out.flush()
    }

    public void convertTo(Tipo from, Tipo to) {
        // ...
        out.flush();
    }

    public void store(Tipo tipo) {
        // ...
        out.flush();
    }

    public void push(Tipo tipo, int value) {
        // ...
        out.flush();
    }
}
