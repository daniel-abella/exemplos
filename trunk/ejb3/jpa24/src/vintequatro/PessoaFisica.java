package vintequatro;

import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Pessoa {
	private String cpf;

    public PessoaFisica() {
    }
	
	public PessoaFisica(String nome, String cpf) {
		super(nome);
		this.cpf = cpf;
	}

    @Override
	public String toString() {
		return super.toString() + " " + cpf;
	}
}
