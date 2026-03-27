package ast.tipos;

import ast.definiciones.DefinicionVar;
import ast.locatable.Locatable;
import visitor.Visitor;

import java.util.List;

public class TipoFuncion extends AbstractTipo {

    private Tipo tipoRetorno;
    private List<DefinicionVar> parametros;

    public TipoFuncion(Tipo tipoRetorno, List<DefinicionVar> parametros) {
        this.tipoRetorno = tipoRetorno;
        this.parametros = parametros;
    }

    public Tipo getTipoRetorno() {
        return this.tipoRetorno;
    }

    public List<DefinicionVar> getParametros() {
        return this.parametros;
    }

    @Override
    public void mustBeMain(Locatable localizacionDelError) {
        if(!(tipoRetorno instanceof TipoVoid)) {
            new ErrorType("El tipo de retorno de la definicion de la funcion main no " +
                    "se corresponde con un tipo \"void\"", localizacionDelError);
        }
        if(!parametros.isEmpty()) {
            new ErrorType("La definicion de la funcion main no debe contener parametros",
                    localizacionDelError);
        }
    }

    @Override
    public void mustBeFunctionType(Locatable localizacionDelError) {
        if(!(tipoRetorno instanceof TipoVoid)) {
            tipoRetorno.mustBeSimpleType(localizacionDelError);
        }
        parametros.forEach(param -> param.getTipo().mustBeSimpleType(localizacionDelError));
    }

    @Override
    public Tipo parenthesis(List<Tipo> typeParams, Locatable localizacionDelError) {
        if(typeParams.size() != parametros.size()) {
            return new ErrorType("Número de parámetros en la invocación a función incorrecto", localizacionDelError);
        }

        int index = 0;
        for(Tipo typeParam : typeParams) {
            typeParam.mustBeSimpleType(localizacionDelError);
            Tipo tipoInferido = typeParam.mustPromotesTo(parametros.get(index).getTipo(), localizacionDelError);
            if(tipoInferido instanceof ErrorType) {
                return tipoInferido;
            }
            index++;
        }

        return this.tipoRetorno;
    }

    @Override
    public String toString() {
        return "function";
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
