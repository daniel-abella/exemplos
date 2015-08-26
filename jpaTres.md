### Onde obter ###
http://exemplos.googlecode.com/svn/trunk/ejb3/jpaTres/

Exemplos ([série](http://code.google.com/p/exemplos/wiki/ejbPersistence)): [ANTERIOR](http://code.google.com/p/exemplos/wiki/jpaDois) e [PRÓXIMO](http://code.google.com/p/exemplos/wiki/jpaQuatro).

# Introdução #

Em exemplo anterior, as informações pertinentes ao endereço de uma pessoa eram fornecidos na própria classe Pessoa. Para um cenário simples aquele modelo pode ser suficiente. Atualmente, contudo, endereço por si só já representa complexidade e questões que merecem uma classe específica, conforme aquela abaixo. Observe que foram fornecidos apenas duas únicas propriedades, contudo, agora, um modelo bem mais complexo de endereço contendo estado, cep e outras informações pode ser desenvolvido sem comprometer a coesão da classe Pessoa.

```
package tres;

public class Endereco {
    private String rua;
    private int numero;
	
    // Construtor default é obrigatório
    public Endereco() {}
	
    public Endereco(String rua, int numero) {
	super();
	this.rua = rua;
	this.numero = numero;
    }
}
```

O acréscimo da classe Endereco permite definir a classe Pessoa conforme abaixo. Note que endereço agora é obtido por meio de uma referência para a classe acima.

```
package tres;

public class Pessoa {
    private Long id;
    private String nome;
    private Endereco endereco;

    // Métodos set/get para endereco omitidos (por simplicidade)

    public Pessoa() {}

    public Pessoa(String nome, Endereco endereco) {
	this.nome = nome;
        this.endereco = endereco;
    }
	
    public String toString() {
	return nome;
    }
}
```

Conforme as classes acima, uma instância de Pessoa faz uso de um referência para uma instância de Endereco. Neste caso, como será realizado o mapeamento que dirá, ao _persistence provider_, como persistir instâncias de Pessoa?

# Mapear a classe em questão #
A única mudança na classe Endereco é a anotação **@Embeddable**. Isto indica que instâncias de Endereco não precisam ser identificadas unicamente. Ou seja, Endereco não é tratada como uma entidade (existe apenas como objeto embutido em outros). A classe segue abaixo.

```
package tres;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
    private String rua;
    private int numero;
	
    // Construtor default é obrigatório
    public Endereco() {}
	
    public Endereco(String rua, int numero) {
	super();
	this.rua = rua;
	this.numero = numero;
    }
}
```

A classe Pessoa, após modificada para conter o mapeamento necessário, é exibida abaixo.

```
package tres;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pessoa {
    @Id @GeneratedValue
    private Long id;
	
    private String nome;

    @Embedded
    private Endereco endereco;
	
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

As anotações **@Entity**, **@Id** e **@GeneratedValue** já são conhecidas. Respectivamente, estabelece que se trata de uma entidade (exige a criação de uma tabela correspondente), indica qual a propriedade a ser empregada como chave e, por último, o mecanismo empregado para a geração das chaves (neste caso, a geração das chaves será realizada pelo _persistence provider_). O que tem de novo? A anotação **@Embedded**.

A anotação **@Embedded** indica que os atributos da propriedade indicada deverão ser registrados na mesma tabela da entidade em questão. Ou seja, neste caso, os atributos da classe Endereco deverão ser registrados na mesma tabela que irá persistir instâncias de Pessoa. Não haverá, portanto, uma tabela para armazenar instâncias de Endereco, que nem mesmo possui um identificador único, conforme pode ser observado.

# Compilar a classe mapeada #
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

Para verificar a criação do esquema, comando acima, pode ser executado um cliente com acesso à base de dados em questão, conforme abaixo.

```
ant db-client
```


# Criar um programa que requisita serviços oferecidos pela JPA API #
O código abaixo cria uma transação no interior da qual uma instância de Endereco é associada à instância de Pessoa. Logo em seguida é requisitada a persistência da instância de Pessoa. Se executado de forma satisfatória, o programa abaixo insere um registro na tabela Pessoa no SGBD empregado.

```
package dois;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PessoaAplicacaoJpa {
    public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaTres");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
		
        Endereco endereco = new Endereco("Rua das Camélias", 321);
	Pessoa p = new Pessoa("Outro nome próprio", endereco);
		
	em.persist(p);
	tx.commit();
	em.close();
    }
}

```


# Configurar o persistence provider #
À semelhança dos exemplos anteriores, a única alteração é o nome da unidade de persistência. Para este exemplo é empregado "jpaTres".

```
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://java.sun.com/xml/ns/persistence"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" version="1.0"
	xsi:schemaLocation="http://java.sun.com/xml/ns/persistence
		http://java.sun.com/xml/ns/persistence/persistence_1_0.xsd">

	<persistence-unit name="jpaTres">
		<description>
			Exemplo simples de persistência usando JPA. 
		</description>
		
		<provider>org.hibernate.ejb.HibernatePersistence</provider>
		<class>um.Pessoa</class>
		
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

# Compilar e executar o programa criado no passo anterior #

```
ant compile
```

O comando para a execução da classe que usufrui da API também é a mesma:

```
ant run -Dclasse=tres.PessoaAplicacaoJpa
```

# Visão geral de todos os artefatos empregados #
Em tempo, todos os artefatos do exemplo podem ser obtidos em http://exemplos.googlecode.com/svn/trunk/ejb3/jpaTres/.

# Considerações finais #
A persistência empregando JPA é facilitada de várias formas. Até agora, por exemplo, não foi exigido do programador o conhecimento de SQL, por exemplo. Também deve ser acrescentado que o programador também não teve o laborioso esforço de mapear propriedades de um objeto em colunas de uma tabela. Tudo isto foi realizado pelo _persistence provider_. Neste exemplo, novamente, foi empregado o Hibernate, embora existam vários outros.

A diferença deste exemplo para os anteriores está na forma de mapear a referência **endereco** na classe Pessoa. Neste caso, as propriedades de um objeto de Endereco foram embutidos na mesma tabela empregada para registrar demais propriedades de uma Pessoa. Isto é mapeado pelo emprego da anotação **@Embedded**, conforme ilustrado.

Não deixe de consultar outros exemplos da [série](http://code.google.com/p/exemplos/wiki/ejbPersistence) sobre persistência empregando JPA.