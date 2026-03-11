package visitor;

import ast.Programa;
import ast.definiciones.DefinicionFunc;
import ast.definiciones.DefinicionVar;
import ast.expresiones.*;
import ast.sentencia.*;
import ast.tipos.*;

public interface Visitor<PT /* <==ParamType*/, RT /* <== ReturnType*/> {
    RT visit(Programa p, PT pt);
    RT visit(ConstanteInt i, PT pt);
    RT visit(Variable v, PT pt);
    RT visit(Aritmetico a, PT pt);
    RT visit(CampoRecord campoRecord, PT tp);
    RT visit(TipoArray tipoArray, PT pt);
    RT visit(TipoChar tipoChar, PT pt);
    RT visit(TipoFuncion tipoFuncion, PT pt);
    RT visit(TipoInt tipoInt, PT pt);
    RT visit(TipoNumber tipoNumber, PT pt);
    RT visit(TipoRecord tipoRecord, PT pt);
    RT visit(TipoVoid tipoVoid, PT pt);
    RT visit(While aWhile, PT pt);
    RT visit(Return aReturn, PT pt);
    RT visit(Log log, PT pt);
    RT visit(Input input, PT pt);
    RT visit(If anIf, PT pt);
    RT visit(Asignacion asignacion, PT pt);
    RT visit(Negacion negacion, PT pt);
    RT visit(MenosUnario menosUnario, PT pt);
    RT visit(Logico logico, PT pt);
    RT visit(ConstanteReal constanteReal, PT pt);
    RT visit(ConstanteCaracter constanteCaracter, PT pt);
    RT visit(Comparador comparador, PT pt);
    RT visit(Cast cast, PT pt);
    RT visit(AccesoCampo accesoCampo, PT pt);
    RT visit(AccesoArray accesoArray, PT pt);
    RT visit(DefinicionVar definicionVar, PT pt);
    RT visit(DefinicionFunc definicionFunc, PT pt);
    RT visit(Invocacion invocacion, PT pt);
    RT visit(ErrorType errorType, PT pt);
}
