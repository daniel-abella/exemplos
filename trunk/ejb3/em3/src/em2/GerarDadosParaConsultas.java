package em2;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class GerarDadosParaConsultas {
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
				.createEntityManagerFactory("em2");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		for (Aluno aluno : alunos)
			em.persist(aluno);
		
		em.persist(new Aluno(""));
		em.persist(new Aluno());

		for (Curso curso : cursos)
			em.persist(curso);

		tx.commit();
		em.close();
	}
}
