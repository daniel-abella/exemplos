package oito;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Pessoa {
	@Id
	@GeneratedValue
	private Long id;

	// Propriedades persistidas por padr�o (sem anota��o)
	private String rua;
	private int numero;

	// Ignora propriedade (n�o ser� persistida)
	@Transient
	private String nome;

	public Pessoa() {}

	public Pessoa(String nome, String rua, int numero) {
		this.nome = nome;
		this.rua = rua;
		this.numero = numero;
	}

	public String toString() {
		return nome + " " + rua + " " + numero;
	}
	
	public Long getId() { 
		return id;
	}
}
