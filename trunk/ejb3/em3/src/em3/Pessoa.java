package em3;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PESSOAS")
public class Pessoa {
	@Id
	@GeneratedValue
	private long id;

	private String nome;

	public Pessoa() {
	}

	public Pessoa(String nome) {
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String toString() {
		return nome;
	}
}
