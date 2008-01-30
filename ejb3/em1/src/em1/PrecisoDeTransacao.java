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
		
		// Não usual pois sugere que a instância de Aluno criada
		// não será persistida, o que não é o caso. 
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		tx.commit();
	}
}
