package quinze;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Aluno {
	@Id
	@GeneratedValue
	private long id;

	@ManyToMany
	private Set<Curso> cursos = new HashSet<Curso>();
	
	private String nome;
	
	public Aluno() {}
	
	public Aluno(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return nome;
	}
	
	public void adicionaCurso(Curso curso) {
		cursos.add(curso);
	}
}
