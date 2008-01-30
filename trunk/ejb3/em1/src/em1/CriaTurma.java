package em1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CriaTurma {
	public static void main(String[] args) throws Exception {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("em1");
		EntityManager em = emf.createEntityManager();		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(new Turma("Turma da Mônica"));
		
		tx.commit();
	}
}
