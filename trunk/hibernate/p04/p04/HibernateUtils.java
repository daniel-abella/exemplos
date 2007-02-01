package p04;

import java.io.Serializable;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static Configuration cfg;

	private static Session session;

	private static SessionFactory sf;

	private static Transaction tx;

	/**
	 * Verifica se é possível estabelecer conexão com banco de dados.
	 * 
	 * @return <code>true</code> se e somente se conexão foi realizada
	 *         satisfatoriamente.
	 * 
	 */
	public static boolean testaConexao() {
		boolean ok = true;
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		try {
			session.connection().getMetaData();
		} catch (Exception e) {
			ok = false;
		}
		return ok;
	}

	public static void persiste(Object object) {
		startTransaction();
		session.save(object);
		commitTransaction();
	}
	
	public static void remove(Object object) {
		startTransaction();
		session.delete(object);
		commitTransaction();
	}

	public static Object obtem(Class clazz, Serializable id) {
		startTransaction();
		Object obj = session.get(clazz, id);
		commitTransaction();
		return obj;
	}

	public static void commitTransaction() {
		tx.commit();
		session.close();
		sf.close();
	}

	public static void startTransaction() {
		BasicConfigurator.configure();
		cfg = new Configuration().configure();
		sf = cfg.buildSessionFactory();
		session = sf.openSession();
		tx = session.beginTransaction();
	}
	
	public static Session getSession() {
		return session;
	}
}