package nove;

import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProdutoAplicacaoJpa {
	public static void main(String[] args) {
        // Produto sem ProdutoInfo
		Produto prodUm = new Produto("Sabão", 123);

        // Produto com ProdutoInfo
        Produto prodDois = new Produto("Carro", 777);
        prodDois.setProdutoInfo(new ProdutoInfo("Ford", Calendar.getInstance()));

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("jpaNove");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(prodUm);
        em.persist(prodDois);
		tx.commit();
		em.close();

        Produto produtoUm = null;
        Produto produtoDois = null;

        em = null;
        em = emf.createEntityManager();
        produtoUm = em.find(Produto.class, prodUm.getId());
        produtoDois = em.find(Produto.class, prodDois.getId());
        em.close();

        System.out.println(produtoUm);
        System.out.println(produtoDois);
	}
}
