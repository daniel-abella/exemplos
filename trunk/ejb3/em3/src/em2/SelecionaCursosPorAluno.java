package em2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SelecionaCursosPorAluno {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("em2");
		EntityManager em = emf.createEntityManager();

		Query jpql = em.createNamedQuery("porAluno");
		jpql.setParameter("matricula", 1L);

		List<Curso> cursos = (List<Curso>) jpql.getResultList();
		System.out.println(cursos);

		em.close();
		emf.close();
	}
}
