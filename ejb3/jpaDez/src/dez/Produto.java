package dez;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Produto {
	@Id
	@GeneratedValue
	private Long id;

	private String nome;
	private int codigo;

	@OneToOne(optional=false)
	private ProdutoInfo produtoInfo;

	public Produto() {}

	public Produto(String nome, int codigo) {
		this.nome = nome;
		this.codigo = codigo;
	}
	
	public void setProdutoInfo(ProdutoInfo produtoInfo) {
		this.produtoInfo = produtoInfo;
	}

	public String toString() {
		return nome + " " + codigo + " (" + produtoInfo + ")";
	}
}
