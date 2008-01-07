package cinco;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pessoa {
	@Id
	@GeneratedValue
	private Long id;

	private String nome;

	@OneToMany
	private List<Endereco> enderecos;

	public Pessoa() {}

	public Pessoa(String nome, Endereco endereco) {
		this.nome = nome;
		this.enderecos = new ArrayList<Endereco>();
		enderecos.add(endereco);
	}
	
	public void adicionaEndereco(Endereco endereco) {
		enderecos.add(endereco);
	}

	public String toString() {
		return nome + " " + enderecos;
	}
}
