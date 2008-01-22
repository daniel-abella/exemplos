package jpa22;

import java.io.File;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Pessoa {
	@Id
	@GeneratedValue
	private long id;
	
	private String nome;
	
	@OneToOne
	@JoinColumn(referencedColumnName="endereco_id", name="END_ID")
	private Endereco endereco;
	
	public Pessoa() throws Exception {
		nome = File.createTempFile("pref", "sufixo").toString();
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public String toString() {
		return nome + " " + endereco;
	}
	
	public long getId() {
		return id;
	}
}