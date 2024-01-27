// Generated from /Users/snitron/IdeaProjects/tinkoff-edu/mettrans/src/main/java/antlrlab4/GG.g4 by ANTLR 4.13.1
package antlrlab4;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GGParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GGVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GGParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(GGParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link GGParser#nonTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonTerm(GGParser.NonTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link GGParser#dottedWord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDottedWord(GGParser.DottedWordContext ctx);
}