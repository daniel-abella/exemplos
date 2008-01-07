package seis;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FISICA")
public class PessoaFisica extends Pessoa {
	private String cpf;
	
	public PessoaFisica(String nome, String cpf) {
		super(nome);
		this.cpf = cpf;
	}

	public String toString() {
		return super.toString() + " " + cpf;
	}
}
