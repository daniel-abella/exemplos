package p17;

import java.util.HashSet;
import java.util.Set;

public class Pai {
	private Long id;
	private String nome;
	private Set<Filho> filhos = new HashSet<Filho>();

	public Set<Filho> getFilhos() {
		return filhos;
	}

	public void setFilhos(Set<Filho> filhos) {
		this.filhos = filhos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
