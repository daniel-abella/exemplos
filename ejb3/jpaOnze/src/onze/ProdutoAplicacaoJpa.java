package onze;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProdutoAplicacaoJpa {
	public static void main(String[] args) {
		ProdutoInfo pi = new ProdutoInfo("sem tiras", Calendar.getInstance());
		Produto produto = new Produto("Chinelo", 123);
		produto.setProdutoInfo(pi);
		pi.setProduto(produto);

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("jpaOnze");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(pi);
		em.persist(produto);
		tx.commit();
		em.close();
	}
}
