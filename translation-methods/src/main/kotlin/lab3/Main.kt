package lab3

import antlr.JavaGrammarLexer
import antlr.JavaGrammarParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.io.ByteArrayOutputStream


val test = """
    package my.best.packet;
    import a.b.c;
    
    public class Main {
    
    class Nested<T> {
    int b = 12;
    String x = "1231312313jgfnkdjfnv";
    
    private static int main() throws VirtualMachineError {
    return 0;
    }
    }
    private int a = 10;
    protected static int b = 11;
    private <T> T foo(List<String> list, Smth<? extends List<? super Number>, Object> smthNumber) {
    Map<Long, String> map = new Map<>();
    return args.getResult();
    } 
        public static void main(int x) {
            for (java.util.String i = 0, int j = 1; ~i < j; i++, --j) {}
            a.b(1);
            while (j < 10);
            
            if (a + 2 > 3 && 3 - 4 < 5) {
                System.out.println("123123");
            } else {
                int a = 2;
                return;
            }
            
            Test test = new Test(123, "yes", Boolean.TRUE);
            int[] test2 = new int[1];
        }
    }
    """.trimIndent()

val test2 = test.replace("\n", "").replace(Regex("\\s+"), " ")

fun main() {
    println("Test:")
    println(test2)
    println()
    println("Result:")
    println()
    val lexer = JavaGrammarLexer(CharStreams.fromString(test2))
    val parser = JavaGrammarParser(CommonTokenStream(lexer))
    val stringOutputStream = ByteArrayOutputStream()

    PrettyJavaGrammarVisitor(stringOutputStream).visitResult(parser.result())
    print(stringOutputStream.toString())
}