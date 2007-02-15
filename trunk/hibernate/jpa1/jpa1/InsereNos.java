package jpa1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsereNos {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("jpa1");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		No no1 = new No();
		no1.setInfo("no 1");
		No no2 = new No();
		no2.setInfo("no 2");
		no1.setProximo(no2);
		em.persist(no1);
		tx.commit();
		em.close();
	}
}
