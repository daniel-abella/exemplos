package map;

public class Disciplina {
	private String codigo;
	private String nome;	
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return codigo + ' ' + nome;
	}
}
