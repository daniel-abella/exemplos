package p12;

public class Candidato {
	private Long id;
	private String nome;
	private ProcessoSeletivo processoSeletivo;
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
	public ProcessoSeletivo getProcessoSeletivo() {
		return processoSeletivo;
	}
	public void setProcessoSeletivo(ProcessoSeletivo ps) {
		this.processoSeletivo = ps;
	}
	
}
