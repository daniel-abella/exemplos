package jpa8;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class ConteinerRepositoryDefault implements ConteinerRepository {
	
	public static void main(String[] args) {
		new ConteinerRepositoryDefault().persiste(newConteiner());
	}

	public void persiste(Conteiner conteiner) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("jpa7");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();		
		em.persist(conteiner);
		tx.commit();
		em.close();
	}

	private static Conteiner newConteiner() {
		List<Elemento> le = new ArrayList<Elemento>();
		Elemento e = new Elemento();
		e.setNome("a");
		le.add(e);
		e = new Elemento();
		e.setNome("b");
		le.add(e);
		Conteiner ce = new Conteiner();
		ce.setLista(le);		
		return ce;
	}
}
