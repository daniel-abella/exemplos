package dezoito;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersisteCurriculoAplicacao {
	public static void main(String[] args) {
		persisteCurriculo("kyrios-wallpaper.jpg", "robinson-crusoe.txt");
	}

	public static void persisteCurriculo(String foto, String texto) {
		Curriculo curriculo = CurriculoService.newCurriculo(foto, texto);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaDezoito");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(curriculo);

		tx.commit();
		em.close();
	}
}
