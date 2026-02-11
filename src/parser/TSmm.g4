grammar TSmm;	

program: INT_CONSTANT+
       ;


// ---------------------
//

WHITE_SPACES: [\t\n\r ]+ -> skip
            ;

INT_CONSTANT: [1-9][0-9]*
            | '0'
            ;

REAL_CONSTANT: MANTISA
            | MANTISA EXPONENTE
            ;

CHAR_CONSTANT: '\''.'\''
            | '\\' algo
            | [\n\t]
            ;

fragment
MANTISA: INT_CONSTANT '.' INT_CONSTANT
            ;

fragment // Para que EXPONENTE no lo reconozca como token, sino como un fragmento reutilizable en otras reglas
EXPONENTE: [eE][+-]INT_CONSTANT
            ;

COMENTARIO_UNILINEA: '//'.*?'\n' -> skip
            ;

COMENTARIO_MULTILINEA: '/*'.*?'*/' -> skip
            ;

ID: (LETRA | '_') (LETRA | DIGITO | '_')+
            ;

fragment
LETRA: [a-zA-Z]
            ;

fragment
DIGITO: [0-9]
            ;
