package p06;

import java.util.List;

import org.hibernate.Query;

public class RecuperaPessoas {

	public static void main(String[] args) {
		HibernateUtils.start();
		HibernateUtils.startTransaction();
		Query q = HibernateUtils.getSession().createQuery("from Pessoa");
		List<Pessoa> lp = q.list();
		HibernateUtils.commitTransaction();
		
		System.out.println("Total de pessoas: " + lp.size());
		for (Pessoa p : lp)
			System.out.println(p);
	}
}