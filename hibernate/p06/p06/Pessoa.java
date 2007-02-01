package p06;

import java.util.Calendar;

public class Pessoa {
    private Long id;

    private float peso;
    private boolean casado;
    private char sexo;
    
    private String nome;
    private Calendar nascimento;
    
	public String toString() {
		return nome + " nasceu em " + nascimento.get(Calendar.YEAR);
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
	
	private void setId(Long id) {
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
