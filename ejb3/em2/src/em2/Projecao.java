package em2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Projecao {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("em2");
		EntityManager em = emf.createEntityManager();

		List<String> nomes = null;
		nomes = em.createNamedQuery("nomes").getResultList();
		System.out.println(nomes);

		em.close();
		emf.close();
	}
}
