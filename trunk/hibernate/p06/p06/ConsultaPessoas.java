package p06;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class ConsultaPessoas {

	public static void main(String[] args) {
		HibernateUtils.start();
		HibernateUtils.startTransaction();
		Session session = HibernateUtils.getSession();
		String hql = "from Pessoa p where p.peso >= :minimo";
		Query q = session.createQuery(hql);
		q.setInteger("minimo", 6);
		List<Pessoa> lp = q.list();
		HibernateUtils.commitTransaction();
		
		System.out.print("Pessoas com pelo menos 6 quilos: ");
		System.out.println(lp.size());
		for (Pessoa p : lp) {
			System.out.println(p);
		}
	}
}