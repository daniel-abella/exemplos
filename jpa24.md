### Onde obter ###
http://exemplos.googlecode.com/svn/trunk/ejb3/jpa24/

Exemplos ([série](http://code.google.com/p/exemplos/wiki/ejbPersistence)): [ANTERIOR](http://code.google.com/p/exemplos/wiki/jpa23) e [PRÓXIMO](http://code.google.com/p/exemplos/wiki/jpa25).
Veja também: [exercício original](http://code.google.com/p/exemplos/wiki/jpaSeis)

# Introdução #
Neste exercício faz-se uso de herança com o mínimo de informação fornecida (anotações).

```
package vintequatro;

public class Pessoa {
    private String nome;

    public Pessoa(String nome) {
	this.nome = nome;
    }
	
    public String toString() {
	return nome;
    }
}
```

Por simplicidade, as classes que herdam de Pessoa, acrescentam um único atributo cada. A classe PessoaFisica, fornecida abaixo, acrescenta atributo correspondente ao CPF da pessoa em questão.

```
package vintequatro;

public class PessoaFisica extends Pessoa {
    private String nome;
    private String cpf;

    public PessoaFisica() {
    }

    public PessoaFisica(String nome, String cpf) {
        super(nome);
        this.cpf = cpf;
    }
	
    public String toString() {
	return super.toString() + " " + cpf;
    }

    // Métodos get/set para cpf foram omitidos (por simplicidade)
}
```

A classe PessoaJuridica acrescenta atributo CNPJ correspondente à empresa em questão.
```
package vintequatro;

public class PessoaJuridica extends Pessoa {
    private String nome;
    private String cnpj;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String nome, String cnpj) {
        super(nome);
        this.cnpj = cnpj;
    }
	
    public String toString() {
	return super.toString() + " " + cnpj;
    }
    
    // Métodos get/set para cnpj foram omitidos (por simplicidade)
}
```

# Mapeamento #
O mapeamento apenas diz que Pessoa e as demais classes são entidades, conforme abaixo. Adicionalmente, a classe Pessoa deixa de ser **abstract**.

```
package vintequatro;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue
    private Long id;
	
    private String nome;

    // Exigido pela JPA
    public Pessoa() {}
	
    public Pessoa(String nome) {
	this.nome = nome;
    }
	
    public String toString() {
	return nome;
    }
}
```

As subclasses, contudo, não acrescentam um **@Id** próprio, conforme abaixo.

```
package vintequatro;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Pessoa {
    private String cpf;

    public PessoaFisica() {
    }

    public PessoaFisica(String nome, String cpf) {
	super(nome);
	this.cpf = cpf;
    }

    public String toString() {
	return super.toString() + " " + cpf;
    }
}
```

Observe que PessoaJuridica também não acrescenta **@Id** e apenas é anotada como **@Entity**.

```
package vintequatro;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends Pessoa {
    private String cnpj;

    public PessoaJuridica() {
    }
	
    public PessoaJuridica(String nome, String cnpj) {
	super(nome);
	this.cnpj = cnpj;
    }
	
    public String toString() {
	return super.toString() + " " + cnpj;
    }
}
```

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
O programa abaixo cria duas instâncias de Endereco e associa ambas a uma única instância de Pessoa. Após requisitar a persistência explícita de ambas as instâncias de Endereco, a instância de Pessoa é persistida.

```
package cinco;

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
		
	Pessoa pessoa = new PessoaFisica("João da Silva", "0123");
	em.persist(pessoa);
		
	pessoa = new PessoaJuridica("Empresa X", "3210");
	em.persist(pessoa);

        pessoa = new Pessoa("Teste");
        em.persist(pessoa);

	tx.commit();
	em.close();
    }
}

```


# Configurar o persistence provider #
A unidade de persistência é "jpaCinco" e as classes _cinco.Pessoa_ e _cinco.Endereco_ foram explicitamente indicadas.

```
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://java.sun.com/xml/ns/persistence"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" version="1.0"
	xsi:schemaLocation="http://java.sun.com/xml/ns/persistence
		http://java.sun.com/xml/ns/persistence/persistence_1_0.xsd">

	<persistence-unit name="jpaSeis">
		<description>
			Exemplo simples de persistência usando JPA. 
		</description>
		
		<provider>org.hibernate.ejb.HibernatePersistence</provider>
		<class>seis.PessoaFisica</class>
		<class>seis.PessoaJuridica</class>
		
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
ant run -Dclasse=seis.PessoaAplicacaoJpa
```

# Visão geral de todos os artefatos empregados #
Em tempo, todos os artefatos do exemplo podem ser obtidos em http://exemplos.googlecode.com/svn/trunk/ejb3/jpaCinco/.

# Considerações finais #
Várias anotações foram exercitadas. Em particular, **@Entity**, **@Inheritance**, **@DiscriminatorColumn**, **@DiscriminatorValue**. Em particular, as duas últimas trabalham em sintonia. Enquanto uma estabelece qual coluna irá discernir o tipo de um objeto armazenado, a outra estabelece o valor correspondente. Esta não é, contudo, a única forma de usufruir de persistência de classe derivada.

O objetivo desta série de exercícios foi fornecer a ambientação suficiente para que outros tópicos de JPA possam ser observados em profundidade sem ter que fornecer uma extensa documentação pertinente. Caso não se sinta confortável, sugere-se uma revisão dos exercícios oferecidos.

Não deixe de consultar outros exemplos da [série](http://code.google.com/p/exemplos/wiki/ejbPersistence) sobre persistência empregando JPA.