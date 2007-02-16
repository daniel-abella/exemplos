package jpa4;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class RemovePessoas {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("jpa4");
		EntityManager em1 = emf.createEntityManager();
		EntityTransaction tx = em1.getTransaction();
		tx.begin();
		List<Pessoa> lp = em1.createQuery("from Pessoa").getResultList();
		System.out.println(lp.size());
		for (Pessoa p : lp) em1.remove(p);
		tx.commit();
		em1.close();
		
		EntityManager em2 = emf.createEntityManager();
		System.out.println(em2.createQuery("from Pessoa").getResultList().size());
		em2.close();
	}
}
