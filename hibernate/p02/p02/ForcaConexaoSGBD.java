package p02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ForcaConexaoSGBD {
	public static void main(String... args) {
		// Faz uso de hibernate.properties
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		try {
			Transaction tx = session.beginTransaction();
			tx.commit();
			System.out.println("Tudo bem...");
		} catch (Exception e) {
			System.out.println("Conexão não realizada...");
		}
	}
}