### Onde obter ###
http://exemplos.googlecode.com/svn/trunk/ejb3/jpaQuinze/

Exemplos ([série](http://code.google.com/p/exemplos/wiki/ejbPersistence)): [ANTERIOR](http://code.google.com/p/exemplos/wiki/jpaQuatorze) e [PRÓXIMO](http://code.google.com/p/exemplos/wiki/jpaDezesseis).

# Introdução #
O mapeamento de uma entidade possui algumas flexibilidades quanto aos recursos disponibilizados para caracterizar questões pertinentes à tabela a ser empregada. Observe o mapeamento abaixo.

```
package quinze;

import javax.persistence.Entity;

@Entity
class A {
	@Id
	@GeneratedValue
	private int chave;
}

@Entity
@Table(name="NOME_DA_TABELA_PARA_OBJETOS_B")
class B {
	@Id
	@GeneratedValue
	private int chave;
}

@Entity
@Table(catalog="CATALOGO")
class C {
	@Id
	@GeneratedValue
	private int chave;
}

@Entity
@Table(schema="ESQUEMA")
class D {
	@Id
	@GeneratedValue
	private int chave;
}

@Entity
@Table(schema="ESQUEMA", catalog="CATALOGO")
class E {
	@Id
	@GeneratedValue
	private int chave;
}

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"nome", "cpf"})})
class F {
	@Id
	@GeneratedValue
	private long chave;
	
	public String nome;
	public String cpf;
}
```

A classe A é mapeada sem o emprego da anotação **@Table**. Em boa parte dos casos, todo o comportamento resultante é suficiente.

A classe B já emprega a anotação **@Table** para identificar a tabela em que instâncias de B serão registradas.

As classes C, D e E apresentam uma forma pouco usual de "classificar" tabelas, que podem estar divididas em esquemas e estas, por sua vez, agrupadas em catálogos.

Por fim, a classe F exibe como restrições de unicidade podem ser estabelecidas para uma tabela envolvendo um subconjundo dos atributos do objeto a ser persistido.

Embora todas estas opções sejam válidas, as classes C, D, E e F apresentam mapeamentos pouco usuais. Em particular, convém ressaltar que não é mandatório que implementações de EJB3 ofereçam suporte à geração de tabelas. Neste caso, tais anotações poderiam ter pouco efeito.

# persistence.xml #
Observe neste exemplo que todas as classes fazem parte de um único arquivo, **Tabelas.java**, o que não é nenhum erro, embora não usual nem mesmo recomendado. Também observe que nenhuma das classes é **public**. Na descrição da unidade de persistência, **persistence.xml**, as classes **quinze.A**, **quinze.B** e assim por diante foram explicitamente fornecidas.

# Aplicação #
A aplicação abaixo funciona apenas em uma primeira execução. A partir da segunda execução, exceção é gerada pelo fato da restrição de unicidade, fornecida na classe F, não ser respeitada.

```
package quinze;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ExercitaTabelas {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaQuinze");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(new A());
		em.persist(new B());
		em.persist(new C());
		em.persist(new D());

		F f = new F();
		f.nome = "A";
		f.cpf = "123";
		
		// A chamada abaixo só funciona em sua primeira execução.
		// Posteriores geram exceção, pois não satisfaz restrição
		// de unicidade envolvendo "nome" e "cpf" (veja mapeamento)
		em.persist(f);
			
		tx.commit();
		em.close();
	}
}
```