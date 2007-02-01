package p08;

public class A {
    private Long id;
    private String nome;
    
    public A() {
    	setNome("SEM NOME");
    }
    
    public A(String n) {
    	nome = n;
    }
    
	private String getNome() {
		return nome;
	}

	private void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String toString() {
		return id.toString() + " " + nome;
	}
}
