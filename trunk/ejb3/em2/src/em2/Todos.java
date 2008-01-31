package em2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Todos {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("em2");
		EntityManager em = emf.createEntityManager();

		List<Aluno> alunos = null;
		alunos = em.createNamedQuery("todos").getResultList();
		System.out.println(alunos);

		em.close();
		emf.close();
	}
}
