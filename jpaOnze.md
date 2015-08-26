### Onde obter ###
http://exemplos.googlecode.com/svn/trunk/ejb3/jpaOnze/

Exemplos ([série](http://code.google.com/p/exemplos/wiki/ejbPersistence)): [ANTERIOR](http://code.google.com/p/exemplos/wiki/jpaDez) e [PRÓXIMO](http://code.google.com/p/exemplos/wiki/jpaDoze).

# Introdução #
Produto possui uma referência para ProdutoInfo em relacionamento bidirecional.

```
package onze;

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
package onze;

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

    @OneToOne(mappedBy="produtoInfo", optional=false)
    private Produto produto;

    public Produto getProduto() { 
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

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
Observe que a instância de Produto está associada à instância de ProdutoInfo e vice-versa. Esta relação deve ser estabelecida explicitamente, conforme realizado pelos métodos **setProdutoInfo** e **setProduto**. Esta relação é de responsabilidade do autor do programa e, naturalmente, não poderia ser "automaticamente" fornecida pelo _persistence provider_. Também não é o _persistence provider_, mas o autor do código, o responsável por persistir a instância de ProdutoInfo seguida da requisição para persistir Produto, conforme ilustrado abaixo.

```
package onze;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProdutoAplicacaoJpa {
    public static void main(String[] args) {
	ProdutoInfo pi = new ProdutoInfo("sem tiras", Calendar.getInstance());
	Produto produto = new Produto("Chinelo", 123);
	produto.setProdutoInfo(pi);
	pi.setProduto(produto);

	EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("jpaOnze");
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

O mapeamento realizado não admite que tenhamos instâncias de ProdutoInfo sem referências correspondentes a partir de instâncias de Produto. Não será possível persistir uma instância de ProdutoInfo sem a correspondente persistência da instância de Produto ao qual está associada. A exceção gerada pelo programa abaixo ilustra este cenário. Observe que abaixo é requisitada apenas a persistência da instância de ProdutoInfo. A persistência da instância correspondente de !Produto não é requisitada.

```
package onze;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProdutoInfoAplicacao {
    public static void main(String[] args) {
	ProdutoInfo pi = new ProdutoInfo("Tiras duplas", Calendar.getInstance());
	Produto produto = new Produto("Chinelo", 123);
	produto.setProdutoInfo(pi);
	pi.setProduto(produto);
		
	EntityManagerFactory emf = Persistence
		.createEntityManagerFactory("jpaOnze");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	em.persist(pi);
	tx.commit();
	em.close();
    }
}
```

Tampouco é permitido, dado o mapeamento, persistir duas ou mais instâncias de Produto que fazem referência para uma mesma instância de ProdutoInfo, conforme a exceção gerada pela execução do código abaixo.

```
package onze;

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
	pi.setProduto(p1);
		
	Produto p2 = new Produto("Leite", 100);
	p2.setProdutoInfo(pi);

	EntityManagerFactory emf = Persistence
		.createEntityManagerFactory("jpaOnze");
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
Este exemplo ilustra o relacionamento 1

&lt;-&gt;

1 (bidirecional). Neste caso, só se persiste uma instância de Produto com a correspondente instância de ProdutoInfo devidamente estabelecida. Convém ressaltar a cardinalidade. Dada uma instânciade Produto, há uma única instância de ProdutoInfo que se obtém da primeira instância e, esta primeira instância, é exatamente aquela obtida a partir da instância de ProdutoInfo.