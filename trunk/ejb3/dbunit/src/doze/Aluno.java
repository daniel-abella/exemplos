package doze;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Aluno {
	@Id @GeneratedValue
	private Long id;
	@OneToOne(cascade=CascadeType.ALL)
	private Endereco end;
	private int rg;
	private String nome;
	private String[] apelidos;
	private double[] turmasCursadas;
	private Calendar nascimento;
	
	public double[] getTurmasCursadas() {
		return turmasCursadas;
	}

	public void setTurmasCursadas(double[] turmasCursadas) {
		this.turmasCursadas = turmasCursadas;
	}

	public Calendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}

	public Aluno(int rg, String nome) {
		super();
		this.rg = rg;
		this.nome = nome;
		this.nascimento = Calendar.getInstance(); 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String[] getApelidos() {
		return apelidos;
	}

	public void setApelidos(String[] apelidos) {
		this.apelidos = apelidos;
	}

	public Aluno() {}
	
	public Aluno(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return nome;
	}

	public Endereco getEndereco() {
		return end;
	}

	public void setEndereco(Endereco end) {
		this.end = end;
	}

	public int getRg() {
		return rg;
	}

	public void setRg(int numero) {
		this.rg = numero;
	}
}
