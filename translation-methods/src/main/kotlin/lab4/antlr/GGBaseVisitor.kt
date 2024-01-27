// Generated from /Users/snitron/IdeaProjects/tinkoff-edu/mettrans/src/main/antlr/GG.g4 by ANTLR 4.13.1
package lab4.antlr

import lab4.*
import lab4.State
import lab4.Invoke


import org.antlr.v4.kotlinruntime.tree.AbstractParseTreeVisitor

/**
 * This class provides an empty implementation of [GGVisitor],
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param T The return type of the visit operation.
 *   Use [Unit] for operations with no return type
 */
public open class GGBaseVisitor<T> : AbstractParseTreeVisitor<T>(), GGVisitor<T> {
    /**
     * The default implementation returns the result of calling [visitChildren] on [ctx].
     */
    override fun visitG(ctx: GGParser.GContext): T {
        return this.visitChildren(ctx)!!
    }
    /**
     * The default implementation returns the result of calling [visitChildren] on [ctx].
     */
    override fun visitInit(ctx: GGParser.InitContext): T {
        return this.visitChildren(ctx)!!
    }
    /**
     * The default implementation returns the result of calling [visitChildren] on [ctx].
     */
    override fun visitTerm(ctx: GGParser.TermContext): T {
        return this.visitChildren(ctx)!!
    }
    /**
     * The default implementation returns the result of calling [visitChildren] on [ctx].
     */
    override fun visitTermName(ctx: GGParser.TermNameContext): T {
        return this.visitChildren(ctx)!!
    }
    /**
     * The default implementation returns the result of calling [visitChildren] on [ctx].
     */
    override fun visitNonTerm(ctx: GGParser.NonTermContext): T {
        return this.visitChildren(ctx)!!
    }
    /**
     * The default implementation returns the result of calling [visitChildren] on [ctx].
     */
    override fun visitNonTermName(ctx: GGParser.NonTermNameContext): T {
        return this.visitChildren(ctx)!!
    }
    /**
     * The default implementation returns the result of calling [visitChildren] on [ctx].
     */
    override fun visitInputWrapper(ctx: GGParser.InputWrapperContext): T {
        return this.visitChildren(ctx)!!
    }
    /**
     * The default implementation returns the result of calling [visitChildren] on [ctx].
     */
    override fun visitOutputWrapper(ctx: GGParser.OutputWrapperContext): T {
        return this.visitChildren(ctx)!!
    }
    /**
     * The default implementation returns the result of calling [visitChildren] on [ctx].
     */
    override fun visitNtTermName(ctx: GGParser.NtTermNameContext): T {
        return this.visitChildren(ctx)!!
    }
    /**
     * The default implementation returns the result of calling [visitChildren] on [ctx].
     */
    override fun visitNtNonTermName(ctx: GGParser.NtNonTermNameContext): T {
        return this.visitChildren(ctx)!!
    }
    /**
     * The default implementation returns the result of calling [visitChildren] on [ctx].
     */
    override fun visitNonTermInnerWrapper(ctx: GGParser.NonTermInnerWrapperContext): T {
        return this.visitChildren(ctx)!!
    }
    /**
     * The default implementation returns the result of calling [visitChildren] on [ctx].
     */
    override fun visitNonTermInner(ctx: GGParser.NonTermInnerContext): T {
        return this.visitChildren(ctx)!!
    }
    /**
     * The default implementation returns the result of calling [visitChildren] on [ctx].
     */
    override fun visitTranslationWrapper(ctx: GGParser.TranslationWrapperContext): T {
        return this.visitChildren(ctx)!!
    }
    /**
     * The default implementation returns the result of calling [visitChildren] on [ctx].
     */
    override fun visitTranslationUpdateWrapper(ctx: GGParser.TranslationUpdateWrapperContext): T {
        return this.visitChildren(ctx)!!
    }
    /**
     * The default implementation returns the result of calling [visitChildren] on [ctx].
     */
    override fun visitArgs(ctx: GGParser.ArgsContext): T {
        return this.visitChildren(ctx)!!
    }
    /**
     * The default implementation returns the result of calling [visitChildren] on [ctx].
     */
    override fun visitArg(ctx: GGParser.ArgContext): T {
        return this.visitChildren(ctx)!!
    }
}