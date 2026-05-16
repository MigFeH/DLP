grammar TSmm;
@header { // para meter todos los imports
import ast.*;
import ast.expresiones.*;
import ast.definiciones.*;
import ast.tipos.*;
import ast.sentencia.*;
import errorhandler.*;
}

// para generar el parser: control + shift + g

// --------------------------------
// ------ REGLAS SINTACTICAS ------
// --- Tokens en orden correcto ---

program returns [Programa ast] locals [List<Definicion> defs = new ArrayList<>()]:
            (
                var_definition { $defs.addAll($var_definition.ast); }
                    |
                function_definition { $defs.add($function_definition.ast); }
            )* main=main_function_definition EOF {
                $defs.add($main.ast);
                $ast = new Programa($defs);
            }
            ;

main_function_definition returns [DefinicionFunc ast] locals [List<DefinicionVar> parametros = new ArrayList<>(),
    List<DefinicionVar> definicionesVariables = new ArrayList<>(),
    List<Sentencia> sentencias = new ArrayList<>()]:

            START='function' 'main' '(' ')' ':' 'void' '{' (var_definition { $definicionesVariables.addAll($var_definition.ast); })* (statement { $sentencias.add($statement.ast); } )* '}' {
                $ast = new DefinicionFunc(
                    $START.getLine(),
                    $START.getCharPositionInLine() + 1,
                    new TipoFuncion(TipoVoid.getInstance(), $parametros),
                    "main",
                    $definicionesVariables,
                    $sentencias);
            }
            ;

expression returns [Expresion ast] locals [Variable variable, List<Expresion> argumentos]:
            INT_CONSTANT {
                $ast = new ConstanteInt(
                    $INT_CONSTANT.getLine(),
                    $INT_CONSTANT.getCharPositionInLine() + 1,
                    LexerHelper.lexemeToInt($INT_CONSTANT.text));
            }

            | REAL_CONSTANT {
                $ast = new ConstanteReal(
                    $REAL_CONSTANT.getLine(),
                    $REAL_CONSTANT.getCharPositionInLine() + 1,
                    LexerHelper.lexemeToReal($REAL_CONSTANT.text));
            }

            | CHAR_CONSTANT {
                $ast = new ConstanteCaracter(
                    $CHAR_CONSTANT.getLine(),
                    $CHAR_CONSTANT.getCharPositionInLine() + 1,
                    LexerHelper.lexemeToChar($CHAR_CONSTANT.text));
            }

            | ID {
                $ast = new Variable(
                    $ID.getLine(),
                    $ID.getCharPositionInLine() + 1,
                    $ID.text);
            }

            | '(' expression ')' {
                $ast = $expression.ast;
            }

            | e1=expression '[' e2=expression ']' {
                $ast = new AccesoArray(
                    $e1.ast.getLinea(),
                    $e1.ast.getColumna(),
                    $e1.ast,
                    $e2.ast);
            }

            | e1=expression '.' ID {
                $ast = new AccesoCampo(
                    $e1.ast.getLinea(),
                    $e1.ast.getColumna(),
                    $e1.ast,
                    $ID.text);
            }

            | '(' e1=expression 'as' tipo_simple ')' {
                $ast = new Cast(
                    $e1.ast.getLinea(),
                    $e1.ast.getColumna(),
                    $e1.ast,
                    $tipo_simple.ast);
            } // podriamos comprobar que es tipo simple en el sintactico o semantico

            | '-' expression {
                $ast = new MenosUnario(
                    $expression.ast.getLinea(),
                    $expression.ast.getColumna(),
                    $expression.ast);
            }

            | '!' expression {
                $ast = new Negacion(
                    $expression.ast.getLinea(),
                    $expression.ast.getColumna(),
                    $expression.ast);
            }

            | e1=expression OP=('*' | '/' | '%') e2=expression {
                $ast = new Aritmetico(
                    $e1.ast.getLinea(),
                    $e1.ast.getColumna(),
                    $e1.ast,
                    $OP.text,
                    $e2.ast);
            }

            | e1=expression OP=('+' | '-') e2=expression {
                $ast = new Aritmetico(
                    $e1.ast.getLinea(),
                    $e1.ast.getColumna(),
                    $e1.ast,
                    $OP.text,
                    $e2.ast);
            }

            | e1=expression OP=('>' | '>=' | '<' | '<=' | '!=' | '==') e2=expression {
                $ast = new Comparador(
                    $e1.ast.getLinea(),
                    $e1.ast.getColumna(),
                    $e1.ast,
                    $OP.text,
                    $e2.ast);
            }

            | e1=expression OP=('&&' | '||') e2=expression {
                $ast = new Logico(
                    $e1.ast.getLinea(),
                    $e1.ast.getColumna(),
                    $e1.ast,
                    $OP.text,
                    $e2.ast);
            }

            | ID {
                $variable = new Variable(
                    $ID.getLine(),
                    $ID.getCharPositionInLine() + 1,
                    $ID.text);

                $argumentos = new ArrayList<>();
            } '(' (e1=expression { $argumentos.add($e1.ast); } (',' e2=expression { $argumentos.add($e2.ast); })* )? ')' {
                $ast = new Invocacion(
                    $ID.getLine(),
                    $ID.getCharPositionInLine() + 1,
                    $variable,
                    $argumentos);
            }
            ;

