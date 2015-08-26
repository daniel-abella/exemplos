### Onde obter ###
http://exemplos.googlecode.com/svn/trunk/ejb3/jpaDoze/

Exemplos ([série](http://code.google.com/p/exemplos/wiki/ejbPersistence)): [ANTERIOR](http://code.google.com/p/exemplos/wiki/jpaOnze) e [PRÓXIMO](http://code.google.com/p/exemplos/wiki/jpaTreze).

# Introdução #
Uma instância de Turma está associada a zero ou mais instâncias de Aluno. Neste exemplo é empregada uma lista para reter as referências para as instâncias de Aluno. Observe, adicionalmente, a anotação **@OneToMany**, que estabelece o mapeamento desejado.

```
package doze;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Turma {
	@Id
	@GeneratedValue
	private long id;

	@OneToMany
	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	public void adicionaAluno(Aluno novoAluno) {
		alunos.add(novoAluno);
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}
}
```

A classe Aluno é uma entidade. É esperado que tal entidade participe de várias outras associações.

```
package doze;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Aluno {
	@Id
	@GeneratedValue
	private long id;

	private String nome;
	
	public Aluno() {}
	
	public Aluno(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return nome;
	}
}
```

# Programa exemplo #
A aplicação abaixo cria uma instância de Turma com dez alunos associados por meio de método específico. Posteriormente, cada uma das instâncias de Aluno é explicitamente persistida, seguida da persistência da instância de Turma.

```
package doze;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsereAlunosAplicacao {

	public static Turma geradorDeTurma() {
		Turma nova = new Turma();
		for (int i = 0; i < 10; i++) 
			nova.adicionaAluno(new Aluno(Integer.toString(i)));
		return nova;
	}

	public static void main(String[] args) {
		Turma turma = geradorDeTurma();
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("jpaDoze");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		for (Aluno aluno : turma.getAlunos())
			em.persist(aluno);
		
		em.persist(turma);
		
		tx.commit();
		em.close();
	}
}
```

# Considerações finais #
O mapeamento **@OneToMany** é um dos mapeamentos mais empregados, principalmente em conjunto com o mapeamento **@ManyToOne**. Convém ressaltar que de um relacionamento bidirecional de 1

&lt;-&gt;

N tem-se dois mapeamentos: **@OneToMany** e **@ManyToOne**.