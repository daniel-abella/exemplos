package p07;

import java.util.Set;

public class Empresa {
	private Long id;
	private String nome;
	private Set<String> emails;
	
	public String toString() {
		return nome + " " + emails;
	}
	
	public Set<String> getEmails() {
		return emails;
	}
	public void setEmails(Set<String> emails) {
		this.emails = emails;
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
}
