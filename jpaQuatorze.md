### Onde obter ###
http://exemplos.googlecode.com/svn/trunk/ejb3/jpaQuatorze/

Exemplos ([série](http://code.google.com/p/exemplos/wiki/ejbPersistence)): [ANTERIOR](http://code.google.com/p/exemplos/wiki/jpaTreze) e
[PRóXIMO](http://code.google.com/p/exemplos/wiki/jpaQuinze).

# Introdução #
Neste exemplo, uma instância de Curso pode estar associada a várias instâncias de Aluno (ou seja, alunos matriculados no curso em questão). Em outro sentido, cada instância de Aluno pode estar matriculada em vários cursos (várias instâncias de Curso). Este relacionamento é bidirecional. O mapeamento destas duas classes segue abaixo.

```
package quatorze;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Aluno {
	@Id
	@GeneratedValue
	private long id;

	@ManyToMany
	private Set<Curso> cursos = new HashSet<Curso>();
	
	private String nome;
	
	public Aluno() {}
	
	public Aluno(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return nome;
	}
	
	public void adicionaCurso(Curso curso) {
		cursos.add(curso);
	}
}
```

A classe Curso é mapeada de forma similar, empregando a anotação **@ManyToMany**.
Observe, contudo, que dado o fato do relacionamento ser bidirecional, ou Aluno ou Curso, neste caso Curso, deve indicar quem é o "dono" do relacionamento. Isto é feito pelo valor **cursos** ao atributo **mappedBy** da anotação **@ManyToMany**, conforme pode ser observado abaixo.

```
package quatorze;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Curso {
	@Id
	@GeneratedValue
	private long id;
	
	private int codigo;

	@ManyToMany(mappedBy="cursos")
	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	public void adicionaAluno(Aluno novoAluno) {
		alunos.add(novoAluno);
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}
	
	public Curso() {}
	
	public Curso(int codigo) {
		this.codigo = codigo;
	}
}
```

# Programa exemplo #
A aplicação cria dez instâncias de Curso e dez instâncias de Aluno. Posteriormente, "matricula" cada um dos alunos em cada um dos dez cursos. Isto resulta em cem (100) relacionamentos, pois cada curso possui 10 alunos e tem-se 10 cursos.

```
package quatorze;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CriaMatriculasAplicacao {
	private static Set<Aluno> alunos = new HashSet<Aluno>();;
	private static Set<Curso> cursos = new HashSet<Curso>();
	
	public static void matricula10x10() {
		for (int i = 0; i < 10; i++) {
			alunos.add(new Aluno("Aluno " + i));
			cursos.add(new Curso(i));
		}
		
		for (Aluno aluno : alunos)
			for (Curso curso : cursos) {
				aluno.adicionaCurso(curso);
				curso.adicionaAluno(aluno);
			}
	}

	public static void main(String[] args) {
		matricula10x10();

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("jpaQuatorze");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		for (Aluno aluno : alunos)
			em.persist(aluno);
		
		for (Curso curso : cursos)
			em.persist(curso);

		tx.commit();
		em.close();
	}
}
```

# Considerações finais #
A anotação **@ManyToMany** foi empregada para o mapeamento de Curso para Aluno e desta última classe para a primeira. Observe que este relacionamento é bidirecional.