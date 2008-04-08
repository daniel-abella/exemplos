package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Aplicacao {
	public static void main(String[] args) throws Exception {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("jpa23");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Endereco endereco = new Endereco();
		em.persist(endereco);
		
		Pessoa pessoa = new Pessoa();
		pessoa.setEndereco(endereco);
		System.out.println("Antes de salvar: " + pessoa);
		
		// Assegura que chaves são idênticas (antes de persistir)
		pessoa.setId(endereco.getId());
		em.persist(pessoa);
		long id = pessoa.getId();
		
		em.persist(new Endereco()); // Endereco (sem Pessoa correspondente)
		
		tx.commit();
		em.close();
		
		em = emf.createEntityManager();
		Pessoa instPessoa = em.find(Pessoa.class, Long.valueOf(id));
		Endereco instEndereco = em.find(Endereco.class, Long.valueOf(id));
		instPessoa.setEndereco(instEndereco);
		System.out.println("Pessoa recuperada: " + instPessoa);
		em.close();
	}
}
