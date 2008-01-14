package dezesseis;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
class A {
	@Id
	@GeneratedValue
	private int chave;
	
	private byte pequenoInt;
	
	public void setChave(int chave) {
		this.chave = chave;
	}
}

@Entity
class B {
	@Id
	@GeneratedValue
	private int chave;
	
	@Column
	private byte pequenoInt;
}

@Entity
class C {
	@Id
	@GeneratedValue
	private int chave;
	
	@Column(name="NUMERO_CADASTRO_PF")
	private String cadastroPessoaFisica;

	public void setCadastroPessoaFisica(String cadastroPessoaFisica) {
		this.cadastroPessoaFisica = cadastroPessoaFisica;
	}		
}

@Entity
class D {
	@Id
	@GeneratedValue
	private int chave;
	
	@Column(unique=true)
	private String cpf;

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}

@Entity
class E {
	@Id
	@GeneratedValue
	private int chave;

	@Column(insertable=false, updatable=false)
	private int x;
	
	public void setX(int x) {
		this.x = x;
	}		
}

@Entity
class F {
	@Id
	@GeneratedValue
	private long chave;

	@Column(length=37, nullable=false)
	public String nome;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}