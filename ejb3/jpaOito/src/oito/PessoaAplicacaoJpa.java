package oito;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PessoaAplicacaoJpa {
	public static void main(String[] args) {
		EntityManager em = getEntityManager();
		
		// Inicia transação
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Campo pessoa = new Campo("João", "Rua X", 15);
		em.persist(pessoa);
		
		tx.commit();
		em.close();		
		
		Long id = pessoa.getId();
		System.out.println("ID gerado: " + id);
		
		// Recupera instância persistida
		em = getEntityManager();		
		Campo outraPessoa = (Campo) em.find(Campo.class, id);
		em.close();
		
		System.out.println(outraPessoa);		
	}

	private static EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaSete");
		return emf.createEntityManager();
	}
}
