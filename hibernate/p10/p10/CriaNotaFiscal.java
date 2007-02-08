package p10;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CriaNotaFiscal {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		
		NotaFiscal nf = new NotaFiscal(new ItemNotaFiscal());
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(nf);
		tx.commit();
		session.close();
	}
}
