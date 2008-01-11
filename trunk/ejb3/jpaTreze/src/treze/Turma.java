package treze;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Turma {
	@Id
	@GeneratedValue
	private long id;

	@OneToMany(mappedBy="turma")
	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	public void adicionaAluno(Aluno novoAluno) {
		alunos.add(novoAluno);
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}
}