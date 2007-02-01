package p07;

import java.util.Map;

public class Previdencia {
	private Long id;
	private String nome;
	private Map<String,String> beneficiarios;
	
	public String toString() {
		return nome + " " + beneficiarios;
	}
	
	public Map<String, String> getBeneficiarios() {
		return beneficiarios;
	}
	public void setBeneficiarios(Map<String, String> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
}
