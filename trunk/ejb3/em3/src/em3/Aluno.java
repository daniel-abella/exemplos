package em3;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@NamedQuery(name = "todos", query = "SELECT a FROM Aluno a")

@Entity
@Table(name = "ALUNOS")
public class Aluno {
	@Id
	@GeneratedValue
	private long id;
	
	private String codigo;
	
	@OneToOne
	private Pessoa pessoa;

	public Aluno() {
	}

	public Aluno(String codigo, Pessoa pessoa) {
		this.codigo = codigo;
		this.pessoa = pessoa;
	}

	public String toString() {
		return "(" + id + "," + pessoa + ")";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}			
}
