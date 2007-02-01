package p05;

import p04.Pessoa;

public class RemovePessoaOtimizada {

	public static void main(String[] args) {
		HibernateUtils.start();
		HibernateUtils.startTransaction();
		Object obj = HibernateUtils.getSession().get(Pessoa.class, Long.valueOf(2));
		if (obj != null) HibernateUtils.getSession().delete(obj);
		HibernateUtils.commitTransaction();
		System.out.println("Objeto removido:");
		System.out.println(obj);
	}
}