package tres;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PessoaAplicacaoJpa {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaTres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		
		Pessoa p = new Pessoa("Outro nome próprio");
		Endereco endereco = new Endereco("Rua das Camélias", 321);
		p.setEndereco(endereco);
		
		em.persist(p);
		tx.commit();
		em.close();
	}
}
