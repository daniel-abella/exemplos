package um;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pessoa {
	@Id
	private Long id;
	
	private String nome;
	
	public Pessoa(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return nome;
	}
}
