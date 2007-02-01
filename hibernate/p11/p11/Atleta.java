package p11;

import java.util.HashSet;
import java.util.Set;

public class Atleta {
	private Long id;

	private String nome;
	
	private Set<Recorde> recordes = new HashSet<Recorde>();
	
	public Set<Recorde> getRecordes() {
		return recordes;
	}

	public void setRecordes(Set<Recorde> recordes) {
		this.recordes = recordes;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Atleta && ((Atleta) obj).nome.equals(nome))
			return true;
		else
			return false;
	}

	public int hashCode() {
		return nome.hashCode();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(nome + " (");
		int nr = recordes.size();
		if (nr == 0) 
			sb.append("nenhum");
		else
			sb.append(nr);
		sb.append(nr > 1 ? " recordes)" : " recorde)");
		return sb.toString();
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
