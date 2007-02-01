package p02;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Shutdown {
	public static void main(String[] args) {
		try {
			// USADO APENAS EM DESENVOLVIMENTO!
			LogManager.getLoggerRepository().setThreshold(Level.OFF);
			
			// Faz uso de hibernate.properties
			Configuration cfg = new Configuration();
			SessionFactory sf = cfg.buildSessionFactory();
			Session session = sf.openSession();
			SQLQuery query = session.createSQLQuery("SHUTDOWN");
			query.executeUpdate();
		} catch (Exception e) {
		}
		System.out.println("HSQLDB Server finalizado");
	}
}
