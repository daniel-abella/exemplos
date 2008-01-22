package jpa21;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pessoa {
	@Id
	@GeneratedValue
	private long id;
	
	private String nome;
	
	@OneToOne
	private Endereco endereco;
}