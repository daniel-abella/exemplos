package p11;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ListaRecordes {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		Session s = cfg.buildSessionFactory().openSession();
		Transaction tr = s.beginTransaction();
		List<Recorde> lr = s.createQuery("from Recorde").list();
		for (Recorde r : lr) System.out.println(r);
		tr.commit();
		System.out.println("Total: " + lr.size());
	}
}
