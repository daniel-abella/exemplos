package p11;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Remove todos os atletas e, conseqüentemente,
 * todos os recordes correspondentes.
 */
public class RemoveAtletas {
	public static void main(String[] args) {
		BasicConfigurator.configure();
		SessionFactory sf = null;
		sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Query q = session.createQuery("from Atleta");
		List<Atleta> la = q.list();
		Transaction tran = session.beginTransaction();
		for (Atleta a : la)
			session.delete(a);
		tran.commit();
		System.out.println("Total: " + la.size());
		session.close();
	}
}
