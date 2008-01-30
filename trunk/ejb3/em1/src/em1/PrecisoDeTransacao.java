package em1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PrecisoDeTransacao {
	public static void main(String[] args) throws Exception {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("em1");
		EntityManager em = emf.createEntityManager();
		
		try {
			em.persist(new Aluno());
		} catch (RuntimeException e) {
			e.printStackTrace();
			return;
		}
		
		// N�o usual pois sugere que a inst�ncia de Aluno criada
		// n�o ser� persistida, o que n�o � o caso. 
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		tx.commit();
	}
}
