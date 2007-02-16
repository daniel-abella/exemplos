package jpa3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ManipulaPessoa {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("jpa3");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(newPessoa());
		tx.commit();
		em.close();
	}
	
	private static Pessoa newPessoa() {
		Pessoa p = new Pessoa();
		p.setNome(Integer.toString((int)(Math.random() * 100)));
		return p;
	}
}
