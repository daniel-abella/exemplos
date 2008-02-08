package quatro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Endereco {
	@Id
	@GeneratedValue
	private Long id;

	private String rua;
	private int numero;

	// Construtor default � obrigat�rio
	public Endereco() {}

	public Endereco(String rua, int numero) {
		super();
		this.rua = rua;
		this.numero = numero;
	}
}