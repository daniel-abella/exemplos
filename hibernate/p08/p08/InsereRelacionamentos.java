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
		s.save(b1);  // Associação B->A faz uso de cascade="ALL"
		s.save(b2);  // Salvar B significa salvar A correspondente
		tr.commit(); // Outro cenário exige que se tenha que salvar A antes
		s.close();
	}
}
