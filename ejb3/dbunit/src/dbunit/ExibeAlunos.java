package dbunit;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ExibeAlunos {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("dbunit");
		EntityManager em = emf.createEntityManager();
		
		Query jpql = em.createQuery("select a from Aluno a");
		List<Aluno> alunos = jpql.getResultList();
		
		for (Aluno aluno : alunos)
			System.out.println(aluno);
		
		em.close();
		emf.close();
	}
}
