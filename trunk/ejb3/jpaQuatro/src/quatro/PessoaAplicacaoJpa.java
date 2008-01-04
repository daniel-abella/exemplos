package quatro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PessoaAplicacaoJpa {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaQuatro");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Endereco endereco = new Endereco("Rua das Camélias", 321);		
		Pessoa p = new Pessoa("Outro nome próprio", endereco);		
		em.persist(p);
			
		tx.commit();
		em.close();
	}
}
