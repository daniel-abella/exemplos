package p11;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ListaAtletas {
	public static void main(String[] args) {
		BasicConfigurator.configure();
		SessionFactory sf = null;
		sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Query q = session.createQuery("from Atleta");
		List<Atleta> la = q.list();
		for (Atleta a : la)
			System.out.println(a);
		System.out.println("Total de atletas: " + la.size());
		session.close();
	}
}
