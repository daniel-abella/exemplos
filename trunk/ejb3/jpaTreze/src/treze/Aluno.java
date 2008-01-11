package treze;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Aluno {
	@Id
	@GeneratedValue
	private long id;

	@ManyToOne(optional=false)
	private Turma turma;
	
	private String nome;
	
	public Aluno() {}
	
	public Aluno(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return nome;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
}
