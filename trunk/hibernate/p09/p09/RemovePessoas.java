package p09;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RemovePessoas {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		Session session = cfg.buildSessionFactory().openSession();
		Transaction tran = session.beginTransaction();	
		Query q = session.createQuery("from Pessoa");
		List<Pessoa> lp = q.list();
		for (Pessoa pessoa : lp)
			session.delete(pessoa);
		tran.commit();
		session.close();
	}
}
