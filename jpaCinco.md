### Onde obter ###
http://exemplos.googlecode.com/svn/trunk/ejb3/jpaCinco/

Exemplos ([série](http://code.google.com/p/exemplos/wiki/ejbPersistence)): [ANTERIOR](http://code.google.com/p/exemplos/wiki/jpaQuatro) e [PRÓXIMO](http://code.google.com/p/exemplos/wiki/jpaSeis).

# Introdução #
Neste cenário uma instância de Pessoa poderá estar relacionada com zero ou mais instâncias de Endereco. O objetivo é ilustrar o relacionamento, por mais estranho que possa parecer uma pessoa estar associada a zero ou mais endereços.

A classe Pessoa é ilustrada abaixo.

```
package cinco;

import java.util.List;
import java.util.ArrayList;

public class Pessoa {
    private String nome;
    private List<Endereco> enderecos;

    // Métodos set/get para endereco omitidos (por simplicidade)

    public adicionaEndereco(Endereco endereco) {
        enderecos.add(endereco);
    }

    public Pessoa(String nome, Endereco endereco) {
	this.nome = nome;
        this.enderecos = new ArrayList<Endereco>();
        enderecos.add(endereco);
    }
	
    public String toString() {
	return nome;
    }
}
```


# Mapeamento #
```
package cinco;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue
    private Long id;
	
    private String nome;

    @OneToMany
    private List<Endereco> enderecos;
	
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

    public adicionaEndereco(Endereco endereco) {
        enderecos.add(endereco);
    }
}
```

A anotação **@OneToMany** indica que **enderecos** é uma coleção. Dada um objeto Pessoa, várias instâncias de Endereco poderão estar associadas por meio desta coleção. Nada mais é necessário. O mapeamento de Endereco é o mesmo do exemplo anterior e não será aqui repetido.

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
		
        Endereco end1 = new Endereco("Rua 1", 1);
        em.persist(end1);

        Endereco end2 = new Endereco("Rua 2", 2);
        em.persist(end2);

	Pessoa pessoa = new Pessoa("Outro nome próprio", end1);
        pessoa.adicionaEndereco(end2);		
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

	<persistence-unit name="jpaCinco">
		<description>
			Exemplo simples de persistência usando JPA. 
		</description>
		
		<provider>org.hibernate.ejb.HibernatePersistence</provider>
		<class>cinco.Pessoa</class>
		<class>cinco.Endereco</class>
		
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
ant run -Dclasse=cinco.PessoaAplicacaoJpa
```

# Visão geral de todos os artefatos empregados #
Em tempo, todos os artefatos do exemplo podem ser obtidos em http://exemplos.googlecode.com/svn/trunk/ejb3/jpaCinco/.

# Considerações finais #
A anotação **@OneToMany** foi introduzida em cenário onde duas classes são mapeadas para tabelas distintas.

Não deixe de consultar outros exemplos da [série](http://code.google.com/p/exemplos/wiki/ejbPersistence) sobre persistência empregando JPA.