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
