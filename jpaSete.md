### Onde obter ###
http://exemplos.googlecode.com/svn/trunk/ejb3/jpaSete/

Exemplos ([série](http://code.google.com/p/exemplos/wiki/ejbPersistence)): [ANTERIOR](http://code.google.com/p/exemplos/wiki/jpaSeis) e [PRÓXIMO](http://code.google.com/p/exemplos/wiki/jpaOito).

# Introdução #

Como evitar que um campo seja persistido pelo _persistence provider_? Observe a classe Pessoa abaixo e o cenário onde **rua** e **numero** deve ser persistido, enquanto **nome** não deve ser persistido. Provavelmente este não é um cenário real, mas há muitos casos onde não se tem a intenção de persistir determinado campo.

```
public class Pessoa {
    private String nome;
    private String rua;
    private int numero;
	
    public Pessoa(String nome) {
	this.nome = nome;
    }
	
    public String toString() {
	return nome;
    }

    // Métodos get/set para rua e numero omitidos (por simplicidade)
}
```

# Mapear a classe em questão #
A classe Pessoa, mapeada conforme a restrição fornecida acima, é fornecida abaixo.

```
package sete;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue
    private Long id;

    // Propriedades persistidas por padrão (sem anotação)
    private String rua;
    private int numero;

    // Ignora propriedade (não será persistida)
    @Transient
    private String nome;

    public Pessoa() {}

    public Pessoa(String nome, String rua, int numero) {
	this.nome = nome;
	this.rua = rua;
	this.numero = numero;
    }

    public String toString() {
	return nome + " " + rua + " " + numero;
    }
	
    public Long getId() { 
	return id;
    }
}
```

A anotação **@Entity** indica que objetos desta classe podem ser unicamente identificados. Esta identificação é estabelecida pelo campo marcado com a anotação **@Id**. Também foi estabelecido que o valor para este campo será fornecido pelo _persistence provider_, conforme a anotação **@GeneratedValue**.

As propriedades **rua** e **numero** seguem sem anotações. Por padrão, serão persistidas. O mesmo ocorreria com a propriedade **nome** se esta não tivesse sido anotada com **@Transient**. Em conseqüência, quando uma instância de Pessoa for persistida, a propriedade **nome** correspondente não será persistida. Provavelmente este não é o desejado em cenário real, mas fará com que nunca esqueça de que a anotação **@Transient** inibe a persistência de uma propriedade. O programa abaixo atesta este comportamento.

# Programa exemplo #
Uma instância de Pessoa é criada e persistida e, posteriormente, recuperada. Verifique que a instância recuperada não possui um nome, pois este não foi persistido, conforme o valor **null** exibido.

```
package sete;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PessoaAplicacaoJpa {
    public static void main(String[] args) {
	EntityManager em = getEntityManager();
		
	// Inicia transação
	EntityTransaction tx = em.getTransaction();
	tx.begin();
		
	Pessoa pessoa = new Pessoa("João", "Rua X", 15);
	em.persist(pessoa);
	
	tx.commit();
	em.close();		
		
	Long id = pessoa.getId();
	System.out.println("ID gerado: " + id);
		
	// Recupera instância persistida
	em = getEntityManager();		
	Pessoa outraPessoa = (Pessoa) em.find(Pessoa.class, id);
	em.close();
		
	System.out.println(outraPessoa);		
    }

    private static EntityManager getEntityManager() {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaSete");
	return emf.createEntityManager();    
    }
}
```


# Configurar o persistence provider #
A unidade de persistência é identificada por "jpaSete', composta por uma única classe: **sete.Pessoa**.

```
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://java.sun.com/xml/ns/persistence"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" version="1.0"
	xsi:schemaLocation="http://java.sun.com/xml/ns/persistence
		http://java.sun.com/xml/ns/persistence/persistence_1_0.xsd">

	<persistence-unit name="jpaSete">
		<description>
			Exemplo simples de persistência usando JPA. 
		</description>
		
		<provider>org.hibernate.ejb.HibernatePersistence</provider>
		<class>sete.Pessoa</class>
		
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

# Considerações finais #
O padrão é persistir todos os campos/propriedades. Caso alguma propriedade só faça sentido em tempo de execução, então esta pode ser anotada por **@Transient**, indicando que não deverá ser considerada quando instâncias da classe em questão forem persistidas.