grammar Decaf;

@header {
    package grammar;
}



STRUCT :    'struct' ;
TRUE :      'true' ;
FALSE :     'false' ;
VOID :      'void' ;
IF :        'if' ;
ELSE :      'else' ;
WHILE :     'while' ;
RETURN :    'return' ;
INT :       'int' ;
CHAR :      'char' ;
BOOLEAN :   'boolean' ;
MAIN :      'main';

fragment LETTER : ('a'..'z'|'A'..'Z') ;
fragment DIGIT :'0'..'9' ;


ID : LETTER ( LETTER | DIGIT )* ;
NUM : DIGIT ( DIGIT )* ;
Char : '\'' ( ~['\r\n\\] | '\\' ['\\] ) '\'';


WS : 
    [\t\r\n\f ]+ -> skip
    ;


program
    : 'class' ID '{' (declaration)*  '}'                                            
    ;

declaration
    :   structDeclaration                           
    |   varDeclaration      
    |   methodDeclaration   
    |   VOID MAIN '(' ')' block
    ;
varDeclaration
    :   varType ID ';'                                                          #SingleVarDec
    |   varType ID '[' NUM ']' ';'                                              #ArrayVarDec
    ;

varType                                         
    :   INT             
    |   CHAR                
    |   BOOLEAN
    |   STRUCT ID
    |   structDeclaration       
    |   VOID                
    ;

structDeclaration
    :   STRUCT ID '{' (varDeclaration)* '}' 
    ;

methodDeclaration
    :   methodType ID '('  (parameter (',' parameter)* )? ')' block
    ;

    
methodType
    :   INT             
    |   CHAR                
    |   BOOLEAN             
    |   VOID                
    ;


parameter
    :   parameterType ID                                                        #SingleVarParam
    |   parameterType ID '['']'                                                 #ArrayVarParam
    ;
    
parameterType
    :   INT             
    |   CHAR                
    |   BOOLEAN             
    ;
    

block
    :   '{' (varDeclaration)*(statement)* '}'
    ;

statement
    :   IF '(' expression ')' block (statementElse)?                            #IfState
    |   WHILE '(' expression ')' block                                          #WhileState
    |   RETURN ( expression )? ';'                                              #ReturnState
    |   methodCall ';'                                                          #MethodState    
    |   block                                                                   #BlockState
    |   location '=' expression ';'                                             #AssignState
    |   (expression)?';'                                                        #ExpreState
    ;

statementElse
    :   ELSE block
    ;
    
location
    :   ID ('.' location)*                                                      #SingleVar
    |   ID '[' expression ']' ('.' location)*                                   #ArrayVar
    ;

expression 
    :   '('(INT|CHAR)')'  value                                                 #ConvertValue
    |   '-' value                                                               #SubValue
    |   '!' value                                                               #NotVal     
    |   value                                                                   #SingleValue
    |   expression OP=('*' | '/' | '%') expression                              #MulExpr
    |   expression OP=('+' | '-') expression                                    #AddExpr
    |   expression rel_op expression                                            #RelExpr
    |   expression eq_op expression                                             #EqExpr
    |   expression cond_op expression                                           #CondExpr
    ;

value
    :   location                      
    |   methodCall  
    |   literal
    |   '(' expression ')'
    ;


    
methodCall
    :   ID '(' (arg (',' arg)*)? ')' 
    ;
    
arg
    :   expression
    ;

arith_op
    :   '*'
    |   '/'
    |   '%'
    |   '+'
    |   '-'
    ;

    
rel_op
    :   '<'
    |   '>'
    |   '<='
    |   '>='
    ;
    
eq_op
    :   '=='
    |   '!='
    ;
    
cond_op
    :   '||'
    |   '&&' 
    ;


literal
    :   int_literal
    |   char_literal
    |   boolean_literal
    ;
    
int_literal
    :   NUM
    ;

char_literal
    :   Char 
    ;
    
boolean_literal
    :   'true'
    |   'false'
    ;