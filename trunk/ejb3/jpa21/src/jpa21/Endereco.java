package jpa21;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Endereco {
	@Id
	@GeneratedValue
	private long id;
	
	private String rua;
	
	public String toString() {
		return rua;
	}
	
	public Endereco() {
		rua = Double.toString(Math.random() * 1000);
	}
}
