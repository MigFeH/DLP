grammar TSmm;
@header { // para meter todos los imports
import ast.*;
import ast.expresiones.*;
import ast.definiciones.*;
import ast.tipos.*;
}

// para generar el parser: control + shift + g

// --------------------------------
// ------ REGLAS SINTACTICAS ------
// --- Tokens en orden correcto ---

program returns [Programa ast] locals [List<Definicion> defs = new ArrayList<>()]:
            (definition { $defs.add($definition.ast); } )* { $ast = new Programa($defs); }
            'function' 'main' '(' ')' ':' 'void' '{' function_body '}' EOF
            ;

expression returns [Expresion ast] locals [Variable variable, List<Expresion> argumentos]:
            INT_CONSTANT { $ast = new ConstanteInt($INT_CONSTANT.getLine(), $INT_CONSTANT.getCharPositionInLine() + 1, LexerHelper.lexemeToInt($INT_CONSTANT.text)); }
            | REAL_CONSTANT { $ast = new ConstanteReal($REAL_CONSTANT.getLine(), $REAL_CONSTANT.getCharPositionInLine() + 1, LexerHelper.lexemeToReal($REAL_CONSTANT.text)); }
            | CHAR_CONSTANT { $ast = new ConstanteCaracter($CHAR_CONSTANT.getLine(), $CHAR_CONSTANT.getCharPositionInLine() + 1, LexerHelper.lexemeToChar($CHAR_CONSTANT.text)); }
            | ID { $ast = new Variable($ID.getLine(), $ID.getCharPositionInLine() + 1, $ID.text); }
            | '(' expression ')' { $ast = $expression.ast; }
            | e1=expression '[' e2=expression ']' { $ast = new AccesoArray($e1.ast.getLinea(), $e1.ast.getColumna(), $e1.ast, $e2.ast); }
            | e1=expression '.' e2=expression { $ast = new AccesoCampo($e1.ast.getLinea(), $e1.ast.getColumna(), $e1.ast, $e2.ast); }
            | '(' e1=expression 'as' tipo_simple ')' { $ast = new Cast($e1.ast.getLinea(), $e1.ast.getColumna(), $e1.ast, $tipo_simple.ast); } // podriamos comprobar que es tipo simple en el sintactico o semantico
            | '-' expression { $ast = new MenosUnario($expression.ast.getLinea(), $expression.ast.getColumna(), $expression.ast); }
            | '!' expression { $ast = new Negacion($expression.ast.getLinea(), $expression.ast.getColumna(), $expression.ast); }
            | e1=expression OP=('*' | '/' | '%') e2=expression { $ast = new Aritmetico($e1.ast.getLinea(), $e1.ast.getColumna(), $e1.ast, $OP.text, $e2.ast); }
            | e1=expression OP=('+' | '-') e2=expression { $ast = new Aritmetico($e1.ast.getLinea(), $e1.ast.getColumna(), $e1.ast, $OP.text, $e2.ast); }
            | e1=expression OP=('>' | '>=' | '<' | '<=' | '!=' | '==') e2=expression { $ast = new Comparador($e1.ast.getLinea(), $e1.ast.getColumna(), $e1.ast, $OP.text, $e2.ast); }
            | e1=expression OP=('&&' | '||') e2=expression { $ast = new Logico($e1.ast.getLinea(), $e1.ast.getColumna(), $e1.ast, $OP.text, $e2.ast); }
            | ID {
                $variable = new Variable($ID.getLine(), $ID.getCharPositionInLine() + 1, $ID.text);
                $argumentos = new ArrayList<>();
            } '(' ((e1=expression ',' { $argumentos.add($e1.ast); })* e2=expression { $argumentos.add($e2.ast); })? ')' {
                $ast = new Invocacion($e1.ast.getLinea(), $e1.ast.getColumna(), $variable, $argumentos);
            }
            ;

statement: 'log'  (expression ',')* expression ';'
            | 'input' (expression ',')* expression ';'
            | expression '=' expression ';'
            | 'if' '(' expression ')' cuerpo_condicional ('else' cuerpo_condicional)?
            | 'while' '(' expression ')' cuerpo_condicional
            | 'return' expression ';'
            | ID '(' ( (expression ',')* expression )? ')' ';'
            ;

cuerpo_condicional: '{' statement* '}'
            | statement
            ;

tipo_simple returns [Tipo ast]:
            'int' { $ast = TipoInt.getInstance(); }
            | 'number' { $ast = TipoNumber.getInstance(); }
            | 'char' { $ast = TipoChar.getInstance(); }
            ;

tipo: '[' INT_CONSTANT ']' tipo
            | '[' var_definition+ ']'
            | tipo_simple
            ;

definition returns [Definicion ast]:
            var_definition
            | function_definition
            ;

var_definition returns [List<Definicion> ast = new ArrayList<>()] locals [List<String> ids = new ArrayList<>()]:
            'let' (ID1=ID ',' { $ids.add($ID1.text); })* ID2=ID { $ids.add($ID2.text); } ':' tipo ';' {
                for(String id : $ids) { // <=============================================================================================================================
                    $ast.add(new DefinicionVar(int linea, int columna,
                                                                        Tipo tipo, String nombre));
                }
            }
            ;

function_definition: 'function' ID '(' ((function_param ',')* function_param)? ')' ':' function_return_type '{' function_body '}'
            ;

function_param: ID ':' tipo_simple // podriamos comprobar que es tipo simple en el sintactico o en el semantico
            ;

function_return_type: tipo_simple // podriamos comprobar que es tipo simple en el sintactico o en el semantico
            | 'void'
            ;

function_body: var_definition* statement*
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

