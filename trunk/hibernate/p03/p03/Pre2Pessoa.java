package p03;

/**
 * Toda classe a ser persistida como "entidade", ou seja, que
 * pode ser recuperada isoladamente de outros, consultada e
 * assim por diante, terá que armazenar um id.
 * 
 * Enquanto o acesso ao id pode ser útil, alterá-lo pode ser
 * uma atribuição exclusiva do Hibernate, conforme os modificadores
 * de acesso definidos abaixo. 
 */
public class Pre2Pessoa {
	private Long id;
	private String nome;
	
	public String toString() {
		return nome;
	}
	
	public Long getId() {
		return id;
	}
	
	private void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}		
}
