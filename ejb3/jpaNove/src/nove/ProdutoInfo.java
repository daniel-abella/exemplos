package nove;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class ProdutoInfo implements Serializable {
	@Id
	@GeneratedValue
	private Long id;

	private String fornecedor;
    
    @Temporal(javax.persistence.TemporalType.DATE)
	private Calendar dataValidade;

	// Construtor default é obrigatório
	public ProdutoInfo() {}

	public ProdutoInfo(String fornecedor, Calendar dataValidade) {
		super();
		this.fornecedor = fornecedor;
		this.dataValidade = dataValidade;
	}

    public Long getId() {
        return id;
    }
	
    @Override
	public String toString() {
		return fornecedor + " " + new Date(dataValidade.getTimeInMillis());
	}
}
