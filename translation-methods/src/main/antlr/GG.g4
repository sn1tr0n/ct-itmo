grammar GG;

@header {
import lab4.*
import lab4.State
import lab4.Invoke
}

g returns [states: MutableList<State> = mutableListOf()]: init (term[$states] | nonTerm[$states])+ EOF;
init: 'start' COLON NOT_CAPS_WORD SEMICOLON ('WS' COLON LITERAL SEMICOLON)?;

term[states: MutableList<State>]
    returns [t: Term = Term()]
    @init{$states.add($t)}:
        termName{$t.name = $ctx.getTermName().text} COLON LITERAL{$t.pattern = $ctx.LITERAL().text} SEMICOLON;
termName: EPS | CAPS_WORD;

nonTerm [states: MutableList<State>] returns [nt: NonTerm = NonTerm();] @init {$states.add($nt)}:
 inputWrapper[$nt] nonTermName{$nt.name = $ctx.getNonTermName().text}
 RETURNS outputWrapper[$nt] COLON (
    nonTermInnerWrapper[$nt] (OR nonTermInnerWrapper[$nt])*
) SEMICOLON;
nonTermName: NOT_CAPS_WORD;

inputWrapper[nt: NonTerm]: args{$nt.inputs = $ctx.getArgs().inputs};
outputWrapper[nt: NonTerm]: args{$nt.outputs = $ctx.getArgs().inputs};

ntTermName[group: MutableList<Invoke>]
    returns [invoke: TermInvoke = TermInvoke()]
    @init { $group.add($invoke) } :
     termName{$invoke.name = $ctx.getTermName().text}
     translationUpdateWrapper[$invoke];

ntNonTermName[group: MutableList<Invoke>]
    returns [invoke: NonTermInvoke = NonTermInvoke()]
    @init {$group.add($invoke)}:
        nonTermName{$invoke.name = $ctx.getNonTermName().NOT_CAPS_WORD().text}
        translationWrapper[$invoke]
        translationUpdateWrapper[$invoke];

nonTermInnerWrapper[nt: NonTerm]: nonTermInner{$nt.transitionByNames.add($ctx.getNonTermInner().group)};
nonTermInner returns [group: MutableList<Invoke> = mutableListOf()] : (ntTermName[$group] | ntNonTermName[$group])+;

translationWrapper[invoke: NonTermInvoke]: args{$invoke.inputs = $ctx.getArgs().inputs};
translationUpdateWrapper[invoke: Invoke]: UPDATE?{$invoke.update = $ctx.UPDATE()?.text};

args returns [inputs: MutableList<String> = mutableListOf()]: SOBRACKET (arg[$inputs] (COMMA arg[$inputs])*)? SCBRACKET;
arg [inputs: MutableList<String> = mutableListOf()] : ARG{$inputs.add($ctx.ARG().text)};

COMMA : ',';
RETURNS : 'returns';

SEMICOLON : ';';
COLON : ':';
SINGLE_QUOTE : '\'';
OR: '|';

SOBRACKET: '[';
SCBRACKET: ']';
COBRACKET: '{';
CCBRACKET: '}';
TOBRACKET: '<';
TCBRACKET: '>';
EPS: 'eps';

NOT_CAPS_WORD: [a-z_][a-zA-Z_0-9]*;
CAPS_WORD: [A-Z][A-Z_0-9]*;
ARG: '\'' (~[,\]])+ '\'';
LITERAL: '$' (~[$])+ '$';
UPDATE: '<' ('\'' (~['])+ '\'')? '>';

WS: [ \n\t\r] -> skip;




