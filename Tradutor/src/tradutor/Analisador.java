
package tradutor;

import java.io.IOException;
/**
 *
 * @author Rodrigo
 */
public class Analisador {
    static int lookahead;
    
    public Analisador() throws IOException {
        System.out.print("Entrada:");
        lookahead = System.in.read();
    }

    private void match(int x) throws IOException {
        if (lookahead == x) {
            lookahead = System.in.read();
        } else {
            throw new Error("erro de sintaxe");
        }
    }

    private void term() throws IOException {
        if (Character.isDigit((char) lookahead)) {
            System.out.print((char) lookahead);

            match(lookahead);
        } else {
            throw new Error("erro de sintaxe");
        }
    }

    public void expr() throws IOException {
        int y = Character.getNumericValue((char) lookahead);
        term();
        while (true) {
            switch (lookahead) {
                case '*': {
                    match('*');
                    y *= Character.getNumericValue((char) lookahead);
                    term();
                    System.out.println("*: " + y);
                }
                case '/':{
                    match('/');
                    y /= Character.getNumericValue((char) lookahead);
                    term();
                    System.out.println("/: " + y);
                }
                case '+':{
                    match('+');
                    y += Character.getNumericValue((char) lookahead);
                    term();
                    System.out.println("+: " + y);
                }
                case '-': {
                    match('-');
                    y -= Character.getNumericValue((char) lookahead);
                    term();
                    System.out.println("-: " + y);
                }
                default:{
                    System.out.println("\nResultado inteiro:" + y);
                    return;
                }
            }
        }
    }
}


