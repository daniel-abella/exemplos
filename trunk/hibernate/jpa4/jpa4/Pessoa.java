package jpa4;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jpa4_pessoa")
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
	
	public static Pessoa getInstance() {
		Pessoa p = new Pessoa();
		p.setNome(Integer.toString((int)(Math.random() * 100)));
		p.setCasado(false);
		p.setNascimento(Calendar.getInstance());
		p.setPeso(10.0f);
		p.setSexo(Math.random() > .5 ? 'm' : 'f');
		return p;
	}
}
