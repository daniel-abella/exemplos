package quinze;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ExercitaTabelas {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaQuinze");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(new A());
		em.persist(new B());
		em.persist(new C());
		em.persist(new D());

		F f = new F();
		f.nome = "A";
		f.cpf = "123";
		
		// A chamada abaixo só funciona em sua primeira execução.
		// Posteriores geram exceção, pois não satisfaz restrição
		// de unicidade envolvendo "nome" e "cpf" (veja mapeamento)
		em.persist(f);
			
		tx.commit();
		em.close();
	}
}
