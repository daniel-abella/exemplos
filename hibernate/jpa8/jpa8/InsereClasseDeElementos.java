package jpa8;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class InsereClasseDeElementos {
	
	public static void main(String[] args) {
		ClasseDeElementos newClasseDeElementos = newClasseDeElementos();
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("jpa7");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();		
		em.persist(newClasseDeElementos);
		tx.commit();
		em.close();
	}

	private static ClasseDeElementos newClasseDeElementos() {
		List<Elemento> le = new ArrayList<Elemento>();
		Elemento e = new Elemento();
		e.setNome("a");
		le.add(e);
		e = new Elemento();
		e.setNome("b");
		le.add(e);
		ClasseDeElementos ce = new ClasseDeElementos();
		ce.setLista(le);		
		return ce;
	}
}
