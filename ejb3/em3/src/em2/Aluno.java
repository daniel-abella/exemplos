package em2;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries( {
		@NamedQuery(name = "nomes", query = "SELECT nome FROM Aluno"),
		@NamedQuery(name = "todos", query = "SELECT t FROM Aluno t"),
		@NamedQuery(name = "porNome", query = "select a FROM Aluno a WHERE a.nome = :nome"),
		@NamedQuery(name = "porCurso", query = "SELECT a FROM Aluno a JOIN a.cursos AS c WHERE c.codigo= :curso"),
		@NamedQuery(name = "porAluno", query = "SELECT c FROM Curso c JOIN c.alunos AS a WHERE a.matricula= :matricula"),		
		@NamedQuery(name = "porMatriculas", query = "SELECT x FROM Aluno AS x WHERE x.matricula > 8 OR x.matricula = 2"),		
		@NamedQuery(name = "porParteNome", query = "SELECT a FROM Aluno a WHERE a.nome LIKE :parte"),
		@NamedQuery(name = "algunsAlunos", query = "SELECT a FROM Aluno a WHERE a.nome IN ('Aluno 4', 'Aluno 1')"),		
		@NamedQuery(name = "nomeVazioOuNull", query = "SELECT a FROM Aluno a WHERE a.nome is '' OR a.nome is null"),		
		@NamedQuery(name = "concat", query = "SELECT a FROM Aluno a WHERE CONCAT(a.nome, '1') = 'Aluno 51'"),		
		@NamedQuery(name = "substring", query = "SELECT a FROM Aluno a WHERE SUBSTRING(a.nome, 1, 1) = 'A'"),		
		@NamedQuery(name = "trim", query = "SELECT a FROM Aluno a WHERE TRIM('1' FROM a.nome) = 'Aluno '"),
		@NamedQuery(name = "ordenados", query = "SELECT a FROM Aluno a order by a.matricula asc"),		
		@NamedQuery(name = "min", query = "SELECT MIN(a.matricula) FROM Aluno a"),
		@NamedQuery(name = "count", query = "SELECT COUNT(a.matricula) FROM Aluno a"),
		@NamedQuery(name = "max", query = "SELECT MAX(a.matricula) FROM Aluno a"),
})

@Entity
@Table(name = "ALUNOS")
public class Aluno {
	@Id
	@GeneratedValue
	private long matricula;

	@ManyToMany
	@JoinTable(name = "MATRICULAS")
	private Set<Curso> cursos = new HashSet<Curso>();

	private String nome;

	public Aluno() {
	}

	public Aluno(String nome) {
		this.nome = nome;
	}

	public long getMatricula() {
		return matricula;
	}

	public String toString() {
		return "(" + matricula + "," + nome + ")";
	}

	public Set<Curso> getCursos() {
		return cursos;

	}

	public void adicionaCurso(Curso curso) {
		cursos.add(curso);
	}
}
