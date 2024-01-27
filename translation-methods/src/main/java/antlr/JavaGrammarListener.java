// Generated from /Users/snitron/IdeaProjects/tinkoff-edu/mettrans/src/main/java/antlr/JavaGrammar.g4 by ANTLR 4.13.1
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JavaGrammarParser}.
 */
public interface JavaGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#result}.
	 * @param ctx the parse tree
	 */
	void enterResult(JavaGrammarParser.ResultContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#result}.
	 * @param ctx the parse tree
	 */
	void exitResult(JavaGrammarParser.ResultContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#packageBlock}.
	 * @param ctx the parse tree
	 */
	void enterPackageBlock(JavaGrammarParser.PackageBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#packageBlock}.
	 * @param ctx the parse tree
	 */
	void exitPackageBlock(JavaGrammarParser.PackageBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#importBlock}.
	 * @param ctx the parse tree
	 */
	void enterImportBlock(JavaGrammarParser.ImportBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#importBlock}.
	 * @param ctx the parse tree
	 */
	void exitImportBlock(JavaGrammarParser.ImportBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void enterVariableDefinition(JavaGrammarParser.VariableDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void exitVariableDefinition(JavaGrammarParser.VariableDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#variableStatement}.
	 * @param ctx the parse tree
	 */
	void enterVariableStatement(JavaGrammarParser.VariableStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#variableStatement}.
	 * @param ctx the parse tree
	 */
	void exitVariableStatement(JavaGrammarParser.VariableStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#objectCall}.
	 * @param ctx the parse tree
	 */
	void enterObjectCall(JavaGrammarParser.ObjectCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#objectCall}.
	 * @param ctx the parse tree
	 */
	void exitObjectCall(JavaGrammarParser.ObjectCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(JavaGrammarParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(JavaGrammarParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(JavaGrammarParser.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(JavaGrammarParser.ArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#className}.
	 * @param ctx the parse tree
	 */
	void enterClassName(JavaGrammarParser.ClassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#className}.
	 * @param ctx the parse tree
	 */
	void exitClassName(JavaGrammarParser.ClassNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#classModifiers}.
	 * @param ctx the parse tree
	 */
	void enterClassModifiers(JavaGrammarParser.ClassModifiersContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#classModifiers}.
	 * @param ctx the parse tree
	 */
	void exitClassModifiers(JavaGrammarParser.ClassModifiersContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#notPublicModifiers}.
	 * @param ctx the parse tree
	 */
	void enterNotPublicModifiers(JavaGrammarParser.NotPublicModifiersContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#notPublicModifiers}.
	 * @param ctx the parse tree
	 */
	void exitNotPublicModifiers(JavaGrammarParser.NotPublicModifiersContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#class_static}.
	 * @param ctx the parse tree
	 */
	void enterClass_static(JavaGrammarParser.Class_staticContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#class_static}.
	 * @param ctx the parse tree
	 */
	void exitClass_static(JavaGrammarParser.Class_staticContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#inner_classDefinition}.
	 * @param ctx the parse tree
	 */
	void enterInner_classDefinition(JavaGrammarParser.Inner_classDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#inner_classDefinition}.
	 * @param ctx the parse tree
	 */
	void exitInner_classDefinition(JavaGrammarParser.Inner_classDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#defModifier}.
	 * @param ctx the parse tree
	 */
	void enterDefModifier(JavaGrammarParser.DefModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#defModifier}.
	 * @param ctx the parse tree
	 */
	void exitDefModifier(JavaGrammarParser.DefModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#class_var_def}.
	 * @param ctx the parse tree
	 */
	void enterClass_var_def(JavaGrammarParser.Class_var_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#class_var_def}.
	 * @param ctx the parse tree
	 */
	void exitClass_var_def(JavaGrammarParser.Class_var_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void enterClassDefinition(JavaGrammarParser.ClassDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void exitClassDefinition(JavaGrammarParser.ClassDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#constructorDefinition}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDefinition(JavaGrammarParser.ConstructorDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#constructorDefinition}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDefinition(JavaGrammarParser.ConstructorDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(JavaGrammarParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(JavaGrammarParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#returnExpression}.
	 * @param ctx the parse tree
	 */
	void enterReturnExpression(JavaGrammarParser.ReturnExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#returnExpression}.
	 * @param ctx the parse tree
	 */
	void exitReturnExpression(JavaGrammarParser.ReturnExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#funcBlock}.
	 * @param ctx the parse tree
	 */
	void enterFuncBlock(JavaGrammarParser.FuncBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#funcBlock}.
	 * @param ctx the parse tree
	 */
	void exitFuncBlock(JavaGrammarParser.FuncBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#static_var}.
	 * @param ctx the parse tree
	 */
	void enterStatic_var(JavaGrammarParser.Static_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#static_var}.
	 * @param ctx the parse tree
	 */
	void exitStatic_var(JavaGrammarParser.Static_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(JavaGrammarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(JavaGrammarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(JavaGrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(JavaGrammarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(JavaGrammarParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(JavaGrammarParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#notQuoteWord}.
	 * @param ctx the parse tree
	 */
	void enterNotQuoteWord(JavaGrammarParser.NotQuoteWordContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#notQuoteWord}.
	 * @param ctx the parse tree
	 */
	void exitNotQuoteWord(JavaGrammarParser.NotQuoteWordContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(JavaGrammarParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(JavaGrammarParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#varName}.
	 * @param ctx the parse tree
	 */
	void enterVarName(JavaGrammarParser.VarNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#varName}.
	 * @param ctx the parse tree
	 */
	void exitVarName(JavaGrammarParser.VarNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(JavaGrammarParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(JavaGrammarParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#funcType}.
	 * @param ctx the parse tree
	 */
	void enterFuncType(JavaGrammarParser.FuncTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#funcType}.
	 * @param ctx the parse tree
	 */
	void exitFuncType(JavaGrammarParser.FuncTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#funcName}.
	 * @param ctx the parse tree
	 */
	void enterFuncName(JavaGrammarParser.FuncNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#funcName}.
	 * @param ctx the parse tree
	 */
	void exitFuncName(JavaGrammarParser.FuncNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(JavaGrammarParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(JavaGrammarParser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#booleanExpr}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpr(JavaGrammarParser.BooleanExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#booleanExpr}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpr(JavaGrammarParser.BooleanExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void enterIfBlock(JavaGrammarParser.IfBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void exitIfBlock(JavaGrammarParser.IfBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void enterElseBlock(JavaGrammarParser.ElseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void exitElseBlock(JavaGrammarParser.ElseBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#ifDefinition}.
	 * @param ctx the parse tree
	 */
	void enterIfDefinition(JavaGrammarParser.IfDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#ifDefinition}.
	 * @param ctx the parse tree
	 */
	void exitIfDefinition(JavaGrammarParser.IfDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#exprOrStatement}.
	 * @param ctx the parse tree
	 */
	void enterExprOrStatement(JavaGrammarParser.ExprOrStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#exprOrStatement}.
	 * @param ctx the parse tree
	 */
	void exitExprOrStatement(JavaGrammarParser.ExprOrStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#forDefinition}.
	 * @param ctx the parse tree
	 */
	void enterForDefinition(JavaGrammarParser.ForDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#forDefinition}.
	 * @param ctx the parse tree
	 */
	void exitForDefinition(JavaGrammarParser.ForDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#whileDefinition}.
	 * @param ctx the parse tree
	 */
	void enterWhileDefinition(JavaGrammarParser.WhileDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#whileDefinition}.
	 * @param ctx the parse tree
	 */
	void exitWhileDefinition(JavaGrammarParser.WhileDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#genericDefenitionBlock}.
	 * @param ctx the parse tree
	 */
	void enterGenericDefenitionBlock(JavaGrammarParser.GenericDefenitionBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#genericDefenitionBlock}.
	 * @param ctx the parse tree
	 */
	void exitGenericDefenitionBlock(JavaGrammarParser.GenericDefenitionBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#genericUsageBlock}.
	 * @param ctx the parse tree
	 */
	void enterGenericUsageBlock(JavaGrammarParser.GenericUsageBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#genericUsageBlock}.
	 * @param ctx the parse tree
	 */
	void exitGenericUsageBlock(JavaGrammarParser.GenericUsageBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#genericConstructorBlock}.
	 * @param ctx the parse tree
	 */
	void enterGenericConstructorBlock(JavaGrammarParser.GenericConstructorBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#genericConstructorBlock}.
	 * @param ctx the parse tree
	 */
	void exitGenericConstructorBlock(JavaGrammarParser.GenericConstructorBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#genericWildcardTypeParameter}.
	 * @param ctx the parse tree
	 */
	void enterGenericWildcardTypeParameter(JavaGrammarParser.GenericWildcardTypeParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#genericWildcardTypeParameter}.
	 * @param ctx the parse tree
	 */
	void exitGenericWildcardTypeParameter(JavaGrammarParser.GenericWildcardTypeParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#typeParameterConstraint}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameterConstraint(JavaGrammarParser.TypeParameterConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#typeParameterConstraint}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameterConstraint(JavaGrammarParser.TypeParameterConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(JavaGrammarParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(JavaGrammarParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#booleanOperator}.
	 * @param ctx the parse tree
	 */
	void enterBooleanOperator(JavaGrammarParser.BooleanOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#booleanOperator}.
	 * @param ctx the parse tree
	 */
	void exitBooleanOperator(JavaGrammarParser.BooleanOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperator(JavaGrammarParser.UnaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperator(JavaGrammarParser.UnaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#incDec}.
	 * @param ctx the parse tree
	 */
	void enterIncDec(JavaGrammarParser.IncDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#incDec}.
	 * @param ctx the parse tree
	 */
	void exitIncDec(JavaGrammarParser.IncDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#boolean_composer}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_composer(JavaGrammarParser.Boolean_composerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#boolean_composer}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_composer(JavaGrammarParser.Boolean_composerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#dottedWords}.
	 * @param ctx the parse tree
	 */
	void enterDottedWords(JavaGrammarParser.DottedWordsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#dottedWords}.
	 * @param ctx the parse tree
	 */
	void exitDottedWords(JavaGrammarParser.DottedWordsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#throwsGroup}.
	 * @param ctx the parse tree
	 */
	void enterThrowsGroup(JavaGrammarParser.ThrowsGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#throwsGroup}.
	 * @param ctx the parse tree
	 */
	void exitThrowsGroup(JavaGrammarParser.ThrowsGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(JavaGrammarParser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(JavaGrammarParser.ModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#static}.
	 * @param ctx the parse tree
	 */
	void enterStatic(JavaGrammarParser.StaticContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#static}.
	 * @param ctx the parse tree
	 */
	void exitStatic(JavaGrammarParser.StaticContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#dottedWord}.
	 * @param ctx the parse tree
	 */
	void enterDottedWord(JavaGrammarParser.DottedWordContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#dottedWord}.
	 * @param ctx the parse tree
	 */
	void exitDottedWord(JavaGrammarParser.DottedWordContext ctx);
}