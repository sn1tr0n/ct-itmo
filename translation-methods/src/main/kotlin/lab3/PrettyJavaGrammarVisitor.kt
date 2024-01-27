package lab3

import antlr.JavaGrammarParser
import antlr.JavaGrammarParser.*
import antlr.JavaGrammarVisitor
import org.antlr.v4.runtime.tree.ErrorNode
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.tree.RuleNode
import org.antlr.v4.runtime.tree.TerminalNode
import java.io.OutputStream
import java.io.Writer

class PrettyJavaGrammarVisitor(
    outputStream: OutputStream
) : JavaGrammarVisitor<Unit> {
    private val bufferedWriter = outputStream.bufferedWriter()
    private var indentLevel = 0

    private fun appendIndentation(): Writer = bufferedWriter.append(" ".repeat(4 * indentLevel))

    override fun visit(tree: ParseTree) {
    }

    override fun visitChildren(node: RuleNode?) {
    }

    override fun visitTerminal(node: TerminalNode?) {
    }

    override fun visitErrorNode(node: ErrorNode?) {
    }

    override fun visitResult(ctx: JavaGrammarParser.ResultContext) {
        if (ctx.packageBlock() != null) {
            visitPackageBlock(ctx.packageBlock())
            bufferedWriter.newLine()
        }

        if (ctx.importBlock() != null) {
            visitImportBlock(ctx.importBlock())
            bufferedWriter.newLine()
        }

        visitClassDefinition(ctx.classDefinition())

        bufferedWriter.flush()
        bufferedWriter.close()
    }

    override fun visitPackageBlock(ctx: JavaGrammarParser.PackageBlockContext) {
        bufferedWriter.appendLine("package ${ctx.dottedWord().text};")
    }

    override fun visitImportBlock(ctx: JavaGrammarParser.ImportBlockContext) {
        ctx.dottedWord()
            .map { context -> context.text }
            .forEach { importString ->
                bufferedWriter.appendLine("import $importString;")
            }
    }

    override fun visitVariableDefinition(ctx: JavaGrammarParser.VariableDefinitionContext?) {
        TODO("Not yet implemented")
    }

    fun appendVariable(
        modifier: String?,
        static: String?,
        ctx: JavaGrammarParser.VariableDefinitionContext,
        semicolon: Boolean
    ) {

        if (modifier != null) {
            bufferedWriter.append(modifier).append(' ')
        }

        if (static != null) {
            bufferedWriter.append(static).append(' ')
        }

        bufferedWriter
            .append(ctx.type().text)

        if (ctx.genericUsageBlock() != null) {
            appendGenericUsageBlock(ctx.genericUsageBlock())
        }
        bufferedWriter.append(" ")

        appendVariableStatement(ctx.variableStatement(), semicolon)
    }

    fun appendVariableStatement(ctx: VariableStatementContext, semicolon: Boolean = false) {
        bufferedWriter
            .append(ctx.varName().WORD().text)
            .append(" = ")

        appendExpression(ctx.expression())

        if (semicolon) {
            bufferedWriter.append(';')
        }
    }

    override fun visitVariableStatement(ctx: JavaGrammarParser.VariableStatementContext) {
        bufferedWriter.append(" = ")
        appendExpression(ctx.expression())
        bufferedWriter.appendLine(';')
    }

    private fun appendExpression(ctx: JavaGrammarParser.ExpressionContext) {
        when {
            ctx.number() != null -> {
                bufferedWriter.append(ctx.number().children.joinToString())
            }

            ctx.stringLiteral() != null -> {
                bufferedWriter
                    .append('"')
                    .append(ctx.stringLiteral().notQuoteWord().text)
                    .append('"')
            }

            ctx.dottedWord() != null -> {
                bufferedWriter.append(ctx.text)
            }

            ctx.varName() != null -> {
                bufferedWriter.append(ctx.varName().WORD().text)
            }

            ctx.NEW() != null -> {
                bufferedWriter
                    .append("new ")
                    .append(ctx.type().text)

                if (ctx.LBRACKET() != null) {
                    if (ctx.genericConstructorBlock() != null) {
                        appendGenericConstructorBlock(ctx.genericConstructorBlock())
                    }

                    bufferedWriter
                        .append("(")

                    if (ctx.expressionList() != null) {
                        ctx.expressionList().expression().forEachIndexed { index, it ->
                            appendExpression(it)

                            if (index != ctx.expressionList().expression().size - 1) {
                                bufferedWriter.append(", ")
                            }
                        }
                    }

                    bufferedWriter.append(")")
                } else if (ctx.LSBRACKET() != null) {
                    bufferedWriter
                        .append("[");

                    ctx.expression().map { appendExpression(it) }
                    bufferedWriter.append("]")
                } else {
                    throw AssertionError("expression")
                }
            }

            ctx.unaryOperator() != null -> {
                bufferedWriter
                    .append(ctx.unaryOperator().text)

                appendExpression(ctx.expression()[0])
            }

            ctx.incDec() != null -> {
                appendExpression(ctx.expression()[0])

                bufferedWriter
                    .append(ctx.incDec().text)
            }

            ctx.expression().isNotEmpty() -> {
                appendExpression(ctx.expression()[0])

                bufferedWriter
                    .append(' ')
                    .append(ctx.operator().text)
                    .append(' ')

                appendExpression(ctx.expression()[1])
            }

            ctx.funcCall() != null -> appendFuncCall(ctx.funcCall())
            ctx.objectCall() != null -> appendObjectCall(ctx.objectCall())

            else -> throw AssertionError("no expr parsed")
        }
    }

    fun appendFuncCall(ctx: FuncCallContext) {
        bufferedWriter
            .append(ctx.funcName().WORD().text)
            .append('(')

        if (ctx.expressionList() != null) {
            val expressions = ctx.expressionList().expression()
            expressions.forEachIndexed { index, expr ->
                appendExpression(expr)
                if (index != expressions.size - 1) {
                    bufferedWriter.append(", ")
                }
            }
        }
        bufferedWriter.append(")")
    }

    fun appendObjectCall(ctx: JavaGrammarParser.ObjectCallContext) {
        bufferedWriter
            .append(ctx.dottedWord().text)
            .append('.')
        appendFuncCall(ctx.funcCall())
    }

    fun appendArg(ctx: ArgContext) {
        bufferedWriter
            .append(ctx.type().text)

        if (ctx.genericUsageBlock() != null) {
            appendGenericUsageBlock(ctx.genericUsageBlock())
        }

        bufferedWriter.append(' ')

        bufferedWriter
            .append(ctx.varName().text)
    }

    fun appendGenericUsageBlock(ctx: GenericUsageBlockContext) {
        bufferedWriter.append('<')

        ctx.genericWildcardTypeParameter()
            .forEachIndexed { index, genericWildcartTypeParameterContext ->
                appendGenericWildcardParameter(genericWildcartTypeParameterContext)

                if (index != ctx.genericWildcardTypeParameter().size - 1) {
                    bufferedWriter.append(", ")
                }
            }
        bufferedWriter.append(">")
    }

    fun appendGenericConstructorBlock(ctx: GenericConstructorBlockContext) {
        bufferedWriter.append('<')

        ctx.genericWildcardTypeParameter()
            .forEachIndexed { index, genericWildcartTypeParameterContext ->
                appendGenericWildcardParameter(genericWildcartTypeParameterContext)

                if (index != ctx.genericWildcardTypeParameter().size - 1) {
                    bufferedWriter.append(", ")
                }
            }
        bufferedWriter.append(">")
    }

    fun appendGenericDefinitionBlock(ctx: GenericDefenitionBlockContext) {
        bufferedWriter.append('<')

        ctx.WORD()
            .forEachIndexed { index, typeParameterContext ->
                bufferedWriter.append(typeParameterContext.text)

                if (index != ctx.WORD().size - 1) {
                    bufferedWriter.append(", ")
                }
            }
        bufferedWriter.append("> ")
    }

    fun appendGenericWildcardParameter(ctx: GenericWildcardTypeParameterContext) {
        if (ctx.WORD() != null) {
            bufferedWriter
                .append(ctx.WORD().text)

            if (ctx.genericUsageBlock() != null) {
                appendGenericUsageBlock(ctx.genericUsageBlock())
            }
        } else {
            bufferedWriter.append("? ")
                .append(ctx.typeParameterConstraint().text)
                .append(' ')

            appendGenericWildcardParameter(ctx.genericWildcardTypeParameter())
        }
    }

    fun appendArgList(ctx: ArgListContext) {
        ctx.arg().mapIndexed { index, argContext ->
            appendArg(argContext)

            if (index != ctx.arg().size - 1) {
                bufferedWriter.append(", ")
            }
        }
    }

    fun addInnerClassDefenition(ctx: JavaGrammarParser.Inner_classDefinitionContext) {
        appendIndentation()

        if (ctx.notPublicModifiers() != null) {
            bufferedWriter.append(ctx.notPublicModifiers().text).append(' ')
        }

        if (ctx.class_static() != null) {
            bufferedWriter.append(ctx.class_static().text).append(' ')
        }

        if (ctx.classModifiers() != null) {
            bufferedWriter.append(ctx.classModifiers().text).append(' ')
        }

        bufferedWriter
            .append("class ")
            .append(ctx.className().WORD().text)

        if (ctx.genericDefenitionBlock() != null) {
            appendGenericDefinitionBlock(ctx.genericDefenitionBlock())
        } else {
            bufferedWriter.append(' ')
        }

        bufferedWriter.appendLine("{")

        indentLevel++

        ctx.class_var_def().map {
            appendIndentation()
            appendVariable(
                it.modifier()?.text,
                it.static_()?.text,
                it.variableDefinition(),
                true
            )
            bufferedWriter.newLine()
        }

        if (ctx.class_var_def().isNotEmpty()) {
            bufferedWriter.newLine()
        }

        ctx.inner_classDefinition().forEach {
            addInnerClassDefenition(it)
        }

        ctx.constructorDefinition().forEach {
            addConstructor(it)
            bufferedWriter.newLine()
        }

        ctx.functionDefinition().forEach {
            addFunctionDefenition(it)
        }

        indentLevel--
        appendIndentation().appendLine('}')
        bufferedWriter.newLine()
    }

    private fun addFunctionDefenition(ctx: JavaGrammarParser.FunctionDefinitionContext) {
        appendIndentation()
        if (ctx.modifier() != null) {
            bufferedWriter.append(ctx.modifier().text).append(' ')
        }
        if (ctx.static_() != null) {
            bufferedWriter.append("static ")
        }

        if (ctx.genericDefenitionBlock() != null) {
            appendGenericDefinitionBlock(ctx.genericDefenitionBlock())
        }

        bufferedWriter
            .append(ctx.funcType().text)
            .append(' ')
            .append(ctx.funcName().text)
            .append('(')

        if (ctx.argList() != null && ctx.argList().arg().isNotEmpty()) {
            appendArgList(ctx.argList())
        }

        bufferedWriter
            .append(") ")

        appendFuncBlock(ctx.funcBlock())
        bufferedWriter.newLine()
        bufferedWriter.newLine()
    }

    fun appendThrowsGroup(ctx: ThrowsGroupContext) {
        bufferedWriter.append("throws ")
        ctx.dottedWords().dottedWord().forEachIndexed { index, dottedWordcontext ->
            bufferedWriter.append(dottedWordcontext.text)

            if (index != ctx.dottedWords().dottedWord().size - 1) {
                bufferedWriter.append(", ")
            }
        }
    }

    fun addConstructor(ctx: JavaGrammarParser.ConstructorDefinitionContext) {
        appendIndentation()

        if (ctx.modifier() != null) {
            bufferedWriter.append(ctx.modifier().text).append(' ')
        }

        bufferedWriter
            .append(ctx.className().WORD().text)
            .append('(')
        if (ctx.argList() != null) {
            appendArgList(ctx.argList())
        }
        bufferedWriter.append(") ")

        if (ctx.throwsGroup() != null) {
            appendThrowsGroup(ctx.throwsGroup())
        }

        appendFuncBlock(ctx.funcBlock())
        bufferedWriter.appendLine()
    }

    fun appendIfStatement(ctx: IfDefinitionContext) {
        bufferedWriter.append("if (")

        appendBooleanExpression(ctx.booleanExpr())

        bufferedWriter.append(") ")
        appendFuncBlock(ctx.ifBlock().funcBlock())

        if (ctx.elseBlock() == null) {
            bufferedWriter.newLine()
        } else {
            bufferedWriter.append(" else ")
            appendFuncBlock(ctx.elseBlock().funcBlock())
            bufferedWriter.newLine()
        }
    }

    fun appendBooleanExpression(ctx: BooleanExprContext) {
        when {
            ctx.LBRACKET() != null -> {
                bufferedWriter.append('(')
                appendExpression(ctx.expression()[0])
                bufferedWriter.append(')')
            }

            ctx.expression().isNotEmpty() -> {
                appendExpression(ctx.expression()[0])

                if (ctx.expression().size == 2) {
                    bufferedWriter
                        .append(' ')
                        .append(ctx.booleanOperator().text)
                        .append(' ')

                    appendExpression(ctx.expression()[1])

                }
            }

            ctx.NOT() != null -> {
                bufferedWriter.append('!')
                appendBooleanExpression(ctx.booleanExpr()[0])
            }

            ctx.booleanExpr().isNotEmpty() -> {
                appendBooleanExpression(ctx.booleanExpr()[0])

                bufferedWriter
                    .append(' ')
                    .append(ctx.boolean_composer().text)
                    .append(' ')

                appendBooleanExpression(ctx.booleanExpr()[1])
            }
        }
    }

    fun appendFuncBlock(ctx: FuncBlockContext) {
        bufferedWriter.appendLine("{")
        indentLevel++

        ctx.children.forEach {
            when (it) {
                is VariableDefinitionContext -> {
                    appendIndentation()
                    appendVariable(null, null, it, true)
                    bufferedWriter.newLine()
                }

                is ObjectCallContext -> {
                    appendIndentation()
                    appendObjectCall(it)
                    bufferedWriter.appendLine(';')
                }

                is ExpressionContext -> {
                    appendIndentation()
                    appendExpression(it)
                    bufferedWriter.appendLine(';')
                }

                is IfDefinitionContext -> {
                    appendIndentation()
                    appendIfStatement(it)
                    bufferedWriter.newLine()
                }

                is ForDefinitionContext -> {
                    appendIndentation()
                    addForStatement(it)
                    bufferedWriter.newLine()
                }

                is WhileDefinitionContext -> {
                    appendIndentation()
                    addWhileStatement(it)
                    bufferedWriter.newLine()
                }
            }
        }

        if (ctx.RETURN() != null) {
            appendIndentation()
            bufferedWriter.append("return")

            if (ctx.returnExpression() != null) {
                bufferedWriter.append(' ')
                appendExpression(ctx.returnExpression().expression())
            }
            bufferedWriter.appendLine(';')
        }

        indentLevel--
        appendIndentation().append('}')
    }

    fun addForStatement(ctx: ForDefinitionContext) {
        bufferedWriter.append("for (")
        ctx.variableDefinition().forEachIndexed { index, variableDefenitioncontext ->
            appendVariable(null, null, variableDefenitioncontext, false)

            if (index != ctx.variableDefinition().size - 1) {
                bufferedWriter.append(", ")
            }
        }
        bufferedWriter.append(";")

        if (ctx.booleanExpr() != null) {
            bufferedWriter.append(' ')
            appendBooleanExpression(ctx.booleanExpr())
        }

        bufferedWriter.append(';')

        if (ctx.exprOrStatement().isNotEmpty()) {
            bufferedWriter.append(' ')
        }

        ctx.exprOrStatement().forEachIndexed { index, it ->
            if (it.expression() != null) {
                appendExpression(it.expression())
            } else {
                appendVariableStatement(it.variableStatement())
            }

            if (index != ctx.variableDefinition().size - 1) {
                bufferedWriter.append(", ")
            }
        }

        bufferedWriter.append(')')

        if (ctx.funcBlock() == null) {
            bufferedWriter.appendLine(';')
        } else {
            bufferedWriter.append(' ')
            appendFuncBlock(ctx.funcBlock())
            bufferedWriter.newLine()
        }
    }

    fun addWhileStatement(ctx: WhileDefinitionContext) {
        bufferedWriter.append("while (")
        appendBooleanExpression(ctx.booleanExpr())
        bufferedWriter.append(")")

        if (ctx.funcBlock() == null) {
            bufferedWriter.appendLine(';')
        } else {
            bufferedWriter.append(' ')
            appendFuncBlock(ctx.funcBlock())
            bufferedWriter.newLine()
        }
    }

    override fun visitObjectCall(ctx: JavaGrammarParser.ObjectCallContext?) {
        TODO("Not yet implemented")
    }

    override fun visitArg(ctx: ArgContext?) {
        TODO("Not yet implemented")
    }

    override fun visitArgList(ctx: ArgListContext?) {
        TODO("Not yet implemented")
    }

    override fun visitClassName(ctx: JavaGrammarParser.ClassNameContext) {
    }

    override fun visitClassModifiers(ctx: JavaGrammarParser.ClassModifiersContext) {
    }

    override fun visitNotPublicModifiers(ctx: JavaGrammarParser.NotPublicModifiersContext) {
    }

    override fun visitClass_static(ctx: JavaGrammarParser.Class_staticContext?) {
    }

    override fun visitInner_classDefinition(ctx: JavaGrammarParser.Inner_classDefinitionContext?) {

    }

    override fun visitDefModifier(ctx: JavaGrammarParser.DefModifierContext?) {
    }

    override fun visitClass_var_def(ctx: JavaGrammarParser.Class_var_defContext?) {
    }

    override fun visitClassDefinition(ctx: JavaGrammarParser.ClassDefinitionContext) {
        if (ctx.defModifier() != null) {
            bufferedWriter.append(ctx.defModifier().text).append(' ')
        }

        if (ctx.classModifiers() != null) {
            bufferedWriter.append(ctx.classModifiers().text).append(' ')
        }

        bufferedWriter
            .append("class ")
            .append(ctx.className().WORD().text)

        if (ctx.genericDefenitionBlock() != null) {
            appendGenericDefinitionBlock(ctx.genericDefenitionBlock())
        } else {
            bufferedWriter.append(' ')
        }

        bufferedWriter.appendLine("{")
        indentLevel++

        ctx.class_var_def().map {
            appendIndentation()
            appendVariable(
                it.modifier()?.text,
                it.static_()?.text,
                it.variableDefinition(),
                true
            )
            bufferedWriter.newLine()
        }

        if (ctx.class_var_def().isNotEmpty()) {
            bufferedWriter.newLine()
        }

        ctx.inner_classDefinition().forEach {
            addInnerClassDefenition(it)
        }

        ctx.constructorDefinition().forEach {
            addConstructor(it)
            bufferedWriter.newLine()
        }

        ctx.functionDefinition().forEach {
            addFunctionDefenition(it)
        }

        bufferedWriter.appendLine('}')
    }

    override fun visitConstructorDefinition(ctx: JavaGrammarParser.ConstructorDefinitionContext?) {
    }

    override fun visitFunctionDefinition(ctx: JavaGrammarParser.FunctionDefinitionContext) {
    }

    override fun visitReturnExpression(ctx: JavaGrammarParser.ReturnExpressionContext?) {
    }

    override fun visitFuncBlock(ctx: FuncBlockContext?) {
    }

    override fun visitStatic_var(ctx: JavaGrammarParser.Static_varContext?) {
    }

    override fun visitExpression(ctx: JavaGrammarParser.ExpressionContext?) {
    }

    override fun visitType(ctx: JavaGrammarParser.TypeContext?) {
    }

    override fun visitNumber(ctx: JavaGrammarParser.NumberContext?) {
    }

    override fun visitNotQuoteWord(ctx: JavaGrammarParser.NotQuoteWordContext?) {
    }

    override fun visitStringLiteral(ctx: JavaGrammarParser.StringLiteralContext?) {
    }

    override fun visitVarName(ctx: JavaGrammarParser.VarNameContext?) {
    }

    override fun visitExpressionList(ctx: JavaGrammarParser.ExpressionListContext?) {
    }

    override fun visitFuncType(ctx: JavaGrammarParser.FuncTypeContext?) {
    }

    override fun visitFuncName(ctx: JavaGrammarParser.FuncNameContext?) {
    }

    override fun visitFuncCall(ctx: FuncCallContext?) {
    }

    override fun visitBooleanExpr(ctx: JavaGrammarParser.BooleanExprContext?) {
    }

    override fun visitIfBlock(ctx: JavaGrammarParser.IfBlockContext?) {
    }

    override fun visitElseBlock(ctx: JavaGrammarParser.ElseBlockContext?) {
    }

    override fun visitIfDefinition(ctx: JavaGrammarParser.IfDefinitionContext?) {
    }

    override fun visitExprOrStatement(ctx: JavaGrammarParser.ExprOrStatementContext?) {
    }

    override fun visitForDefinition(ctx: JavaGrammarParser.ForDefinitionContext?) {
    }

    override fun visitWhileDefinition(ctx: JavaGrammarParser.WhileDefinitionContext?) {
    }

    override fun visitGenericDefenitionBlock(ctx: GenericDefenitionBlockContext?) {
        TODO("Not yet implemented")
    }

    override fun visitGenericUsageBlock(ctx: GenericUsageBlockContext?) {
        TODO("Not yet implemented")
    }

    override fun visitGenericConstructorBlock(ctx: GenericConstructorBlockContext?) {
        TODO("Not yet implemented")
    }

    override fun visitGenericWildcardTypeParameter(ctx: GenericWildcardTypeParameterContext?) {
        TODO("Not yet implemented")
    }


    /*override fun visitInnerGenericType(ctx: InnerGenericTypeContext?) {
        TODO("Not yet implemented")
    }*/

    override fun visitTypeParameterConstraint(ctx: TypeParameterConstraintContext?) {
        TODO("Not yet implemented")
    }

    override fun visitOperator(ctx: JavaGrammarParser.OperatorContext?) {
    }

    override fun visitBooleanOperator(ctx: JavaGrammarParser.BooleanOperatorContext?) {
    }

    override fun visitUnaryOperator(ctx: JavaGrammarParser.UnaryOperatorContext?) {
    }

    override fun visitIncDec(ctx: JavaGrammarParser.IncDecContext?) {
    }

    override fun visitBoolean_composer(ctx: JavaGrammarParser.Boolean_composerContext?) {
    }

    override fun visitDottedWords(ctx: JavaGrammarParser.DottedWordsContext?) {
    }

    override fun visitThrowsGroup(ctx: ThrowsGroupContext?) {
    }

    override fun visitModifier(ctx: JavaGrammarParser.ModifierContext?) {
    }

    override fun visitStatic(ctx: JavaGrammarParser.StaticContext?) {
    }

    override fun visitDottedWord(ctx: JavaGrammarParser.DottedWordContext?) {
    }
}
