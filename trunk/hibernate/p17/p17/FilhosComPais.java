package p17;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FilhosComPais {
	static Filho f1 = new Filho();
	static Filho f2 = new Filho();
	static Pai p1 = new Pai();
	static Pai p2 = new Pai();
	
	static {
		p1.setNome("pai 1");
		p2.setNome("pai 2");
		
		f1.setNome("filho 1");
		f1.setPai(p1);

		f2.setNome("filho 2");
		f2.setPai(p2);
	}

	public static void main(String[] args) {		
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		session.save(p1);
		session.save(p2);
		session.save(f1);
		session.save(f2);
		tx.commit();
	}
}
