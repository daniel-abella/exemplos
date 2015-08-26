### Onde obter ###
http://exemplos.googlecode.com/svn/trunk/ejb3/jpaDois/

Exemplos ([série](http://code.google.com/p/exemplos/wiki/ejbPersistence)): [ANTERIOR](http://code.google.com/p/exemplos/wiki/jpaUm) e [PRÓXIMO](http://code.google.com/p/exemplos/wiki/jpaTres).

# Introdução #

O que é preciso para persistir instâncias de uma classe (como aquela abaixo) usando JPA?

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

Observe que, em relação ao exemplo anterior, foram acrescentadas as propriedades **rua** e **numero**, respectivamente dos tipos _String_ e _int_.

Já sabemos que para persistir objetos de uma determinada classe os seguintes passos são necessários:

  * _Mapear a classe em questão_. Isto significa informar ao _persistence provider_ como cada classe deve ser persistida em uma tabela.
  * _Compilar a classe mapeada_.
  * _Iniciar o SGBD_. Um SGBD deve estar disponível para uso.
  * _Criar o esquema no SGBD_. O mapeamento anteriormente realizado define o esquema a ser empregado pelo _persistence provider_ para persistir um objeto da classe mapeada no SGBD empregado.
  * _Criar um programa que requisita serviços oferecidos pela JPA API_.
  * _Configurar o persistence provider_.
  * _Compilar e executar o programa criado no passo anterior_.

Cada um destes passos é comentado em seção própria abaixo.

# Mapear a classe em questão #
A classe acima, após modificada para conter o mapeamento necessário, é exibida abaixo.

```
package dois;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pessoa {
    @Id @GeneratedValue
    private Long id;
	
    private String nome;
    private String rua;
    private int numero;
	
    public Pessoa() {}
	
    public Pessoa(String nome) {
	this.nome = nome;
    }
	
    public String toString() {
	return nome;
    }

    // Métodos get/set omitidos para rua e numero (por simplicidade)
}
```

Observe que este mapeamento é exatamente o mesmo mapeamento do exemplo [anterior](http://code.google.com/p/exemplos/wiki/jpaUm), onde tínhamos apenas as propriedades **id** e **nome**. Isto ocorre porque, por default, o _persistence provider_ persiste todas as propriedades ou campos para as quais há os métodos get/set correspondentes declarados como **public** ou **protected**. Este fato revela uma característica adotada pelo emprego de JPA: _configuração mínima_. Naturalmente, nem sempre isso será suficiente e, nestes casos, o desenvolvedor deverá intervir. Não é o caso, contudo, para o exemplo.

As únicas anotações empregadas foram as mesmas do exemplo anterior, ou seja, **@Entity**, **@Id** e **@GeneratedValue**. Por conseguinte, não são comentadas novamente.

# Compilar a classe mapeada #
A compilação também não sofre alterações.

```
ant compile
```

# Iniciar o SGBD #
Para iniciar o SGBD precisamos do comando abaixo.

```
ant db-start
```

Convém ressaltar que cada SGBD possui modo próprio para iniciá-lo. O comando acima executa todas as operações necessários para o HSQLDB. Consulte o arquivo **build.xml** para detalhes.

# Criar o esquema no SGBD #

```
ant schema
```

Para verificar a criação do esquema, comando acima, pode ser executado um cliente com acesso à base de dados em questão, conforme abaixo.

```
ant db-client
```


# Criar um programa que requisita serviços oferecidos pela JPA API #
O programa abaixo mantém a mesma simplicidade do exemplo anterior. Contudo, duas linhas foram acrescentadas para fornecer detalhes pertinentes às propriedades **rua** e **numero**.

```
package dois;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PessoaAplicacaoJpa {
    public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaDois");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
		
	Pessoa p = new Pessoa("Outro nome próprio");
        p.setRua("Rua das Camélias");
        p.setNumero(321);
		
	em.persist(p);
	tx.commit();
	em.close();
    }
}

```


# Configurar o persistence provider #
A configuração do _persistence provider_ é modificado em apenas uma informação: o identificador da unidade de persistência. Neste caso, foi substituído o valor anterior "jpaUm" por "jpaDois". Nenhuma outra alteração foi realizada. Observe que exemplos posteriores irão explorar esta configuração em detalhes.

```
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://java.sun.com/xml/ns/persistence"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" version="1.0"
	xsi:schemaLocation="http://java.sun.com/xml/ns/persistence
		http://java.sun.com/xml/ns/persistence/persistence_1_0.xsd">

	<persistence-unit name="jpaDois">
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
ant run -Dclasse=dois.PessoaAplicacaoJpa
```

Após a execução deste comando, uma instância adicional deve estar disponível no SGBD. A execução da consulta `select * from pessoa` por meio de um cliente do SGBD poderá indicar que, de fato, uma instância adicional foi inserida no SGBD.

**Execução a partir do ambiente Eclipse/NetBeans**. Não se esqueça de incluir no _classpath_ o diretório **etc**, pois é no _classpath_ que será procurado o diretório **META-INF**, onde deve estar disponível o arquivo **persistence.xml**, empregado para a configuração do _persistence provider_.

# Visão geral de todos os artefatos empregados #
Em tempo, todos os artefatos do exemplo podem ser obtidos em http://exemplos.googlecode.com/svn/trunk/ejb3/jpaDois/. O conteúdo dos artefatos também é o mesmo, exceto para as mudanças identificadas acima.

# Considerações finais #
O exemplo acima também é simples. O objetivo foi reforçar um processo comum para a persistência empregando JPA, aumentar a familiaridade com as ferramentas empregadas e, especialmente, ressaltar que o emprego de JPA tenta ser tão menos intrusivo quanto possível. Este último item é claro ao observar que o acréscimo de duas novas propriedades não exigiram que o mapeamento fosse alterado. Naturalmente, isto só foi possível porque o padrão oferecido pelo JPA é suficiente, para este caso.

Não deixe de consultar outros exemplos da [série](http://code.google.com/p/exemplos/wiki/ejbPersistence) sobre persistência empregando JPA.