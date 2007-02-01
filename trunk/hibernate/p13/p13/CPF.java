package p13;

public class CPF {
    private Long id;
    private String numero;
    private Pessoa pessoa;
    
    public String toString() {
    	return numero == null ? "null" : numero;
    }
    
    public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
		if (pessoa.getCpf() != this) pessoa.setCpf(this);
	}

	public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNumero() {
        return numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
}
