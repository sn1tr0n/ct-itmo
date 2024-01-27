// Generated from /Users/snitron/IdeaProjects/tinkoff-edu/mettrans/src/main/antlr/GG.g4 by ANTLR 4.13.1
package lab4.antlr

import lab4.*
import lab4.State
import lab4.Invoke


import org.antlr.v4.kotlinruntime.tree.ParseTreeVisitor

/**
 * This interface defines a complete generic visitor for a parse tree produced by [GGParser].
 *
 * @param T The return type of the visit operation.
 *   Use [Unit] for operations with no return type
 */
public interface GGVisitor<T> : ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by [GGParser.g].
     *
     * @param ctx The parse tree
     * @return The visitor result
     */
    public fun visitG(ctx: GGParser.GContext): T
    /**
     * Visit a parse tree produced by [GGParser.init].
     *
     * @param ctx The parse tree
     * @return The visitor result
     */
    public fun visitInit(ctx: GGParser.InitContext): T
    /**
     * Visit a parse tree produced by [GGParser.term].
     *
     * @param ctx The parse tree
     * @return The visitor result
     */
    public fun visitTerm(ctx: GGParser.TermContext): T
    /**
     * Visit a parse tree produced by [GGParser.termName].
     *
     * @param ctx The parse tree
     * @return The visitor result
     */
    public fun visitTermName(ctx: GGParser.TermNameContext): T
    /**
     * Visit a parse tree produced by [GGParser.nonTerm].
     *
     * @param ctx The parse tree
     * @return The visitor result
     */
    public fun visitNonTerm(ctx: GGParser.NonTermContext): T
    /**
     * Visit a parse tree produced by [GGParser.nonTermName].
     *
     * @param ctx The parse tree
     * @return The visitor result
     */
    public fun visitNonTermName(ctx: GGParser.NonTermNameContext): T
    /**
     * Visit a parse tree produced by [GGParser.inputWrapper].
     *
     * @param ctx The parse tree
     * @return The visitor result
     */
    public fun visitInputWrapper(ctx: GGParser.InputWrapperContext): T
    /**
     * Visit a parse tree produced by [GGParser.outputWrapper].
     *
     * @param ctx The parse tree
     * @return The visitor result
     */
    public fun visitOutputWrapper(ctx: GGParser.OutputWrapperContext): T
    /**
     * Visit a parse tree produced by [GGParser.ntTermName].
     *
     * @param ctx The parse tree
     * @return The visitor result
     */
    public fun visitNtTermName(ctx: GGParser.NtTermNameContext): T
    /**
     * Visit a parse tree produced by [GGParser.ntNonTermName].
     *
     * @param ctx The parse tree
     * @return The visitor result
     */
    public fun visitNtNonTermName(ctx: GGParser.NtNonTermNameContext): T
    /**
     * Visit a parse tree produced by [GGParser.nonTermInnerWrapper].
     *
     * @param ctx The parse tree
     * @return The visitor result
     */
    public fun visitNonTermInnerWrapper(ctx: GGParser.NonTermInnerWrapperContext): T
    /**
     * Visit a parse tree produced by [GGParser.nonTermInner].
     *
     * @param ctx The parse tree
     * @return The visitor result
     */
    public fun visitNonTermInner(ctx: GGParser.NonTermInnerContext): T
    /**
     * Visit a parse tree produced by [GGParser.translationWrapper].
     *
     * @param ctx The parse tree
     * @return The visitor result
     */
    public fun visitTranslationWrapper(ctx: GGParser.TranslationWrapperContext): T
    /**
     * Visit a parse tree produced by [GGParser.translationUpdateWrapper].
     *
     * @param ctx The parse tree
     * @return The visitor result
     */
    public fun visitTranslationUpdateWrapper(ctx: GGParser.TranslationUpdateWrapperContext): T
    /**
     * Visit a parse tree produced by [GGParser.args].
     *
     * @param ctx The parse tree
     * @return The visitor result
     */
    public fun visitArgs(ctx: GGParser.ArgsContext): T
    /**
     * Visit a parse tree produced by [GGParser.arg].
     *
     * @param ctx The parse tree
     * @return The visitor result
     */
    public fun visitArg(ctx: GGParser.ArgContext): T
}