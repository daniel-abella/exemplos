package progjava.acesso;
public class Clone {
    public static synchronized void main(String args[]) throws Exception {
	// N�o compila!
	// clone() � protected e a classe corrente encontra-se
	// em package diferente de java.lang (onde se encontra Object)
	// new Object().clone();
    }
}
