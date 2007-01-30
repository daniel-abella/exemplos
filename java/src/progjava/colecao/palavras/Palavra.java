package progjava.colecao.palavras;

public class Palavra {
	private String palavra;
	
	public Palavra() {}
	public Palavra(String nome) {
		palavra = nome;
	}
	
	public String getPalavra() {
		return palavra;
	}
	
	public char primeiraLetra() {
		return palavra.charAt(0);
	}
	
	public boolean equals(Object outro) {
		if (outro instanceof Palavra && palavra.equals(((Palavra)outro).getPalavra()))
			return true;
		
		return false;
	}
	
	public int hashCode() {
		return palavra.hashCode();
	}
}
