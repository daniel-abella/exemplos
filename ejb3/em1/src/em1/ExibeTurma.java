package em1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ExibeTurma {
	public static void main(String[] args) throws Exception {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("em1");
		EntityManager em = emf.createEntityManager();		
		
		// Obtém turma persistida anteriormente
		String jpql = "select t from Turma t where t.nome = 'Turma da Mônica'";
		Query consulta = em.createQuery(jpql);
		Turma turma = (Turma) consulta.getSingleResult();
		
		System.out.println(turma);
	}
}
