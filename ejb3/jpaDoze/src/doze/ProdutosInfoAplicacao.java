package doze;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProdutosInfoAplicacao {
	public static void main(String[] args) {
		ProdutoInfo pi = new ProdutoInfo("sem tiras", Calendar.getInstance());
		Turma p1 = new Turma("Chinelo", 123);
		p1.setProdutoInfo(pi);
		pi.setProduto(p1);
		
		Turma p2 = new Turma("Leite", 100);
		p2.setProdutoInfo(pi);

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("jpaOnze");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(pi);
		em.persist(p1);
		em.persist(p2);
		tx.commit();
		em.close();
	}
}
