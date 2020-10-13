package tradutor;
import java.io.IOException;

/**
 *
 * @author Rodrigo
 */
public class Tradutor {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args)throws IOException {
        Analisador anali = new Analisador();
        anali.expr();
        }
}
