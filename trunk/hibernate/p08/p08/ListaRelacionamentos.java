package p08;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ListaRelacionamentos {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();		
		List<B> lb = s.createCriteria(B.class).list();
		for (B b : lb)
			System.out.println(b);
		s.close();
	}
}
