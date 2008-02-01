package doze;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Turma {
	@Id
	@GeneratedValue
	private long id;
	private double codigo;
	private Date inicioAulas;

	@OneToMany
	private List<Aluno> matriculados = new ArrayList<Aluno>();
	
	public Date getInicioAulas() {
		return inicioAulas;
	}

	public void setInicioAulas(Date inicioAulas) {
		this.inicioAulas = inicioAulas;
	}

	public Turma() {
		super();
		this.inicioAulas = new Date();
	}

	public double getCodigo() {
		return codigo;
	}

	public void setCodigo(double codigo) {
		this.codigo = codigo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.matriculados = alunos;
	}

	public void adicionaAluno(Aluno novoAluno) {
		matriculados.add(novoAluno);
	}
	
	public List<Aluno> getAlunos() {
		return matriculados;
	}
}