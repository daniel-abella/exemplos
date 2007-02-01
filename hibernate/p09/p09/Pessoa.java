package p09;

import java.util.HashSet;
import java.util.Set;

public class Pessoa {
	private Long id;

	private Set<Endereco> enderecos = new HashSet<Endereco>();

	public String toString() {
		return "pessoa {" + id + "} (" + enderecos.size() + " enderecos)";
	}

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Endereco getEndereco() {
		return enderecos.iterator().hasNext() ? 
				(Endereco) enderecos.iterator().next() : 
				null;
	}

	public void adicionaEndereco(Endereco end) {
		end.setPessoa(this);
		enderecos.add(end);
	}

	public Set<Endereco> getEnderecos() {
		return enderecos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
