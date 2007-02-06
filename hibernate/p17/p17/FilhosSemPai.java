package p17;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FilhosSemPai {
	public static void main(String[] args) {
		Filho f1 = new Filho();
		f1.setNome("filho 1");
		
		Filho f2 = new Filho();
		f2.setNome("filho 2");
		
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		session.save(f1);
		session.save(f2);
		tx.commit();
	}
}
