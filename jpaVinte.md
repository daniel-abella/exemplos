### Onde obter ###
http://exemplos.googlecode.com/svn/trunk/ejb3/jpaVinte/

Exemplos ([série](http://code.google.com/p/exemplos/wiki/ejbPersistence)): [ANTERIOR](http://code.google.com/p/exemplos/wiki/jpaDezenove) e [PRÓXIMO](http://code.google.com/p/exemplos/wiki/jpaVinteUm).

# Introdução #
Há várias variações quanto à geração de chaves (_surrogate keys_). O código abaixo ilustra boa parte das opções disponíveis.

```
package vinte;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
class Surrogate1 {
	// Chave não é gerada automaticamente pelo persistence provider
	@Id
	private long id;
	
	public Surrogate1() {
		id = (long) (Math.random() * 1000 * 1000 * 1000);
	}
}

@Entity
class Surrogate2 {
	// Chave gerada pelo persistence provider
	@Id
	@GeneratedValue
	private long id;
}

@Entity
class Surrogate3 {
	// Chave gerada pelo persistence provider (identity column)
	// Argumento fornecido é o padrão (opcional)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
}

@Entity
class Surrogate4 {
	// Em muitos casos, semelhante a GenerationType.IDENTITY
	// Persistence provider identifica a melhor estratégia
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
}

@Entity
class Surrogate5 {
	// Usa gerador de seqüência
	// Caso não dito o contrário, um único gerador é
	// compartilhado por todas as entidades.
	// Por padrão, salta de 10 em 10
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
}

@Entity
class Surrogate6 {
	// Emprega o mesmo gerador de seqüência da entidade acima
	// Ao inserir uma instância, o próximo número da seqüência é empregado
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
}

// Usa gerador de seqüência "próprio", salta de 7 em 7
@SequenceGenerator(name = "GERADOR_SEQUENCIA", sequenceName = "CHAVE", initialValue = 1, allocationSize = 7)
@Entity
class Surrogate7 {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GERADOR_SEQUENCIA")
	private long id;
}

// Usa o mesmo gerador da entidade acima, mas salta de 9 em 9
@SequenceGenerator(name = "GERADOR_SEQUENCIA", sequenceName = "CHAVE", initialValue = 1, allocationSize = 9)
@Entity
class Surrogate8 {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GERADOR_SEQUENCIA")
	private long id;
}
```

Para exercitar a classe acima, faça uso do programa abaixo.

```
package vinte;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ChaveAplicacao {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("jpaVinte");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(new Surrogate1());
		em.persist(new Surrogate2());
		em.persist(new Surrogate3());
		em.persist(new Surrogate4());
		em.persist(new Surrogate5());
		em.persist(new Surrogate6());
		em.persist(new Surrogate7());
		em.persist(new Surrogate8());

		tx.commit();
		em.close();

	}
}
```