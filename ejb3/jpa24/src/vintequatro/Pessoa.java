package vintequatro;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pessoa implements Serializable {
	@Id
	@GeneratedValue
	private long id;

	private String nome;

	public Pessoa() {}

	public Pessoa(String nome) {
		this.nome = nome;
	}
	
    @Override
	public String toString() {
		return nome;
	}
}
