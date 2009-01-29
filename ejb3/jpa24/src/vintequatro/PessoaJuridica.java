package vintequatro;

import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends Pessoa {
    
    private String cnpj;

    public PessoaJuridica() {
    }
	
	public PessoaJuridica(String nome, String cnpj) {
		super(nome);
		this.cnpj = cnpj;
	}
	
	public String toString() {
		return super.toString() + " " + cnpj;
	}
}
