package p04;

import org.hibernate.LockMode;

public class AtualizaPessoaLockDesempenho {
	public static void main(String[] args) {
		Pessoa p = new Pessoa();
		p.setNome("Tiradentes");
		
		long inicio = System.currentTimeMillis();
		HibernateUtils.persiste(p);
		p.setPeso(80.2F);		
		HibernateUtils.startTransaction();
		HibernateUtils.getSession().lock(p,LockMode.NONE); 
		p.setSexo('M');                        		
		HibernateUtils.commitTransaction();
		long fim = System.currentTimeMillis();
		System.out.println(fim - inicio + "ms");
	}
}
