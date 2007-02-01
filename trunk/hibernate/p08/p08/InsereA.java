package p08;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsereA {
	public static void main(String[] args) {
		A a1 = new A("a1");
		A a2 = new A("a2");
		
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		s.save(a1);
		s.save(a2);
		tr.commit();
		s.close();
	}
}
