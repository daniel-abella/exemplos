package em1;

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
