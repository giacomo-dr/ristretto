// ANTLR4 "Ristretto" grammar
// Author: Giacomo Del Rio
// Date: 10 Mar 2017

grammar Ristretto;

@header {
	package ch.usi.delrig.ristretto.antlrparser;
}

// --- Grammar

program : def+;

def : (type | 'void') IDE '(' params? ')' block
	;

params : param (',' param)* ;
param : type IDE ;

block : '{' stm* '}'
	  ;

stm : 'if' '(' exp ')' stm 'else' stm	# StmIfElse
    | 'if' '(' exp ')' stm				# StmIf
    | 'while' '(' exp ')' stm			# StmWhile
    | IDE '=' exp ';'            		# StmAssign
    | primary '[' exp ']' '=' exp ';'	# StmAssignArr
    | 'return' exp? ';'					# StmReturn
    | type IDE '=' exp ';'				# StmDeclare
    | call ';'							# StmCall
    | block								# StmBlock
    ;

type : type '[' ']'		# TypeArray
     | 'int'			# TypeInt
     | 'boolean'		# TypeBoolean
     ;

exp : primary								# ExpPrimary
    | op=('!'|'-') exp						# ExpUnary
    | exp op=('%' | '/' | '*') exp			# ExpModDivMul
    | exp op=('+' | '-') exp				# ExpPlusMinus
    | exp op=('>=' | '>' | '<=' | '<') exp	# ExpGtLt
    | exp op=('!=' | '==') exp				# ExpEqNeq
    | exp op=('&&' | '||') exp  			# ExpAndOr
    ;

primary : primary '[' exp ']'		# ExpArray
        | primary '.' 'length'		# ExpLength
        | '{' exps '}'				# ExpList
        | '(' exp ')'				# ExpParen
        | call						# ExpCall
        | IDE						# ExpIde
        | val=('true' | 'false')	# ExpLitBool
        | STRING					# ExpLitString
        | INT						# ExpLitInt
        ;

call : IDE '(' exps? ')'
     ;

exps : exp (',' exp )*
     ;

// --- Lexing

IDE : [_a-zA-Z] [_a-zA-Z0-9]*;
INT : DEC | HEX;
DEC : '0' | [1-9][0-9]*;
HEX : '0' [Xx] [0-9A-Fa-f]+;

WS : [ \t\r\n\f]+ -> skip ; // skip whitespaces
LCOMMENT : '//' .*? ('\r'? '\n' | EOF) -> skip ; // single line comment
MCOMMENT : '/*' .*? '*/' -> skip ; // multiline comment

// Adapted from "The definitive ANTLR 4 Reference"
STRING: '"' (ESC|.)*? '"' ;
fragment ESC : '\\n' | '\\t' | '\\"' | '\\\\' ; // \n, \t, \" and \\

// Operator names
NOT   : '!';
MINUS : '-';
MOD   : '%';
DIV   : '/';
MUL   : '*';
PLUS  : '+';
GE    : '>=';
GT    : '>';
LE    : '<=';
LT    : '<';
NEQ   : '!=';
EQ    : '==';
AND   : '&&';
OR    : '||';

