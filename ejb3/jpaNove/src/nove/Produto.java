package nove;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Produto implements Serializable {
	@Id
	@GeneratedValue
	private Long id;

	private String nome;
	private int codigo;

	@OneToOne(optional=true,cascade=CascadeType.PERSIST)
	private ProdutoInfo produtoInfo;

	public Produto() {}

	public Produto(String nome, int codigo) {
		this.nome = nome;
		this.codigo = codigo;
	}
	
	public void setProdutoInfo(ProdutoInfo produtoInfo) {
		this.produtoInfo = produtoInfo;
	}

    public Long getId() {
        return id;
    }

    @Override
	public String toString() {
		return nome + " " + codigo + " (" + produtoInfo + ")";
	}
}
