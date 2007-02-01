package p05;

import p04.Pessoa;

public class RollBackPessoa {
	public static void main(String[] args) {
		HibernateUtils.start();
		HibernateUtils.startTransaction();
		Pessoa p = new Pessoa();
		p.setNome("Pedro");
		HibernateUtils.getSession().save(p);
		p.setNome("Pedro Batista"); 
		
		// Nem 'Pedro' nem 'Pedro Batista' será inserido!
		HibernateUtils.rollbackTransaction();
	}
}
