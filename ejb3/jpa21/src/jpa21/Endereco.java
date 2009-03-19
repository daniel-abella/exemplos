package jpa21;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Endereco implements Serializable {
	@Id
	@GeneratedValue
	private long id;
	
	private String rua;
	
    @Override
	public String toString() {
		return rua;
	}
	
	public Endereco() {
		rua = Double.toString(Math.random() * 1000);
	}
}
