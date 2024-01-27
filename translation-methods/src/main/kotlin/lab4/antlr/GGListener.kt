// Generated from /Users/snitron/IdeaProjects/tinkoff-edu/mettrans/src/main/antlr/GG.g4 by ANTLR 4.13.1
package lab4.antlr

import lab4.*
import lab4.State
import lab4.Invoke


import org.antlr.v4.kotlinruntime.tree.ParseTreeListener

/**
 * This interface defines a complete listener for a parse tree produced by [GGParser].
 */
public interface GGListener : ParseTreeListener {
    /**
     * Enter a parse tree produced by [GGParser.g].
     *
     * @param ctx The parse tree
     */
    public fun enterG(ctx: GGParser.GContext)

    /**
     * Exit a parse tree produced by [GGParser.g].
     *
     * @param ctx The parse tree
     */
    public fun exitG(ctx: GGParser.GContext)
    /**
     * Enter a parse tree produced by [GGParser.init].
     *
     * @param ctx The parse tree
     */
    public fun enterInit(ctx: GGParser.InitContext)

    /**
     * Exit a parse tree produced by [GGParser.init].
     *
     * @param ctx The parse tree
     */
    public fun exitInit(ctx: GGParser.InitContext)
    /**
     * Enter a parse tree produced by [GGParser.term].
     *
     * @param ctx The parse tree
     */
    public fun enterTerm(ctx: GGParser.TermContext)

    /**
     * Exit a parse tree produced by [GGParser.term].
     *
     * @param ctx The parse tree
     */
    public fun exitTerm(ctx: GGParser.TermContext)
    /**
     * Enter a parse tree produced by [GGParser.termName].
     *
     * @param ctx The parse tree
     */
    public fun enterTermName(ctx: GGParser.TermNameContext)

    /**
     * Exit a parse tree produced by [GGParser.termName].
     *
     * @param ctx The parse tree
     */
    public fun exitTermName(ctx: GGParser.TermNameContext)
    /**
     * Enter a parse tree produced by [GGParser.nonTerm].
     *
     * @param ctx The parse tree
     */
    public fun enterNonTerm(ctx: GGParser.NonTermContext)

    /**
     * Exit a parse tree produced by [GGParser.nonTerm].
     *
     * @param ctx The parse tree
     */
    public fun exitNonTerm(ctx: GGParser.NonTermContext)
    /**
     * Enter a parse tree produced by [GGParser.nonTermName].
     *
     * @param ctx The parse tree
     */
    public fun enterNonTermName(ctx: GGParser.NonTermNameContext)

    /**
     * Exit a parse tree produced by [GGParser.nonTermName].
     *
     * @param ctx The parse tree
     */
    public fun exitNonTermName(ctx: GGParser.NonTermNameContext)
    /**
     * Enter a parse tree produced by [GGParser.inputWrapper].
     *
     * @param ctx The parse tree
     */
    public fun enterInputWrapper(ctx: GGParser.InputWrapperContext)

    /**
     * Exit a parse tree produced by [GGParser.inputWrapper].
     *
     * @param ctx The parse tree
     */
    public fun exitInputWrapper(ctx: GGParser.InputWrapperContext)
    /**
     * Enter a parse tree produced by [GGParser.outputWrapper].
     *
     * @param ctx The parse tree
     */
    public fun enterOutputWrapper(ctx: GGParser.OutputWrapperContext)

    /**
     * Exit a parse tree produced by [GGParser.outputWrapper].
     *
     * @param ctx The parse tree
     */
    public fun exitOutputWrapper(ctx: GGParser.OutputWrapperContext)
    /**
     * Enter a parse tree produced by [GGParser.ntTermName].
     *
     * @param ctx The parse tree
     */
    public fun enterNtTermName(ctx: GGParser.NtTermNameContext)

    /**
     * Exit a parse tree produced by [GGParser.ntTermName].
     *
     * @param ctx The parse tree
     */
    public fun exitNtTermName(ctx: GGParser.NtTermNameContext)
    /**
     * Enter a parse tree produced by [GGParser.ntNonTermName].
     *
     * @param ctx The parse tree
     */
    public fun enterNtNonTermName(ctx: GGParser.NtNonTermNameContext)

    /**
     * Exit a parse tree produced by [GGParser.ntNonTermName].
     *
     * @param ctx The parse tree
     */
    public fun exitNtNonTermName(ctx: GGParser.NtNonTermNameContext)
    /**
     * Enter a parse tree produced by [GGParser.nonTermInnerWrapper].
     *
     * @param ctx The parse tree
     */
    public fun enterNonTermInnerWrapper(ctx: GGParser.NonTermInnerWrapperContext)

    /**
     * Exit a parse tree produced by [GGParser.nonTermInnerWrapper].
     *
     * @param ctx The parse tree
     */
    public fun exitNonTermInnerWrapper(ctx: GGParser.NonTermInnerWrapperContext)
    /**
     * Enter a parse tree produced by [GGParser.nonTermInner].
     *
     * @param ctx The parse tree
     */
    public fun enterNonTermInner(ctx: GGParser.NonTermInnerContext)

    /**
     * Exit a parse tree produced by [GGParser.nonTermInner].
     *
     * @param ctx The parse tree
     */
    public fun exitNonTermInner(ctx: GGParser.NonTermInnerContext)
    /**
     * Enter a parse tree produced by [GGParser.translationWrapper].
     *
     * @param ctx The parse tree
     */
    public fun enterTranslationWrapper(ctx: GGParser.TranslationWrapperContext)

    /**
     * Exit a parse tree produced by [GGParser.translationWrapper].
     *
     * @param ctx The parse tree
     */
    public fun exitTranslationWrapper(ctx: GGParser.TranslationWrapperContext)
    /**
     * Enter a parse tree produced by [GGParser.translationUpdateWrapper].
     *
     * @param ctx The parse tree
     */
    public fun enterTranslationUpdateWrapper(ctx: GGParser.TranslationUpdateWrapperContext)

    /**
     * Exit a parse tree produced by [GGParser.translationUpdateWrapper].
     *
     * @param ctx The parse tree
     */
    public fun exitTranslationUpdateWrapper(ctx: GGParser.TranslationUpdateWrapperContext)
    /**
     * Enter a parse tree produced by [GGParser.args].
     *
     * @param ctx The parse tree
     */
    public fun enterArgs(ctx: GGParser.ArgsContext)

    /**
     * Exit a parse tree produced by [GGParser.args].
     *
     * @param ctx The parse tree
     */
    public fun exitArgs(ctx: GGParser.ArgsContext)
    /**
     * Enter a parse tree produced by [GGParser.arg].
     *
     * @param ctx The parse tree
     */
    public fun enterArg(ctx: GGParser.ArgContext)

    /**
     * Exit a parse tree produced by [GGParser.arg].
     *
     * @param ctx The parse tree
     */
    public fun exitArg(ctx: GGParser.ArgContext)
}