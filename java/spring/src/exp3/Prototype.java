package exp3;

public class Prototype {
	private double valor = 0D;

	private Prototype proximo;

	private static int numInstancias = 0;

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Prototype getProximo() {
		return proximo;
	}

	public void setProximo(Prototype proximo) {
		this.proximo = proximo;
	}

	public Prototype(double valor, Prototype proximo) {
		this.valor = valor;
		this.proximo = proximo;
	}

	// EXIGIDO PELO SPRING (wiring through properties)
	public Prototype() {
	}

	public void iniciaInstancia() {
		numInstancias++;
	}
	
	public void finalizaInstancia() {
		System.out.println("finalizando ...");
		numInstancias--;
	}
	
	public static int getNumInstancias() {
		return numInstancias;
	}
}
