package nove;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProdutoAplicacaoJpa {
	public static void main(String[] args) {
		Produto produto = new Produto("Sabão", 123);

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("jpaNove");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(produto);
		tx.commit();
		em.close();
	}
}
