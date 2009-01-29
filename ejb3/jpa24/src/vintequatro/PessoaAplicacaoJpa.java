package vintequatro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PessoaAplicacaoJpa {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa24");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Pessoa pessoa = new PessoaFisica("João da Silva", "0123");
		em.persist(pessoa);
		
		pessoa = new PessoaJuridica("Empresa X", "3210");
		em.persist(pessoa);

        pessoa = new Pessoa("Um nome de pessoa");
        em.persist(pessoa);
			
		tx.commit();
		em.close();
	}
}
