package p05;

import p04.Pessoa;

public class SalvaPessoa {
	public static void main(String[] args) {
		HibernateUtils.start();
		HibernateUtils.startTransaction();
		
		Pessoa p = new Pessoa();
		p.setNome("José");
		
		HibernateUtils.getSession().save(p);
		
		// Altera nome de 'p'
		p.setNome("João"); 
		
		// Insere 'João' em vez de 'José'
		HibernateUtils.commitTransaction();
	}
}
