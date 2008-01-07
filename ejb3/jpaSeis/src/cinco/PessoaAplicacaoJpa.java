package cinco;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PessoaAplicacaoJpa {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaCinco");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Endereco end1 = new Endereco("Rua 1", 1);
		em.persist(end1);
		
		Endereco end2 = new Endereco("Rua 2", 2);
		em.persist(end2);
		
		Pessoa pessoa = new Pessoa("Outro nome próprio", end1);
		pessoa.adicionaEndereco(end2);
		em.persist(pessoa);
			
		tx.commit();
		em.close();
	}
}
