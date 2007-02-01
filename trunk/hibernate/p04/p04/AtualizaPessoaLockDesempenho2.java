package p04;

import org.hibernate.LockMode;

public class AtualizaPessoaLockDesempenho2 {
	public static void main(String[] args) {
		HibernateUtils2.start();
		Pessoa p = new Pessoa();
		p.setNome("Tiradentes");
		
		long inicio = System.currentTimeMillis();
		HibernateUtils2.persiste(p);
		p.setPeso(80.2F);		
		HibernateUtils2.startTransaction();
		HibernateUtils2.getSession().lock(p,LockMode.NONE); 
		p.setSexo('M');                        		
		HibernateUtils2.commitTransaction();
		long fim = System.currentTimeMillis();
		System.out.println(fim - inicio + "ms");
	}
}
