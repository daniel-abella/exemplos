### Onde obter ###
http://exemplos.googlecode.com/svn/trunk/ejb3/jpaTreze/

Exemplos ([série](http://code.google.com/p/exemplos/wiki/ejbPersistence)): [ANTERIOR](http://code.google.com/p/exemplos/wiki/jpaDoze) e [PRÓXIMO](http://code.google.com/p/exemplos/wiki/jpaQuatorze).

# Introdução #
Uma instância de Turma está associada a zero ou mais instâncias de Aluno. Neste exemplo é empregada uma lista para reter as referências para as instâncias de Aluno. A anotação **@OneToMany** estabelece este lado do mapeamento. Observe que a opção **mappedBy** estabelece que é o outro lado da associação o "dono" do relacionamento. Isto decorre porque se trata de um relacionamento bidirecional. Convém ressaltar, não são dois relacionamentos, um de Turma para Aluno e outro de Aluno para Turma, mas um único relacionamento bidirecional entre Turma e Aluno.
package treze;

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

	@OneToMany(mappedBy="turma")
	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	public void adicionaAluno(Aluno novoAluno) {
		alunos.add(novoAluno);
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}
}}}}

A classe Aluno é uma entidade, conforme exibido abaixo e, adicionalmente, possui referência para a turma correspondente. Em particular, dado que não pode existir Aluno sem turma, então a opção *optional* recebeu o valor *false*, conforme pode ser observado abaixo. Por último, deste lado do relacionamento, trata-se de uma relação *@!ManyToOne*. 

{{{
package treze;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Aluno {
	@Id
	@GeneratedValue
	private long id;

	@ManyToOne(optional=false)
	private Turma turma;
	
	private String nome;
	
	public Aluno() {}
	
	public Aluno(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return nome;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
}
}}}

= Programa exemplo =
A aplicação abaixo cria uma nova turma, contendo 10 alunos. Observe que a ordem em que foram persistidos, primeiro a turma e posteriormente os alunos não é arbitrária. Dado que não pode existir uma instância de Aluno sem a correspondente instância de Turma, conforme mapeamento realizado acima, é necessário que exista o registro correspondente de Turma para, em seguida, se criar o registro de um Aluno. 

{{{
package treze;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CriaTurmaAplicacao {

	public static Turma geradorDeTurma() {
		Turma nova = new Turma();
		for (int i = 0; i < 10; i++) {
			Aluno aluno = new Aluno(Integer.toString(i));
			aluno.setTurma(nova);
			nova.adicionaAluno(aluno);
		}
		return nova;
	}

	public static void main(String[] args) {
		Turma turma = geradorDeTurma();

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("jpaTreze");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(turma);
		
		for (Aluno aluno : turma.getAlunos())
			em.persist(aluno);

		tx.commit();
		em.close();
	}
}
}}}

= Considerações finais = 
Uma relação bidirecional 1<->N foi ilustrada. Duas anotações foram empregadas: *@!OneToMany* e *@ManyToOne*. Na primeira anotação foi identificada que esta relação foi mapeada pelo campo "turma" (conforme pode ser observado do mapeamento fornecido acima). No segundo caso, para evitar que uma instância de Aluno pudesse ser persistida sem a turma correspondente, foi empregado o argumento *optional* com o valor *false*, indicando que, necessariamente, deve haver uma instância de Turma persistida para que se possa persistir uma instância de Aluno da qual a instância de Turma pode ser obtida. ```