package nove;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProdutoInfoAplicacao {
	public static void main(String[] args) {
		ProdutoInfo pi = new ProdutoInfo("A", Calendar.getInstance());

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("jpaNove");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(pi);
		tx.commit();
		em.close();
	}
}
