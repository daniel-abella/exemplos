package p11;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ListaRecordesPorAtleta {
	public static void main(String[] args) {
		BasicConfigurator.configure();
		SessionFactory sf = null;
		sf = new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		Criteria query = session.createCriteria(Atleta.class);
		for (Object atleta : query.list()) {
			System.out.println((Atleta) atleta);
			for (Object recorde : ((Atleta) atleta).getRecordes()) {
				System.out.println("  " + recorde);
			}
		}
		session.close();
	}
}
