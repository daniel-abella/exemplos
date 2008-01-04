package tres;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pessoa {
	@Id @GeneratedValue
	private Long id;
	
	private String nome;
	
	@Embedded
	private Endereco endereco;	

	public Pessoa() {}
	
	public Pessoa(String nome, Endereco endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public String toString() {
		return nome;
	}
}
