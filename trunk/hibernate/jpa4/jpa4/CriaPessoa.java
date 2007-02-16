package jpa4;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CriaPessoa {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("jpa4");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(newPessoa());
		tx.commit();
		em.close();
	}
	
	private static Pessoa newPessoa() {
		Pessoa p = new Pessoa();
		p.setNome(Integer.toString((int)(Math.random() * 100)));
		p.setCasado(false);
		p.setNascimento(Calendar.getInstance());
		p.setPeso(10.0f);
		p.setSexo(Math.random() > .5 ? 'm' : 'f');
		return p;
	}
}
