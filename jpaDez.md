### Onde obter ###
http://exemplos.googlecode.com/svn/trunk/ejb3/jpaDez/

Exemplos ([série](http://code.google.com/p/exemplos/wiki/ejbPersistence)): [ANTERIOR](http://code.google.com/p/exemplos/wiki/jpaNove) e [PRÓXIMO](http://code.google.com/p/exemplos/wiki/jpaOnze).

# Introdução #
Neste cenário, dada uma instância de Produto, necessariamente deve estar associada uma instância de ProdutoInfo. Ainda convém ressaltar que duas instâncias de Produto não poderão referenciar uma mesma instância de ProdutoInfo. Uma instância de Produto pode ou não ser detalhada em uma instância de ProdutoInfo. Para isto, a anotação **@OneToOne** é empregada onde o argumento **optional** com o valor **false**. Isto indica que ProdutoInfo não é opcional.

```
package dez;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Produto {
    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private int codigo;

    @OneToOne(optional=false)
    private ProdutoInfo produtoInfo;

    public Produto() {}

    public Produto(String nome, int codigo) {
	this.nome = nome;
	this.codigo = codigo;
    }
	
    public void setProdutoInfo(ProdutoInfo produtoInfo) {
	this.produtoInfo = produtoInfo;
    }

    public String toString() {
	return nome + " " + codigo + " (" + produtoInfo + ")";
    }
}
```

A classe ProdutoInfo não apresenta nenhuma especificidade em relação a este mapeamento, conforme ilustrado abaixo.

```
package dez;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProdutoInfo {
    @Id
    @GeneratedValue
    private Long id;

    private String fornecedor;
    private Calendar dataValidade;

    // Construtor default é obrigatório
    public ProdutoInfo() {}

    public ProdutoInfo(String fornecedor, Calendar dataValidade) {
	super();
	this.fornecedor = fornecedor;
	this.dataValidade = dataValidade;
    }
	
    public String toString() {
	return fornecedor + " " + dataValidade;
    }
}
```

# Programa exemplo #
A aplicação é trivial. Uma instância de Produto é criada e é requisitada a sua persistência. Antes, contudo, observe que foi estabelecida uma relação com a instância criada de ProdutoInfo. Por fim, antes de persistir a instância de Produto, deve ser assegurada que a instância de ProdutoInfo foi persistida.

```
package dez;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProdutoAplicacaoJpa {
    public static void main(String[] args) {
	ProdutoInfo pi = new ProdutoInfo("sem tiras", Calendar.getInstance());
	Produto produto = new Produto("Chinelo", 123);
	produto.setProdutoInfo(pi);

	EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("jpaNove");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
        em.persist(pi);
	em.persist(produto);
	tx.commit();
	em.close();
    }
}
```

O mapeamento realizado acima admite que tenhamos instâncias de ProdutoInfo sem referências correspondentes a partir de instâncias de Produto. Ao executar o programa abaixo, verifica-se que instâncias de ProdutoInfo podem ser criadas "livremente".

```
package dez;

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

Por outro lado, não será possível termos duas ou mais instâncias de Produto referenciando uma mesma instância de ProdutoInfo, conforme a exceção gerada pelo código abaixo, quando executado.

```
package dez;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProdutosInfoAplicacao {
    public static void main(String[] args) {
	ProdutoInfo pi = new ProdutoInfo("sem tiras", Calendar.getInstance());
	Produto p1 = new Produto("Chinelo", 123);
	p1.setProdutoInfo(pi);
		
	Produto p2 = new Produto("Leite", 100);
	p2.setProdutoInfo(pi);

	EntityManagerFactory emf = Persistence
		.createEntityManagerFactory("jpaDez");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	em.persist(pi);
	em.persist(p1);
	em.persist(p2);
	tx.commit();
	em.close();
    }
}
```

# Considerações finais #
Este exemplo ilustra o relacionamento 1->1, ou seja, o relacionamento de um para um. Observe que não se trata de um relacionamento bidirecional, ou seja, da instância de ProdutoInfo não é possível recuperar a instância de Produto correspondente.