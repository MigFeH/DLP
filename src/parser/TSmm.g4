grammar TSmm;	

program: definition*
            ;

// ----------------------------
// ------ REGLAS SINTACTICAS ------
// tokens en orden correcto

expression: INT_CONSTANT
            | REAL_CONSTANT
            | CHAR_CONSTANT
            | ID
            | '(' expression ')'
            | expression '[' expression ']'
            | expression '.' expression
            | '(' expression 'as' tipo_simple ')' // podriamos comprobar que es tipo simple en el sintactico o semantico
            | '-' expression
            | '!' expression
            | expression ('*' | '/' | '%') expression
            | expression ('+' | '-') expression
            | expression ('>' | '>=' | '<' | '<=' | '!=' | '==') expression
            | expression ('&&' | '||') expression
            | ID '(' ((expression ',')* expression)? ')'
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

tipo_simple: 'int' | 'number' | 'char'
            ;

tipo: '[' INT_CONSTANT ']' tipo
            | '[' var_definition+ ']'
            | tipo_simple
            ;

definition: var_definition
            | function_definition
            ;

var_definition: 'let' (ID ',')* ID ':' tipo ';'
            ;

function_definition: 'function' ID '(' ((function_param ',')* function_param)? ')' ':' function_return_type '{' function_body '}'
            | 'function' 'main' '(' ')' ':' 'void' '{' function_body '}' EOF
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
// tokens permitidos

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

