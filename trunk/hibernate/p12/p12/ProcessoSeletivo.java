package p12;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ProcessoSeletivo {
	private Long id;
	private Set<Candidato> candidatos = new HashSet<Candidato>();
	private Date data;
	
	public void adicionaCandidato(Candidato c) {
		c.setProcessoSeletivo(this);
		candidatos.add(c);
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Set<Candidato> getCandidatos() {
		return candidatos;
	}
	public void setCandidatos(Set<Candidato> candidatos) {
		this.candidatos = candidatos;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
