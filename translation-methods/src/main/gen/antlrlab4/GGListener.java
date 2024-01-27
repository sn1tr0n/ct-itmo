// Generated from /Users/snitron/IdeaProjects/tinkoff-edu/mettrans/src/main/java/antlrlab4/GG.g4 by ANTLR 4.13.1
package antlrlab4;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GGParser}.
 */
public interface GGListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GGParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(GGParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link GGParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(GGParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link GGParser#nonTerm}.
	 * @param ctx the parse tree
	 */
	void enterNonTerm(GGParser.NonTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link GGParser#nonTerm}.
	 * @param ctx the parse tree
	 */
	void exitNonTerm(GGParser.NonTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link GGParser#dottedWord}.
	 * @param ctx the parse tree
	 */
	void enterDottedWord(GGParser.DottedWordContext ctx);
	/**
	 * Exit a parse tree produced by {@link GGParser#dottedWord}.
	 * @param ctx the parse tree
	 */
	void exitDottedWord(GGParser.DottedWordContext ctx);
}