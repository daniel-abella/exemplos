package jpa23;

import java.io.File;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Pessoa {
	@Id
	@GeneratedValue
	private long id;
	
	private String nome;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name="pessoa_id", referencedColumnName="id")
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