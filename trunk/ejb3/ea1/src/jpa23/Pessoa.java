package jpa23;

import java.io.File;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Pessoa {
	@Id
	private long id;
	
	private String nome;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name="id", referencedColumnName="pessoa_id")
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
	
	public void setId(long id) {
		this.id = id;
	}
}