package p08;

import org.hibernate.cfg.Configuration;
import org.hibernate.*;

public class InsereRelacionamentos {
	public static void main(String[] args) {
		B b1 = new B();
		b1.setA(new A("A de b1"));
		B b2 = new B();
		b2.setA(new A("A de b2"));

		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		s.save(b1);
		s.save(b2);
		tr.commit();
		s.close();
	}
}
