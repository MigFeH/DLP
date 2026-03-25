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
        tipoRetorno.mustBeSimpleType(localizacionDelError);
        parametros.forEach(param -> param.getTipo().mustBeSimpleType(localizacionDelError));
    }

    @Override
    public Tipo parenthesis(List<Tipo> typeParams, Locatable localizacionDelError) {
        typeParams.forEach(tipoParametro -> tipoParametro.mustBeSimpleType(localizacionDelError));
        return this.tipoRetorno;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT pt) {
        return v.visit(this, pt);
    }
}
