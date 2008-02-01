package em3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class QueryAplicacao {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("em2");
		EntityManager em = emf.createEntityManager();

		List<Aluno> min = em.createNamedQuery("min").getResultList();
		System.out.println("min: " + min);

		List<Aluno> count = em.createNamedQuery("count").getResultList();
		System.out.println("count: " + count);

		List<Aluno> max = em.createNamedQuery("max").getResultList();
		System.out.println("max: " + max);

		em.close();
	}
}
