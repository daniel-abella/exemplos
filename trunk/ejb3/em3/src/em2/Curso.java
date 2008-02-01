package em2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="CURSOS")
public class Curso {
	@Id
	@GeneratedValue
	private long id;
	
	private int codigo;

	@ManyToMany(mappedBy="cursos")
	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	public void adicionaAluno(Aluno novoAluno) {
		alunos.add(novoAluno);
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}
	
	public Curso() {}
	
	public Curso(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigo(){
		return codigo;
	}
	
	public String toString() {
		return "(" + id + "," + codigo + ")";
	}
}