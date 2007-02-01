package p15;

import java.util.ArrayList;
import java.util.List;

public class Endereco {
	private Long id;
	private List<Telefone> telefones = new ArrayList<Telefone>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	public void adicionaTelefone(Telefone telefone) {
		telefones.add(telefone);
	}

	public String toString() {
		return id + " (" + telefones.size() + ")";
	}
}
