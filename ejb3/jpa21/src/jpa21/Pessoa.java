package jpa21;

import java.io.File;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pessoa implements Serializable {
	@Id
	@GeneratedValue
	private long id;
	
	private String nome;
	
	@OneToOne
	private Endereco endereco;
	
	public Pessoa() throws Exception {
		nome = File.createTempFile("pref", "sufixo").toString();
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
    @Override
	public String toString() {
		return nome + " " + endereco;
	}
	
	public long getId() {
		return id;
	}
}