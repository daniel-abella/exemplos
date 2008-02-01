package dbunit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsereAlunosAplicacao {

	public static Turma geradorDeTurma() {
		Turma nova = new Turma();
		nova.setCodigo(5.54);
		for (int i = 0; i < 10; i++) {
			nova.adicionaAluno(new Aluno(i, "aluno " + i));
		}
		return nova;
	}

	public static void main(String[] args) {
		Turma turma = geradorDeTurma();

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("dbunit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		String apelidos[] = { "Goiano", "Mineiro", "Baiano" };
		double turmasCursadas[] = { 3.43, 4, 5.6 };

		for (Aluno aluno : turma.getAlunos()) {
			aluno.setEndereco(new Endereco("Rua dos Eucalipstos", "74118-090",
					"34"));
			aluno.setTurmasCursadas(turmasCursadas);
			aluno.setApelidos(apelidos);
			em.persist(aluno);
			Premio premio = new Premio("Ótimo trabalho sobre DbUnit", aluno);
			em.persist(premio);
		}

		em.persist(turma);

		tx.commit();
		em.close();
	}
}
