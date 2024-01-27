grammar JavaGrammar;

result: packageBlock? importBlock? classDefinition? EOF;
packageBlock: PACKAGE dottedWord SEMICOLON;
importBlock: (IMPORT dottedWord SEMICOLON)*;

variableDefinition: type genericUsageBlock? variableStatement ;
variableStatement: varName EQ expression ;

objectCall: dottedWord DOT funcCall;

arg: type genericUsageBlock? varName;
argList: arg (COMMA arg)*;

className: WORD;
classModifiers: ABSTRACT | FINAL;
notPublicModifiers: PROTECTED | PRIVATE;
class_static: static;

inner_classDefinition: notPublicModifiers? class_static? classModifiers? CLASS className genericDefenitionBlock?
    LCBRACKET
        (functionDefinition
        | constructorDefinition
        | (class_var_def SEMICOLON)
        | inner_classDefinition
        )*
    RCBRACKET;

defModifier: modifier;

class_var_def: modifier? static? variableDefinition;

classDefinition: defModifier? classModifiers? CLASS className genericDefenitionBlock?
    LCBRACKET
        (functionDefinition
        | constructorDefinition
        | (class_var_def SEMICOLON)
        | inner_classDefinition
        )*
    RCBRACKET;

constructorDefinition: modifier? className LBRACKET argList? RBRACKET throwsGroup?
    funcBlock;

functionDefinition: modifier? static? genericDefenitionBlock? funcType funcName LBRACKET argList? RBRACKET throwsGroup?
    funcBlock;

returnExpression: expression;

funcBlock:
    LCBRACKET
        ((variableDefinition SEMICOLON)
        | (objectCall SEMICOLON)
        | (expression SEMICOLON)
        | ifDefinition
        | forDefinition
        | whileDefinition
        )*
        (RETURN returnExpression? SEMICOLON)?
    RCBRACKET;

static_var: dottedWord;

expression:
    number
    | stringLiteral
    | dottedWord
    | varName
    | NEW type LSBRACKET expression RSBRACKET
    | NEW type genericConstructorBlock? LBRACKET expressionList? RBRACKET
    | expression operator expression
    | unaryOperator expression
    | expression incDec
    | funcCall
    | objectCall;
//types

type : dottedWord('[]')*;

number: INTEGER | FLOATING | DIG;
notQuoteWord: ~('"')*;
stringLiteral: QUOTE notQuoteWord QUOTE;
varName: WORD;

expressionList: expression (COMMA expression)*;

funcType: type | VOID;
funcName: WORD;
funcCall: funcName LBRACKET expressionList? RBRACKET;

booleanExpr:
    | expression
    | LBRACKET expression RBRACKET
    | expression booleanOperator expression
    | NOT booleanExpr
    | booleanExpr boolean_composer booleanExpr;

ifBlock: funcBlock;
elseBlock: funcBlock;
ifDefinition: IF LBRACKET booleanExpr RBRACKET ifBlock
(
    ELSE elseBlock
)?;

exprOrStatement: expression | variableStatement;

forDefinition: FOR LBRACKET
    (variableDefinition (COMMA variableDefinition)*) SEMICOLON
    booleanExpr SEMICOLON
    ((exprOrStatement) (COMMA exprOrStatement)*)
    RBRACKET
    (SEMICOLON | funcBlock);

whileDefinition: WHILE LBRACKET
    booleanExpr
    RBRACKET
    (SEMICOLON | funcBlock);

genericDefenitionBlock:
    LTBRACKET
        WORD (COMMA WORD)*
    RTBRACKET;

genericUsageBlock:
    LTBRACKET
        genericWildcardTypeParameter (COMMA genericWildcardTypeParameter)*
    RTBRACKET;

genericConstructorBlock:
    LTBRACKET
        (|genericWildcardTypeParameter (COMMA genericWildcardTypeParameter)*)
    RTBRACKET;

genericWildcardTypeParameter:
   (WORD genericUsageBlock?) | (QUESTION_MARK typeParameterConstraint genericWildcardTypeParameter);

typeParameterConstraint: EXTENDS | SUPER;


operator : PLUS | MINUS | MULTIPLY | DIVIDE | MOD | BIN_AND | BINOr | booleanOperator;
booleanOperator: EQUAL | NEQ | LTBRACKET | GREATEROr_EQ
                      | RTBRACKET | LESSOr_EQ;
unaryOperator: UN_NOT | incDec;
incDec: INC | DEC;

boolean_composer: AND | OR;

dottedWords: dottedWord (COMMA dottedWord)*;
throwsGroup: THROWS dottedWords;

modifier: PUBLIC | PRIVATE | PROTECTED;
static: STATIC;

//keywords

NEW : 'new';
FOR : 'for';
WHILE : 'while';
VOID : 'void';
IMPORT : 'import';
PACKAGE : 'package';
CLASS : 'class';

IF : 'if';
ELSE : 'else';

DIG : [0-9];
INTEGER : DIG+;
FLOATING: INTEGER DOT INTEGER;

PLUS : '+';
MINUS : '-';
MULTIPLY : '*';
DIVIDE : '/';
EQUAL : '==';
NEQ : '!=';
GREATEROr_EQ : '>=';
LESSOr_EQ : '<=';
MOD : '%';
INC : '++';
DEC : '--';
UN_NOT : '~';
BIN_AND : '&';
BINOr : '|';

AND : '&&';
OR : '||';
NOT : '!';

QUESTION_MARK: '?';


PUBLIC: 'public';
PRIVATE: 'private';
PROTECTED: 'protected';

ABSTRACT : 'abstract';
FINAL : 'final';

THROWS : 'throws';
RETURN : 'return';

STATIC: 'static';
EXTENDS: 'extends';
SUPER: 'super';

LBRACKET : '(';
RBRACKET : ')';
LSBRACKET : '[';
RSBRACKET : ']';
LCBRACKET : '{';
RCBRACKET : '}';
LTBRACKET : '<';
RTBRACKET : '>';

SEMICOLON : ';';
EQ: '=';
DOT: '.';
COMMA : ',';
QUOTE : '"';

WORD: [a-zA-Z_][a-zA-Z_0-9]*;
dottedWord: WORD (DOT WORD)*;

WS: [ \n\t\r] -> skip;