package em1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MatriculaAlunosNaTurma {
	public static void main(String[] args) throws Exception {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("em1");
		EntityManager em = emf.createEntityManager();		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		// Obtém turma persistida anteriormente
		String jpql = "select t from Turma t where t.nome = 'Turma da Mônica'";
		Query consulta = em.createQuery(jpql);
		Turma turma = (Turma) consulta.getSingleResult();
		
		// Obtém alunos também persistidos em outra aplicação
		consulta = em.createQuery("select a from Aluno a where a.nome = 'A'");
		Aluno a = (Aluno) consulta.getSingleResult();
		
		consulta = em.createQuery("select a from Aluno a where a.nome = 'B'");
		Aluno b = (Aluno) consulta.getSingleResult();
		
		consulta = em.createQuery("select a from Aluno a where a.nome = 'C'");
		Aluno c = (Aluno) consulta.getSingleResult();
		
		
		// Adiciona alunos à turma
		turma.adicionaAluno(a);
		turma.adicionaAluno(b);
		turma.adicionaAluno(c);
		
		// Atualiza turma com alunos matriculados
		em.merge(turma);
		
		tx.commit();
	}
}
