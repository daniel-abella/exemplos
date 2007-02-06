package p17;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PaisSemFilhos {
	public static void main(String[] args) {
		Pai pai1 = new Pai();
		pai1.setNome("pai 1");
		
		Pai pai2 = new Pai();
		pai2.setNome("pai 2");

		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		session.save(pai1);
		session.save(pai2);
		tx.commit();
	}
}
