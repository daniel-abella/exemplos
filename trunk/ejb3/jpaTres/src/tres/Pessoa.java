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
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Pessoa() {}
	
	public Pessoa(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return nome;
	}
}
