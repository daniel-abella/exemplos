package em3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsereCursoAlunoPessoa {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("em3");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Pessoa pessoa = new Pessoa("Jos� de Alencar");		
		Aluno aluno = new Aluno("INF0821", pessoa);		
		Curso curso = new Curso("Especializa��o");
		curso.adicionaAluno(aluno);

		// Todos os objetos precisam ser persistidos
		// Quase sempre a ordem tamb�m � relevante
		// CASCADE � uma forma de transferir a 
		// responsabilidade de persistir relacionamentos
		// para o persistence provider
		
		em.persist(pessoa);
		em.persist(aluno);
		em.persist(curso);		
		
		tx.commit();
		em.close();
	}
}
