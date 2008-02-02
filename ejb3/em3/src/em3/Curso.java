package em3;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CURSOS")
public class Curso {
	@Id
	@GeneratedValue
	private long id;
	
	private String codigo;

	@OneToMany
	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	public void adicionaAluno(Aluno novoAluno) {
		alunos.add(novoAluno);
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}
	
	public Curso() {}
	
	public Curso(String codigo) {
		this.codigo = codigo;
	}
	
	public String toString() {
		return "(" + id + "," + codigo + alunos + ")";
	}
}