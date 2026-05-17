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
    RT visit(CampoRecord c, PT pt);
    RT visit(TipoArray t, PT pt);
    RT visit(TipoChar t, PT pt);
    RT visit(TipoFuncion t, PT pt);
    RT visit(TipoInt t, PT pt);
    RT visit(TipoNumber t, PT pt);
    RT visit(TipoRecord t, PT pt);
    RT visit(TipoVoid t, PT pt);
    RT visit(While w, PT pt);
    RT visit(Return r, PT pt);
    RT visit(Log l, PT pt);
    RT visit(Input i, PT pt);
    RT visit(If i, PT pt);
    RT visit(Asignacion a, PT pt);
    RT visit(Negacion n, PT pt);
    RT visit(MenosUnario m, PT pt);
    RT visit(Logico l, PT pt);
    RT visit(ConstanteReal c, PT pt);
    RT visit(ConstanteCaracter c, PT pt);
    RT visit(Comparador c, PT pt);
    RT visit(Cast c, PT pt);
    RT visit(AccesoCampo a, PT pt);
    RT visit(AccesoArray a, PT pt);
    RT visit(DefinicionVar d, PT pt);
    RT visit(DefinicionFunc d, PT pt);
    RT visit(Invocacion i, PT pt);
    RT visit(ErrorType e, PT pt);
    RT visit(ForEach f, PT pt);
}
