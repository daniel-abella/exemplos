package progjava.acesso;
public class Clone {
    public static synchronized void main(String args[]) throws Exception {
	// Não compila!
	// clone() é protected e a classe corrente encontra-se
	// em package diferente de java.lang (onde se encontra Object)
	// new Object().clone();
    }
}
