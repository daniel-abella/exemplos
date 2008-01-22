package jpa21;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Aplicacao {
	public static void main(String[] args) throws Exception {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("jpa21");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Pessoa pessoa = new Pessoa();
		pessoa.setEndereco(new Endereco());
		
		em.persist(pessoa);
		long id = pessoa.getId();
		
		tx.commit();
		em.close();
		
		em = emf.createEntityManager();
		Pessoa p = em.find(Pessoa.class, Long.valueOf(id));
		em.close();
		
		System.out.println(p);

	}
}
