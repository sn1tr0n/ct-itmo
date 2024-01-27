// Generated from /Users/snitron/IdeaProjects/tinkoff-edu/mettrans/src/main/java/antlr/JavaGrammar.g4 by ANTLR 4.13.1
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JavaGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JavaGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#result}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResult(JavaGrammarParser.ResultContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#packageBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageBlock(JavaGrammarParser.PackageBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#importBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportBlock(JavaGrammarParser.ImportBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#variableDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDefinition(JavaGrammarParser.VariableDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#variableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableStatement(JavaGrammarParser.VariableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#objectCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectCall(JavaGrammarParser.ObjectCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg(JavaGrammarParser.ArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList(JavaGrammarParser.ArgListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#className}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassName(JavaGrammarParser.ClassNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#classModifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassModifiers(JavaGrammarParser.ClassModifiersContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#notPublicModifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotPublicModifiers(JavaGrammarParser.NotPublicModifiersContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#class_static}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_static(JavaGrammarParser.Class_staticContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#inner_classDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInner_classDefinition(JavaGrammarParser.Inner_classDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#defModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefModifier(JavaGrammarParser.DefModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#class_var_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_var_def(JavaGrammarParser.Class_var_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#classDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDefinition(JavaGrammarParser.ClassDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#constructorDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDefinition(JavaGrammarParser.ConstructorDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(JavaGrammarParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#returnExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnExpression(JavaGrammarParser.ReturnExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#funcBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncBlock(JavaGrammarParser.FuncBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#static_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatic_var(JavaGrammarParser.Static_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(JavaGrammarParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(JavaGrammarParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(JavaGrammarParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#notQuoteWord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotQuoteWord(JavaGrammarParser.NotQuoteWordContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(JavaGrammarParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#varName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarName(JavaGrammarParser.VarNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(JavaGrammarParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#funcType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncType(JavaGrammarParser.FuncTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#funcName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncName(JavaGrammarParser.FuncNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#funcCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(JavaGrammarParser.FuncCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#booleanExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpr(JavaGrammarParser.BooleanExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#ifBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfBlock(JavaGrammarParser.IfBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#elseBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseBlock(JavaGrammarParser.ElseBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#ifDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfDefinition(JavaGrammarParser.IfDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#exprOrStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOrStatement(JavaGrammarParser.ExprOrStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#forDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForDefinition(JavaGrammarParser.ForDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#whileDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileDefinition(JavaGrammarParser.WhileDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#genericDefenitionBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericDefenitionBlock(JavaGrammarParser.GenericDefenitionBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#genericUsageBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericUsageBlock(JavaGrammarParser.GenericUsageBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#genericConstructorBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericConstructorBlock(JavaGrammarParser.GenericConstructorBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#genericWildcardTypeParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericWildcardTypeParameter(JavaGrammarParser.GenericWildcardTypeParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#typeParameterConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameterConstraint(JavaGrammarParser.TypeParameterConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(JavaGrammarParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#booleanOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanOperator(JavaGrammarParser.BooleanOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#unaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperator(JavaGrammarParser.UnaryOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#incDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncDec(JavaGrammarParser.IncDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#boolean_composer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_composer(JavaGrammarParser.Boolean_composerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#dottedWords}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDottedWords(JavaGrammarParser.DottedWordsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#throwsGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowsGroup(JavaGrammarParser.ThrowsGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#modifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifier(JavaGrammarParser.ModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#static}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatic(JavaGrammarParser.StaticContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#dottedWord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDottedWord(JavaGrammarParser.DottedWordContext ctx);
}