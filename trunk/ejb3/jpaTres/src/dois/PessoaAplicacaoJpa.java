package dois;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PessoaAplicacaoJpa {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaDois");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Pessoa p = new Pessoa("Outro nome próprio");
		p.setRua("Rua das Camélias");
		p.setNumero(321);
		
		em.persist(p);
		tx.commit();
		em.close();
	}
}
