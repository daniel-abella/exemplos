package nove;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProdutoInfo {
	@Id
	@GeneratedValue
	private Long id;

	private String fornecedor;
	private Calendar dataValidade;

	// Construtor default é obrigatório
	public ProdutoInfo() {}

	public ProdutoInfo(String fornecedor, Calendar dataValidade) {
		super();
		this.fornecedor = fornecedor;
		this.dataValidade = dataValidade;
	}
	
	public String toString() {
		return fornecedor + " " + dataValidade;
	}
}
