package jpa4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AtualizaPessoa {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("jpa4");
		EntityManager em = emf.createEntityManager();
		Pessoa p1 = (Pessoa) em.createQuery("from Pessoa").getResultList().get(0);
		System.out.println(p1);
		em.close();
		
		p1.setCasado(!p1.isCasado()); // Altera estado civil
		
		EntityManager em2 = emf.createEntityManager();
		EntityTransaction tx2 = em2.getTransaction();
		tx2.begin();
		Pessoa p2 = em2.merge(p1);
		tx2.commit();
		em2.close();
		
		EntityManager em3 = emf.createEntityManager();
		System.out.println(em3.find(Pessoa.class, p2.getId()));
		em3.close();
	}
}