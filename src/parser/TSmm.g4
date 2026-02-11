grammar TSmm;	

program: INT_CONSTANT+
       ;


// ----------------------------
// ------ REGLAS LEXICAS ------

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
COMENTARIO_UNILINEA: '//'.*?'\n' -> skip
            ;

COMENTARIO_MULTILINEA: '/*'.*?'*/' -> skip
            ;

// Ids
ID: (LETRA | '_') (LETRA | DIGITO | '_')+
            ;

fragment
LETRA: [a-zA-Z]
            ;

fragment
DIGITO: [0-9]
            ;
