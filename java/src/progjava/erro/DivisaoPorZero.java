package progjava.erro;

public class DivisaoPorZero extends ArithmeticException {
	public static final long serialVersionUID = 1L;
	
    public DivisaoPorZero() {
        super("Tentativa de divisão por zero");
    }
}