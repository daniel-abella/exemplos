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
