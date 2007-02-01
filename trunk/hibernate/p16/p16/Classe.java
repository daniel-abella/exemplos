package p16;

public class Classe implements Comparable<Classe> {
	private Long id;
	private String nome;
	
	public Classe() {
		nome = Integer.toString((int)(Math.random() * 1000));
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return nome;
	}
	
	public int compareTo(Classe outro) {
		return nome.compareTo(outro.nome);
	}
}
