### Onde obter ###
http://exemplos.googlecode.com/svn/trunk/ejb3/jpaUm/

Exemplos ([série](http://code.google.com/p/exemplos/wiki/ejbPersistence)): [ANTERIOR](http://code.google.com/p/exemplos/wiki/jpa\ero) e [PRÓXIMO](http://code.google.com/p/exemplos/wiki/jpaDois).

# Introdução #

O que é preciso para persistir instâncias de uma classe (como aquela abaixo) usando a JPA?

```
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


# Resumo de atividades para persistir instâncias de uma classe #
  * _Mapear a classe em questão_. Isto significa informar ao _persistence provider_ como cada classe deve ser persistida em uma tabela.
  * _Compilar a classe mapeada_.
  * _Iniciar o SGBD_. Um SGBD deve estar disponível para uso.
  * _Criar o esquema no SGBD_. O mapeamento anteriormente realizado define o esquema a ser empregado pelo _persistence provider_ para persistir um objeto da classe mapeada no SGBD empregado.
  * _Criar um programa que requisita serviços oferecidos pela JPA API_.
  * _Configurar o persistence provider_.
  * _Compilar e executar o programa criado no passo anterior_.

Cada um destes passos é comentado em seção própria abaixo.

### Mapear a classe em questão ###
A classe anterior, após modificada para conter o mapeamento necessário, é exibida abaixo.

```
package um;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pessoa {
    @Id @GeneratedValue
    private Long id;
	
    private String nome;
	
    public Pessoa() {}
	
    public Pessoa(String nome) {
	this.nome = nome;
    }
	
    public String toString() {
	return nome;
    }
}
```

Várias são as diferenças entre a classe modificada acima (empregando JPA) e a anterior. Tais diferenças estão no emprego de anotações.

A anotação **@Entity** é empregada para indicar que a classe em questão é uma entidade (_EJB entity_). **@Id** e **@GeneratedValue** indicam que a propriedade em questão, **id**, será empregada como chave na tabela onde instâncias da classe Pessoa forem persistidas. Em particular, o valor desta chave será automaticamente gerado (**@GeneratedValue**). A outra diferença é a existência do construtor padrão (sem argumentos). Este construtor é obrigatório. Tal construtor será empregado pelo _persistence provider_ para a criação de instâncias que forem recuperadas do SGBD.

Para este simples exemplo, as poucas modificações comentadas acima são suficientes.

### Compilar a classe mapeada ###
Convém ressaltar que várias bibliotecas são necessárias para a compilação do código acima. Por exemplo, a anotação _javax.persistence.Entity_ é fornecida no arquivo **ejb3-persistence.jar**. Este arquivo jar é fornecido pelo Hibernate (_persistence provider_ empregado nestes exemplos). Em particular, o que é conhecido por Hibernate Annotations inclui este arquivo jar. Execute o alvo abaixo

```
ant compile
```

na linha de comandos. Se o arquivo **build.xml** estiver devidamente configurado para as bibliotecas necessárias, a compilação será executada sem problemas.

### Iniciar o SGBD ###
É preciso ter um SGBD disponível para persistir objetos. Neste caso é empregado o HSQLDB. Para iniciá-lo, na linha de comandos, execute

```
ant db-start
```

Este comando deve ser executado do diretório onde se encontra o arquivo **build.xml**. Este arquivo é fornecido juntamente com todos os demais necessários para a execução deste exemplo no link fornecido no início desta página.

Não há nenhum passo de mágica. Embora o HSQLDB seja simples, várias operações estão encapsuladas no comando acima. Caso empregue outro SGBD, lembre-se de que, além de simplesmente iniciar o SGBD, uma base de dados terá que ser criada, um usuário com a devida permissão e eventualmente outras operações. Administração de um SGBD, contudo, está bem além do escopo deste exemplo.

### Criar o esquema no SGBD ###
Novamente será empregada a ferramenta Ant e a configuração fornecida no arquivo **build.xml**. O comando a ser executado é

```
ant schema
```

Isto criará o esquema obtido do mapeamento anteriormente realizado. Após esta operação, o esquema encontra-se disponível no SGBD (na base também criada no passo anterior). O comando acima, portanto, encapsula duas operações principais: a definição do esquema a partir do mapeamento realizado e, posteriormente, a criação deste esquema na base de dados criada no SGBD. Novamente, há muitos detalhes omitidos, mas que não comprometem o entendimento do processo.

Você poderá verificar se esta operação foi realizada satisfatoriamente por meio de um cliente do SGBD. Para tal, neste exemplo, basta executar o comando abaixo

```
ant db-client
```

Este comando iniciará o cliente padrão do HSQLDB já para a base também criada. Em um outro SGBD, após iniciar o cliente, será necessário localizar a base de interesse e efetuar a conexão correspondente, onde provavelmente será requisitado um usuário devidamente autorizado. Novamente, todas estas ações foram realizadas pelo comando acima, embora afastadas da visão do usuário.

### Criar um programa que requisita serviços oferecidos pela JPA API ###

O programa abaixo faz uso da JPA API. É por meio desta API que aplicações em Java se comunicam com o _persistence provider_ para requisitar, explicitamente, a criação, recuperação, remoção e outros serviços de persistência.

```
package um;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PessoaAplicacaoJpa {
    public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaUm");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
		
	Pessoa p = new Pessoa("Pedro Silva Souza da Silva");
		
	em.persist(p);
	tx.commit();
	em.close();
    }
}

```

No exemplo acima é fornecido o mínimo para requisitar o acesso a um gerenciador de entidades (_persistence provider_) e a criação de uma transação no interior da qual uma instância da classe Pessoa é persistida. Observe que não há, da perspectiva deste código, nenhuma dependência de um _persistence provider_ específico. Por exemplo, não há nenhuma dependência para o Hibernate (ferramenta empregada). A configuração de qual ferramenta será empregada é fornecida no arquivo **persistence.xml**, contido no diretório **META-INF**.

### Configurar o persistence provider ###
Se o programa acima for simplesmente executado, nenhum resultado satisfatório poderá ser observado. Conforme comentado acima, é preciso configurar o _persistence provider_ a ser empregado, pois o programa acima é independente de quem de fato executará os serviços requisitados.

A configuração é fornecida na forma de um documento XML, **persistence.xml**, necessariamente com este nome e localizado no diretório **META-INF**. Por meio deste arquivo várias informações são fornecidas, inclusive o nome da unidade de persistência, neste caso, **jpaUm**. Observe que este identificador é exatamente aquele fornecido ao método _Persistence.createEntityManagerFactory()_. Abaixo segue o arquivo **persistence.xml** para este exemplo, contendo várias outras informações além do nome da unidade de persistência "irrelevantes" para os propósitos deste exemplo.

```
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://java.sun.com/xml/ns/persistence"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" version="1.0"
	xsi:schemaLocation="http://java.sun.com/xml/ns/persistence
		http://java.sun.com/xml/ns/persistence/persistence_1_0.xsd">

	<persistence-unit name="jpaUm">
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

### Compilar e executar o programa criado no passo anterior ###
A compilação foi indicada acima e o comando é repetido abaixo.

```
ant compile
```

Tanto a compilação (acima) quanto a execução (abaixo) exigem a correta configuração de propriedades fornecidas no arquivo **build.xml**. Para execução encontra-se disponível o alvo **run**. A classe a ser executada é fornecida pelo argumento **classe**. A execução da classe fornecida acima exige o seguinte comando:

```
ant run -Dclasse=um.PessoaAplicacaoJpa
```

Após a execução deste comando, uma instância adicional deve estar disponível no SGBD. A execução da consulta **select _from pessoa_ por meio de um cliente do SGBD poderá indicar que, de fato, uma instância adicional foi inserida no SGBD.**

**Execução a partir do ambiente Eclipse**. Caso execute o programa acima de um ambiente como o Eclipse, certifique-se de acrescentar ao classpath do comando de execução o diretório **etc**. É neste diretório que a unidade de persistência **jpaUm** está definida. Lembre-se que esta configuração é fornecida pelo arquivo **persistence.xml**, fornecido no diretório **META-INF**. É o diretório **META-INF** que deve estar no classpath para a execução satisfatória. Neste caso, o classpath deverá conter o diretório **etc**.

# Visão geral de todos os artefatos empregados #
Em tempo, todos os artefatos do exemplo podem ser obtidos em http://exemplos.googlecode.com/svn/trunk/ejb3/jpaUm/. Incluem:

  * _persistence.xml_. Arquivo de configuração do fornecedor de persistência. Neste exemplo foi empregado o Hibernate.
  * _build.xml_. Arquivo empregado pela ferramenta Ant para a execução de várias atividades repetitivas, por exemplo, iniciar SGBD, iniciar cliente do SGBD, compilar e outras.
  * _leiame.txt_. Breve descrição do exemplo.
  * _etc_. Diretório contendo o diretório _META-INF_ e configuração de log para uso do Log4j. O diretório _META-INF_ é empregado para conter arquivos próprios para a configuração de soluções que fazem uso de JPA. O arquivo _persistence.xml_ é fornecido no diretório _META-INF_.
  * _src_. Diretório contendo fontes do exemplo.
  * _test_. Diretório contendo fontes de testes para o exemplo. Neste caso, não há testes e, portanto, este diretório encontra-se vazio.
  * _Configuração de projeto Eclipse_ (.project e .classpath). Projeto Eclipse correspondente ao exemplo.

# Considerações finais #
O exemplo acima é simples. Os objetivos incluem: (a) fornecer uma visão geral do processo envolvido no emprego de JPA; (b) verificar a instalação/configuração de ferramentas necessárias para o emprego da JPA usando o Hibernate e (c) ambientação inicial com tais ferramentas.

Não deixe de consultar outros exemplos da [série](http://code.google.com/p/exemplos/wiki/ejbPersistence) sobre persistência empregando JPA.