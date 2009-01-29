package quatro;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Endereco implements Serializable {
	@Id
	@GeneratedValue
	private Long id;

	private String rua;
	private int numero;

	// Construtor default é obrigatório
	public Endereco() {}

	public Endereco(String rua, int numero) {
		super();
		this.rua = rua;
		this.numero = numero;
	}
}
