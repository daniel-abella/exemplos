package em3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SelecionaPorParteNome {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("em2");
		EntityManager em = emf.createEntityManager();

		Query jpql = em.createNamedQuery("porParteNome");
		// O que termina por qualquer caractere seguido de 2.
		jpql.setParameter("parte", "%_2"); 

		List<Aluno> alunos = (List<Aluno>) jpql.getResultList();
		System.out.println(alunos);

		em.close();
		emf.close();
	}
}
