### Onde obter ###
http://exemplos.googlecode.com/svn/trunk/ejb3/jpaNove/

Exemplos ([série](http://code.google.com/p/exemplos/wiki/ejbPersistence)): [ANTERIOR](http://code.google.com/p/exemplos/wiki/jpaOito) e [PRÓXIMO](http://code.google.com/p/exemplos/wiki/jpaDez).

# Introdução #
Uma instância de Produto pode ou não ser detalhada em uma instância de ProdutoInfo. Neste caso, a anotação **@OneToOne** é empregada onde o argumento **optional** é definido como **true**. Ou seja, uma instância de ProdutoInfo não é obrigatória. Este mapeamento é ilustrado abaixo. Adicionalmente observe que foi empregado outro atributo da anotação: **cascade**. O valor indica que, quando uma instância de Produto for persistida, objetos que podem ser atingidos por referências que são variáveis de instância de Produto também devem ser persistidos. Noutras palavras, neste caso, se houver uma instância de ProdutoInfo associada à instância de Produto a ser persistida, então também persista este objeto de ProdutoInfo.

```
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
```

A classe ProdutoInfo não apresenta nenhuma especificidade em relação a este mapeamento, conforme ilustrado abaixo.

```
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
```

# Programa exemplo #
A aplicação é trivial. Uma instância de Produto é criada e é requisitada a sua persistência.

```
package nove;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProdutoAplicacaoJpa {
    public static void main(String[] args) {
	Produto produto = new Produto("Sabão", 123);

	EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("jpaNove");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	em.persist(produto);
	tx.commit();
	em.close();
    }
}
```

O mapeamento realizado acima admite que tenhamos instâncias de ProdutoInfo sem referências correspondentes a partir de instâncias de Produto. Ao executar o programa abaixo, verifica-se que instâncias de ProdutoInfo podem ser criadas "livremente".

```
package nove;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProdutoInfoAplicacao {
    public static void main(String[] args) {
	ProdutoInfo pi = new ProdutoInfo("A", Calendar.getInstance());

	EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("jpaNove");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	em.persist(pi);
	tx.commit();
	em.close();
    }
}
```

# Considerações finais #
Este exemplo ilustra o relacionamento 1->0..1, ou seja, o relacionamento de um para zero ou uma instância. Observe ainda que não se trata de um relacionamento bidirecional.