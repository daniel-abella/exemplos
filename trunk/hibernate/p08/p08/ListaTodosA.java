package p08;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ListaTodosA {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();		
		List<A> la = s.createCriteria(A.class).list();
		for (A a : la)
			System.out.println(a);
		s.close();
	}
}
