package p09;

public class Endereco {
	private Long id;

	private String rua;

	private Pessoa pessoa;
	
	public boolean equals(Object obj) {
		if (obj instanceof Endereco
				&& ((Endereco)obj).getRua().equals(rua))
			return true;
		else
			return false;
	}

	public int hashCode() {
		return rua.hashCode();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public String toString() {
		return rua + " {" + (pessoa != null ? pessoa.getId() : "") + "}";
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}
}
