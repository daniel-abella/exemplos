package p04;

import org.hibernate.LockMode;

public class AtualizaPessoaLock {
	public static void main(String[] args) {
		Pessoa p = new Pessoa();
		p.setNome("Tiradentes");
		
		// Até aqui: p é transiente
		// Persistida, mas desconectada em seguida
		HibernateUtils.persiste(p);
		
		// Neste ponto p encontra-se detached (desconectada)
		p.setPeso(80.2F);
		
		HibernateUtils.startTransaction();
		
		// Associa p com a sessão (p torna-se persistente)
		// Se a linha abaixo for comentada, nenhuma alteração é
		// efetuada em p
		HibernateUtils.getSession().lock(p,LockMode.NONE); 
		
		p.setSexo('M'); // Alteração p tornar-se persistente
		
		// Efetua eventuais alterações
		HibernateUtils.commitTransaction();		
	}
}
