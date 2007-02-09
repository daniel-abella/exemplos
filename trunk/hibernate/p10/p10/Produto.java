package p10;

public class Produto {
	private Long id;
	private String nome;
	
	public Produto() {}
	
	public Produto(String nome) {
		this.nome = nome;
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
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Produto)
			return nome.equals((Produto)obj);
		else
			return false;
	}
	@Override
	public int hashCode() {
		return nome.hashCode();
	}
	
	public String toString() {
		return nome;
	}
}
