package jpa22;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Endereco {
	@Id
	@GeneratedValue
	@Column(name="endereco_id")
	private long id;
	
	private String rua;
	
	public String toString() {
		return rua;
	}
	
	public Endereco() {
		rua = Double.toString(Math.random() * 1000);
	}
}
