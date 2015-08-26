### Onde obter ###
http://exemplos.googlecode.com/svn/trunk/ejb3/jpaQuatro/

Exemplos ([série](http://code.google.com/p/exemplos/wiki/ejbPersistence)): [ANTERIOR](http://code.google.com/p/exemplos/wiki/jpaTres) e [PRÓXIMO](http://code.google.com/p/exemplos/wiki/jpaCinco).

# Introdução #

No corrente cenário, a classe Endereco é fornecida abaixo.

```
package quatro;

public class Endereco {
    private String rua;
    private int numero;
	
    public Endereco(String rua, int numero) {
	super();
	this.rua = rua;
	this.numero = numero;
    }
}
```

Conforme se observa, dada uma instância de Endereco não é possível recuperar qual a instância de Pessoa que referencia a data instância de Endereco. A classe Pessoa, por outro lado, está diretamente associada a uma instância de Endereco, conforme abaixo.

```
package quatro;

public class Pessoa {
    private String nome;
    private Endereco endereco;

    // Métodos set/get para endereco omitidos (por simplicidade)

    public Pessoa(String nome, Endereco endereco) {
	this.nome = nome;
        this.endereco = endereco;
    }
	
    public String toString() {
	return nome;
    }
}
```


# Mapeamento #
O mapeamento 1:1 será empregado de forma unidirecional, ou seja, de Pessoa para Endereco. Uma possibilidade é ilustrada abaixo.

```
package quatro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue
    private Long id;
	
    private String nome;

    @OneToOne
    private Endereco endereco;
	
    // Exigido pela JPA
    public Pessoa() {}
	
    public Pessoa(String nome, Endereco endereco) {
	this.nome = nome;
        this.endereco = endereco;
    }
	
    public String toString() {
	return nome;
    }

    // Métodos get/set omitidos para endereco (por simplicidade)
}
```
A anotação **@OneToOne** indica que se tratamente de uma mapeamento 1:1. Existem várias outras formas de mapeamento. A classe Endereco também deverá ser mapeada. Na opção empregada neste exemplo, ambas as classes serão mapeadas em tabelas próprias. A versão atualizada de Endereco com o mapeamento correspondente é fornecida abaixo.

```
package quatro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Endereco {
    @Id
    @GeneratedValue
    private Long id;

    private String rua;
    private int numero;

    // Construtor default é obrigatório (exigência da JPA)
    public Endereco() {}

    public Endereco(String rua, int numero) {
	super();
	this.rua = rua;
	this.numero = numero;
    }
}
```

Não há nenhuma "surpresa" neste mapeamento. Uma instância de Endereco será persistida em sua própria tabela. Observe, novamente, a obrigatoriedade do construtor default, explicitamente fornecido.

# Compilar o código #
```
ant compile
```

# Iniciar o SGBD #
```
ant db-start
```

# Criar o esquema no SGBD #
```
ant schema
```

Também é possível observar, na saída padrão, o esquema correspondente ao mapeamento realizado por meio do alvo **show**, conforme indicado abaixo. Neste caso, nenhuma alteração é efetuada no SGBD, ao contrário do comando anterior.

```
ant show
```

# Abrir cliente do SGBD iniciado #
```
ant db-client
```

# Criar um programa que requisita serviços oferecidos pela JPA API #
Enquanto o conteúdo precedente destaca-se pelo emprego da anotação **@OneToOne**, a aplicação que persiste uma instância de Pessoa e sua respectiva instância de Endereco apresenta diferença digna de nota.

Observe que agora é necessário requisitar a persistência de duas instâncias. Uma de Endereco e outra de Pessoa. Observe ainda que a ordem empregada é obrigatória. Primeiro é persistida a instância Endereco e, em seguida, a instância de Pessoa. Esta ordem rígida decorre do fato do mapeamento ser unidirecional. Uma instância de Pessoa irá referenciar a instância de Endereco correspondente e não o inverso. Se a instância de Endereco não for persistida, então não há como persistir a instância de Pessoa, pois existe uma relação 1:1 rígida de Pessoa para Endereco.

```
package quatro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PessoaAplicacaoJpa {
    public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaQuatro");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
		
        Endereco endereco = new Endereco("Rua das Camélias", 321);
        em.persist(endereco);

	Pessoa pessoa = new Pessoa("Outro nome próprio", endereco);		
	em.persist(pessoa);

	tx.commit();
	em.close();
    }
}

```


# Configurar o persistence provider #
A unidade de persistência é "jpaQuatro" e as classes _quatro.Pessoa_ e _quatro.Endereco_ foram explicitamente indicadas.

```
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://java.sun.com/xml/ns/persistence"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" version="1.0"
	xsi:schemaLocation="http://java.sun.com/xml/ns/persistence
		http://java.sun.com/xml/ns/persistence/persistence_1_0.xsd">

	<persistence-unit name="jpaQuatro">
		<description>
			Exemplo simples de persistência usando JPA. 
		</description>
		
		<provider>org.hibernate.ejb.HibernatePersistence</provider>
		<class>quatro.Pessoa</class>
		<class>quatro.Endereco</class>
		
		<properties>
			<property name="hibernate.archive.autodetetion"	value="class"/>
			
			<property name="hibernate.dialect"
				value="org.hibernate.dialect.HSQLDialect" />
			<property name="hibernate.connection.driver_class"
				value="org.hsqldb.jdbcDriver" />
			<property name="hibernate.connection.username" value="sa" />
			<property name="hibernate.connection.password" value="" />
			<property name="hibernate.connection.url"
				value="jdbc:hsqldb:hsql://localhost/kyrios-teste" />
			<property name="" value="" />
		</properties>
	</persistence-unit>
</persistence>
```

# Compilar o código #
```
ant compile
```

# Executar a aplicação #
```
ant run -Dclasse=quatro.PessoaAplicacaoJpa
```

# Visão geral de todos os artefatos empregados #
Em tempo, todos os artefatos do exemplo podem ser obtidos em http://exemplos.googlecode.com/svn/trunk/ejb3/jpaQuatro/.

# Considerações finais #
A anotação **@OneToOne** foi introduzida em cenário onde duas classes são mapeadas para tabelas distintas. Naturalmente, o exemplo poderia ser mapeado de outras formas. O objetivo foi ilustrar este recurso.

Não deixe de consultar outros exemplos da [série](http://code.google.com/p/exemplos/wiki/ejbPersistence) sobre persistência empregando JPA.