package ast.expresiones;

import visitor.Visitor;

public class OperadorTernario extends AbstractExpresion {

    private Expresion condicion;
    private Expresion salidaTrue;
    private Expresion salidaFalse;

    public OperadorTernario(int linea, int columna,
                            Expresion condicion,
                            Expresion salidaTrue, Expresion salidaFalse) {
        super(linea, columna);
        this.condicion = condicion;
        this.salidaTrue = salidaTrue;
        this.salidaFalse = salidaFalse;
    }

    public Expresion getCondicion() {
        return condicion;
    }

    public void setCondicion(Expresion condicion) {
        this.condicion = condicion;
    }

    public Expresion getSalidaTrue() {
        return salidaTrue;
    }

    public void setSalidaTrue(Expresion salidaTrue) {
        this.salidaTrue = salidaTrue;
    }

    public Expresion getSalidaFalse() {
        return salidaFalse;
    }

    public void setSalidaFalse(Expresion salidaFalse) {
        this.salidaFalse = salidaFalse;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
