package dezesseis;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ExercitaColunas {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaDezesseis");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(new A()); // 2 instâncias de A
		em.persist(new A()); // ids gerados pelo persistence provider
		
		C c1 = new C();
		c1.setCadastroPessoaFisica("123");		
		C c2 = new C();
		c2.setCadastroPessoaFisica("123");
		em.persist(c1); // Nenhum problema em persistir c1 e c2
		em.persist(c2); // cpf não é 'unique', conforme mapeamento
		
		D d1 = new D();  // CPF é unique (segunda execução deste código falha)
		d1.setCpf("xxx");
		em.persist(d1);
		
		E e1 = new E();
		e1.setX((int)(Math.random() * 1000 * 1000));		
		em.persist(e1); // Sem problema (insertable=false, updatable=false)
		
		F f1 = new F();
		f1.setNome("não pode ser null");
		em.persist(f1);
		
		// HSQLDB aceita nome acima do limite de caracteres estabelecido.
		F f2 = new F();
		f2.setNome("nome com mais de trinta e sete caracteres (erro)?");
		em.persist(f2);

		tx.commit();
		em.close();
	}
}
