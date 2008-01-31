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
		
		@NamedQuery(name = "porParteNome", query = "   SELECT a FROM Aluno a WHERE a.nome LIKE :parte"),

		@NamedQuery(name = "obtemAlunosDeConjunto", query = "   SELECT a FROM Aluno a WHERE a.nome IN ('Aluno 5', 'Aluno 4', 'Aluno 1')"),
		@NamedQuery(name = "obtemAlunosNomesVaziosOuNulos", query = "   SELECT a FROM Aluno a WHERE a.nome is empty OR a.nome is null"),
		@NamedQuery(name = "obtemMatriculaMenos5", query = "SELECT a FROM Aluno a WHERE NOT(a.matricula = 5)"),
		@NamedQuery(name = "obtemCONCAT", query = "SELECT a FROM Aluno a WHERE CONCAT(a.nome, '1') = 'Aluno 51'"),
		@NamedQuery(name = "obtemSUBSTRING", query = "SELECT a FROM Aluno a WHERE SUBSTRING(a.nome, 1, 1) = 'A'"),
		@NamedQuery(name = "obtemTRIMBOTH", query = "SELECT a FROM Aluno a WHERE TRIM(BOTH 'A' FROM a.nome) = 'l'"),
		@NamedQuery(name = "obtemLOWER", query = "SELECT a FROM Aluno a WHERE LOWER(a.nome) = 'aluno 5'"),
		@NamedQuery(name = "obtemUPPER", query = "SELECT a FROM Aluno a WHERE UPPER(a.nome) = 'ALUNO 5'"),
		@NamedQuery(name = "obtemLENGTH", query = "SELECT a FROM Aluno a WHERE LENGTH(a.nome) = 7"),
		@NamedQuery(name = "obtemLOCATE", query = "SELECT a FROM Aluno a WHERE LOCATE('5', a.nome) = 7"),
		@NamedQuery(name = "obtemABS", query = "SELECT a FROM Aluno a WHERE ABS(a.matricula) >= 5"),
		@NamedQuery(name = "obtemSQRT", query = "SELECT a FROM Aluno a WHERE SQRT(a.matricula) >= 1.00"),
		@NamedQuery(name = "obtemMOD", query = "SELECT a FROM Aluno a WHERE MOD(a.matricula, 5) = 0"),
		@NamedQuery(name = "obtemUPDATE", query = "UPDATE Aluno a SET a.nome = 'Aluno 666' WHERE a.nome = 'Aluno 7'"),
		@NamedQuery(name = "obtemDELETE", query = "DELETE  FROM  Aluno a WHERE a.nome = 'Aluno 666'"),
		@NamedQuery(name = "obtemOrder", query = "SELECT a FROM Aluno a order by a.matricula asc"),
		@NamedQuery(name = "obtemAvg", query = "SELECT MIN(a.nome) FROM Aluno a"),
		@NamedQuery(name = "obtemCount", query = "SELECT COUNT(a.nome) FROM Aluno a"),
		@NamedQuery(name = "obtemMin", query = "SELECT MIN(a.nome) FROM Aluno a"),
		@NamedQuery(name = "obtemMax", query = "SELECT MAX(a.matricula) FROM Aluno a WHERE a.nome = 'Aluno 5'"),
		@NamedQuery(name = "obtemAlunosMatricula", query = "SELECT nome FROM Aluno nome WHERE nome.matricula = :matriculaaluno"),
		@NamedQuery(name = "obtemMatriculaAluno", query = "SELECT matricula FROM Aluno matricula WHERE matricula.nome = :alunomatricula") })
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
