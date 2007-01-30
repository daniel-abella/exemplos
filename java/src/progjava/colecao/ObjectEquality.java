package progjava.colecao;

/**
 * Sobrescrevendo o método {@link java.lang.Object#equals(Object)}
 * 
 * @author Fábio Nogueira de Lucena
 *
 */
public class ObjectEquality {
	private ObjectEquality() {/* Construtor vazio */}
	
	public static void main(final String[] args) {
		final UmaClasse umaClasse = new UmaClasse(2);
		final UmaSubClasse umaSubClasse = new UmaSubClasse(2);
		System.out.println(umaSubClasse.equals(umaClasse));
		System.out.println(umaClasse.equals(umaSubClasse));
	}
}

class  UmaClasse {
	private int valor;
	
	public boolean equals(final Object obj) {		
		return (obj instanceof UmaClasse) && (((UmaClasse)obj).valor == valor);
	}
	
	public int getValor() {
		return valor;
	}
	
	private void setValor(final int valor) {
		this.valor = valor;
	}
	
	public UmaClasse(int valor) {
		setValor(valor);
	}
	
	public int hashCode() {
		return valor;
	}
}

class UmaSubClasse extends UmaClasse {
	private int valor;
	public UmaSubClasse(int valor) {
		super(valor);
		setValor(valor * 2);
	}
	
	public int getValor() {
		return valor;
	}
	
	private void setValor(final int valor) {
		this.valor = valor;
	}
}