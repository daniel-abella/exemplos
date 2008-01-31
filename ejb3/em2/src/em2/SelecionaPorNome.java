package em2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SelecionaPorNome {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("em2");
		EntityManager em = emf.createEntityManager();

		Query jpql = em.createNamedQuery("porNome");
		jpql.setParameter("nome", "Aluno 1");

		Aluno aluno = (Aluno) jpql.getSingleResult();
		System.out.println(aluno);

		em.close();
		emf.close();
	}
}
