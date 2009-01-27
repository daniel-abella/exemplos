package dois;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pessoa implements Serializable {
	@Id @GeneratedValue
	private Long id;
	
	private String rua;
	private int numero;
	
	private String nome;
	
	public Pessoa() {}
	
	public Pessoa(String nome) {
		this.nome = nome;
	}
	
    @Override
	public String toString() {
		return nome;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
}
