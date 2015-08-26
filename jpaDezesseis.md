### Onde obter ###
http://exemplos.googlecode.com/svn/trunk/ejb3/jpaDezesseis/

Exemplos ([série](http://code.google.com/p/exemplos/wiki/ejbPersistence)): [ANTERIOR](http://code.google.com/p/exemplos/wiki/jpaQuinze) e [PRÓXIMO](http://code.google.com/p/exemplos/wiki/jpaDezessete).

# Introdução #
A anotação **@Column** permite fornecer vários "ajustes finos" para colunas. Boa parte dos argumentos para esta anotação permitem fornecer detalhes para a geração automática de tabelas. Alguns deles são ilustrados na classe abaixo.

```
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
	@Column(insertable=false, updatable=false)
	private int chave;

	public void setChave(int chave) {
		this.chave = chave;
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
```

A aplicação que exercita as classes e o mapeamento realizado acima segue abaixo. Leia os comentários para detalhes.

```
package dezesseis;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ExercitaColunas {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaDezesseis");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(new A()); // 2 instâncias de A
		em.persist(new A()); // ids gerados pelo persistence provider
		
		C c1 = new C();
		c1.setCadastroPessoaFisica("123");		
		C c2 = new C();
		c2.setCadastroPessoaFisica("123");
		em.persist(c1); // Nenhum problema em persistir c1 e c2
		em.persist(c2); // cpf não é 'unique', conforme mapeamento
		
		D d1 = new D();  // CPF é unique (segunda execução deste código falha)
		d1.setCpf("xxx");
		em.persist(d1);
		
		E e1 = new E();
		e1.setX((int)(Math.random() * 1000 * 1000));		
		em.persist(e1); // 0 é persistido (insertable=false, updatable=false)
		
		F f1 = new F();
		f1.setNome("não pode ser null");
		em.persist(f1);
		
		// HSQLDB aceita nome acima do limite de caracteres estabelecido.
		F f2 = new F();
		f2.setNome("nome com mais de trinta e sete caracteres (erro)?");
		em.persist(f2);

		tx.commit();
		em.close();
	}
}
```