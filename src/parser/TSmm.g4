grammar TSmm;
@header { // para meter todos los imports
import ast.*;
import ast.expresiones.*;
import ast.definiciones.*;
import ast.tipos.*;
import ast.sentencia.*;
}

// para generar el parser: control + shift + g

// --------------------------------
// ------ REGLAS SINTACTICAS ------
// --- Tokens en orden correcto ---

program returns [Programa ast] locals [List<Definicion> defs = new ArrayList<>()]:
            (definition { $defs.add($definition.ast); } )*
            main=main_function_definition
            EOF {
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

            | e1=expression '.' e2=expression {
                $ast = new AccesoCampo(
                    $e1.ast.getLinea(),
                    $e1.ast.getColumna(),
                    $e1.ast,
                    $e2.ast);
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
            } '(' ((e1=expression ',' { $argumentos.add($e1.ast); })* e2=expression { $argumentos.add($e2.ast); })? ')' {
                $ast = new Invocacion(
                    $e1.ast.getLinea(),
                    $e1.ast.getColumna(),
                    $variable,
                    $argumentos);
            }
            ;

statement returns [Sentencia ast] locals [List<Expresion> parametros = new ArrayList<>()]:
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

            | e1=expression '=' e2=expression ';' {
                $ast = new Asignacion(
                    $e1.ast.getLinea(),
                    $e1.ast.getColumna(),
                    $e1.ast,
                    $e2.ast);
            }

            | START='if' '(' condicion=expression ')' cuerpoIf=cuerpo_condicional ('else' cuerpoElse=cuerpo_condicional)? {
                $ast = new If(
                    $START.getLine(),
                    $START.getCharPositionInLine() + 1,
                    $condicion.ast,
                    $cuerpoIf.ast,
                    $cuerpoElse.ast);
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

            | '[' (var_definition {
                $lineasDefiniciones.addAll($var_definition.ast);

            })+ ']' {
                List<CampoRecord> camposRegistro = new ArrayList<>();

                for(DefinicionVar variable : $lineasDefiniciones) {
                    camposRegistro.add(new CampoRecord(
                        variable.getLinea(),
                        variable.getColumna(),
                        variable));
                }

                $ast = new TipoRecord(camposRegistro);
            }

            | tipo_simple {
                $ast = $tipo_simple.ast;
            }
            ;

definition returns [Definicion ast]:
            var_definition
            | function_definition
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

