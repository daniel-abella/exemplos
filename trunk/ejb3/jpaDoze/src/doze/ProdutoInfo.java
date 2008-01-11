package doze;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ProdutoInfo {
	@Id
	@GeneratedValue
	private Long id;

	private String fornecedor;
	private Calendar dataValidade;
	
	@OneToOne(mappedBy="produtoInfo", optional=false)
	private Turma produto;
	
	public Turma getProduto() {
		return produto;
	}
	
	public void setProduto(Turma produto) {
		this.produto = produto;
	}

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
