package quatro;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pessoa implements Serializable {
	@Id
	@GeneratedValue
	private Long id;

	private String nome;

	@OneToOne
	private Endereco endereco;

	public Pessoa() {}

	public Pessoa(String nome, Endereco endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}

    @Override
	public String toString() {
		return nome;
	}
}
