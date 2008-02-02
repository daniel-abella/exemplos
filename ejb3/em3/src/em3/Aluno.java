package em3;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@NamedQuery(name = "nomes", query = "SELECT nome FROM Aluno")

@Entity
@Table(name = "ALUNOS")
public class Aluno {
	@Id
	@GeneratedValue
	private long id;

	private String nome;
	
	@OneToOne
	private Pessoa pessoa;

	public Aluno() {
	}

	public Aluno(String nome) {
		this.nome = nome;
	}

	public String toString() {
		return "(" + id + "," + nome + ")";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}			
}
