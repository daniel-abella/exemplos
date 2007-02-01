package p13;

public class Pessoa {
    private Long id;
    private CPF cpf;
    private String nome;
    
    public Pessoa() {}
    
    public Pessoa(String nome) {
    	this.nome = nome;
    }
    
    public String toString() {
    	return String.format("%d %s %s", id, nome, cpf.toString());
    }
    
    public CPF getCpf() {
        return cpf;
    }
    
    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    	if (cpf.getPessoa() != this) cpf.setPessoa(this);
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }    
}