statement returns [Sentencia ast] locals [List<Expresion> parametros = new ArrayList<>(),
List<Sentencia> contenidoElse = new ArrayList<>()]:
            START='log' (e1=expression ',' { $parametros.add($e1.ast); })* e2=expression ';' {
                $parametros.add($e2.ast);
                $ast = new Log(
                    $START.getLine(),
                    $START.getCharPositionInLine() + 1,
                    $parametros);
            }

            | START='input' (e1=expression ',' { $parametros.add($e1.ast); })* e2=expression ';' {
                $parametros.add($e2.ast);
                $ast = new Input(
                    $START.getLine(),
                    $START.getCharPositionInLine() + 1,
                    $parametros);
            }

            | asignacion_sin_punto_coma ';' {
                $ast = $asignacion_sin_punto_coma.ast;
            }

            | START='if' '(' condicion=expression ')' cuerpoIf=cuerpo_condicional ('else' cuerpoElse=cuerpo_condicional { $contenidoElse = $cuerpoElse.ast; })? {
                $ast = new If(
                    $START.getLine(),
                    $START.getCharPositionInLine() + 1,
                    $condicion.ast,
                    $cuerpoIf.ast,
                    $contenidoElse);
            }

            | START='while' '(' condicion=expression ')' cuerpo=cuerpo_condicional {
                $ast = new While(
                    $START.getLine(),
                    $START.getCharPositionInLine() + 1,
                    $condicion.ast,
                    $cuerpo.ast);
            }

            | START='return' expression ';' {
                $ast = new Return(
                    $START.getLine(),
                    $START.getCharPositionInLine() + 1,
                    $expression.ast);
            }

            | ID '(' ( (e1=expression ',' { $parametros.add($e1.ast); })* e2=expression { $parametros.add($e2.ast); })? ')' ';' {
                Variable invocado = new Variable(
                    $ID.getLine(),
                    $ID.getCharPositionInLine() + 1,
                    $ID.text);

                $ast = new Invocacion(
                    $ID.getLine(),
                    $ID.getCharPositionInLine() + 1,
                    invocado,
                    $parametros);
            }

            | START='for' '(' inicio_bucle_for ';' fin=expression ';' salto=asignacion_sin_punto_coma ')' cuerpo_condicional {
                $ast = new For(
                    $START.getLine(),
                    $START.getCharPositionInLine() + 1,
                    $inicio_bucle_for.ast,
                    $fin.ast,
                    $salto.ast,
                    $cuerpo_condicional.ast
                );
            }
            ;

asignacion_sin_punto_coma returns [Sentencia ast]:
            e1=expression '=' e2=expression {
                $ast = new Asignacion(
                    $e1.ast.getLinea(),
                    $e1.ast.getColumna(),
                    $e1.ast,
                    $e2.ast);
            }
            ;

inicio_bucle_for returns [List<Sentencia> ast = new ArrayList<>()]:
            asignacion_sin_punto_coma { $ast.add($asignacion_sin_punto_coma.ast); }
            | definicion_inicializacion_simple { $ast.addAll($definicion_inicializacion_simple.ast); }
            ;

definicion_inicializacion_simple returns [List<Sentencia> ast = new ArrayList<>()]:
            'let' ID ':' tipo '=' expression {
                Variable var = new Variable($ID.getLine(), $ID.getCharPositionInLine() + 1, $ID.text);

                $ast.add(new DefinicionVar(
                    var.getLinea(),
                    var.getColumna(),
                    $tipo.ast,
                    var.getNombre()
                ));

                $ast.add(new Asignacion(
                    var.getLinea(),
                    var.getColumna(),
                    var,
                    $expression.ast
                ));
            }
            ;

cuerpo_condicional returns [List<Sentencia> ast = new ArrayList<>()]:
            '{' (statement { $ast.add($statement.ast); })* '}'
            | statement { $ast.add($statement.ast); }
            ;

tipo_simple returns [Tipo ast]:
            'int' { $ast = TipoInt.getInstance(); }
            | 'number' { $ast = TipoNumber.getInstance(); }
            | 'char' { $ast = TipoChar.getInstance(); }
            ;

