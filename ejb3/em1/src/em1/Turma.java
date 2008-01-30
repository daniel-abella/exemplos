package em1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Turma {
	@Id
	@GeneratedValue
	private long id;
	
	private String nome;

	@OneToMany
	@JoinColumn(name="TURMA_ID")
	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	public void adicionaAluno(Aluno novoAluno) {
		alunos.add(novoAluno);
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}
	
	public Turma() {}
	
	public Turma(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		String retorno = nome + " (";
		for (Aluno aluno : alunos)
			retorno += aluno + " ";
		
		return retorno + ")";
	}
}