package p05;

import p04.Pessoa;

public class RemovePessoaRevisada {

	public static void main(String[] args) {
		HibernateUtils.start();
		Object obj = HibernateUtils.obtem(Pessoa.class, new Long(args[0]));
		HibernateUtils.remove(obj);
		
		System.out.println("Pessoa existe em memória apenas:");
		System.out.println(obj);
	}
}