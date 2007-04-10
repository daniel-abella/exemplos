package dominio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ConteinerRepositoryDefault implements ConteinerRepository {

	public void persiste(Conteiner conteiner) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("jpa-data");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();		
		em.persist(conteiner);
		tx.commit();
		em.close();
	}

	public Conteiner obtem(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
