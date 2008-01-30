package vinte;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ChaveAplicacao {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("jpaVinte");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(new Surrogate1());
		em.persist(new Surrogate2());
		em.persist(new Surrogate3());
		em.persist(new Surrogate4());
		em.persist(new Surrogate5());
		em.persist(new Surrogate6());
		em.persist(new Surrogate7());
		em.persist(new Surrogate8());

		tx.commit();
		em.close();
		emf.close();

	}
}
