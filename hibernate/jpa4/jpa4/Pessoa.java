package jpa4;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jp4_pessoa")
public class Pessoa {
	
	@Id @GeneratedValue
	private Long id;

	private float peso;

	private boolean casado;

	private char sexo;

	private String nome;

	private Calendar nascimento;
	
	public Pessoa() {
		nascimento = Calendar.getInstance();
		sexo = 'F';
	}

	public String toString() {
		return nome + " nasceu em " + nascimento.get(Calendar.YEAR) + " "
				+ casado + " " + sexo;
	}

	public boolean isCasado() {
		return casado;
	}

	public void setCasado(boolean casado) {
		this.casado = casado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
}
