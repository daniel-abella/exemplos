package oito;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Aplicacao {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaOito");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Campo campo = new Campo();
		campo.setX(1);
		em.persist(campo); // Insere campo
		
		Propriedade propriedade = new Propriedade();
		propriedade.setX(2);
		em.persist(propriedade); // Insere propriedade
		
		tx.commit();
		em.close();	
		
		em = emf.createEntityManager();
		em.find(Campo.class, campo.getId());
		em.find(Propriedade.class, propriedade.getId());		
		em.close();
	}
}