tipo returns [Tipo ast] locals [List<DefinicionVar> lineasDefiniciones = new ArrayList<>()]:
            '[' INT_CONSTANT ']' tipo {
                $ast = new TipoArray(
                    $tipo.ast,
                    LexerHelper.lexemeToInt($INT_CONSTANT.text));
            }

            | '[' (var_definition { $lineasDefiniciones.addAll($var_definition.ast); })+ ']' {
                /* Con add no tenemos promocion de tipos hacia arriba, pero con addAll si */
                List<CampoRecord> camposRegistro = new ArrayList<>();
                List<String> nombresCamposRegistro = new ArrayList<>();

                for(DefinicionVar variable : $lineasDefiniciones) {

                    // Comprobacion de errores semanticos //

                    // Comprobacion: duplicated field
                    if(nombresCamposRegistro.contains(variable.getNombre())) {
                        $ast = new ErrorType("duplicated field", variable);
                    } else {
                        nombresCamposRegistro.add(variable.getNombre());
                    }

                    // ---------------------------------- //

                    camposRegistro.add(new CampoRecord(
                        variable.getLinea(),
                        variable.getColumna(),
                        variable.getTipo(),
                        variable.getNombre()));
                }

                $ast = new TipoRecord(camposRegistro);
            }

            | tipo_simple {
                $ast = $tipo_simple.ast;
            }
            ;

var_definition returns [List<DefinicionVar> ast = new ArrayList<>()] locals [List<Variable> ids = new ArrayList<>()]:
            'let' (ID1=ID ',' { $ids.add(new Variable($ID1.getLine(), $ID1.getCharPositionInLine() + 1, $ID1.text)); })* ID2=ID { $ids.add(new Variable($ID2.getLine(), $ID2.getCharPositionInLine() + 1, $ID2.text)); } ':' tipo ';' {

                for(Variable id : $ids) {
                    $ast.add(new DefinicionVar(
                        id.getLinea(),
                        id.getColumna(),
                        $tipo.ast,
                        id.getNombre()));
                }
            }
            ;

function_definition returns [DefinicionFunc ast] locals [List<DefinicionVar> parametros = new ArrayList<>(),
    List<DefinicionVar> definicionesVariables = new ArrayList<>(),
    List<Sentencia> sentencias = new ArrayList<>()]:

            START='function' ID function_type '{' (var_definition { $definicionesVariables.addAll($var_definition.ast); })* (statement { $sentencias.add($statement.ast); } )* '}' {
                $ast = new DefinicionFunc(
                    $START.getLine(),
                    $START.getCharPositionInLine() + 1,
                    $function_type.ast,
                    $ID.text,
                    $definicionesVariables,
                    $sentencias);
            }
            ;

function_type returns [TipoFuncion ast] locals [List<DefinicionVar> parametros = new ArrayList<>()]:
            '(' ((param1=function_param ',' { $parametros.add($param1.ast); })* param2=function_param { $parametros.add($param2.ast); } )? ')' ':' tipoRetorno=function_return_type {
                $ast = new TipoFuncion(
                    $tipoRetorno.ast,
                    $parametros);
            }
            ;

function_param returns [DefinicionVar ast]:
            ID ':' tipo_simple {
                $ast = new DefinicionVar(
                    $ID.getLine(),
                    $ID.getCharPositionInLine() + 1,
                    $tipo_simple.ast,
                    $ID.text);
            } // podriamos comprobar que es tipo simple en el sintactico o en el semantico
            ;

function_return_type returns [Tipo ast]:
            tipo_simple {
                $ast = $tipo_simple.ast;
            } // podriamos comprobar que es tipo simple en el sintactico o en el semantico

            | 'void' {
                $ast = TipoVoid.getInstance();
            }
            ;


// ----------------------------
// ------ REGLAS LEXICAS ------
// ---- Tokens permitidos -----

// token : lexema
WHITE_SPACES: [\t\n\r ]+ -> skip
            ;

// Constantes
INT_CONSTANT: [1-9][0-9]*
            | '0'
            ;

REAL_CONSTANT: DIGITO* '.' DIGITO*
            | DIGITO* '.'? DIGITO* EXPONENTE
            ;

CHAR_CONSTANT: '\''.'\''
            | '\'' '\\' DIGITO+ '\''
            | '\'' '\\n' '\''
            | '\'' '\\t' '\''
            ;

fragment // Para que EXPONENTE no lo reconozca como token, sino como un fragmento reutilizable en otras reglas
EXPONENTE: [eE][+-]? DIGITO+
            ;

// Comentarios
COMENTARIO_UNILINEA: '//'.*?('\n' | EOF | '\r') -> skip
            ;

COMENTARIO_MULTILINEA: '/*'.*?'*/' -> skip
            ;

// Ids
ID: (LETRA | '_') (LETRA | DIGITO | '_')*
            ;

fragment
LETRA: [a-zA-Z]
            ;

fragment
DIGITO: [0-9]
            ;

