package p04;

import java.util.Calendar;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PersistePessoa {
	private static Configuration cfg;
	private static Session session;
	private static SessionFactory sf;
	private static Transaction tx;
	
	public static void main(String[] args) {
		Pessoa p = criaPessoa();

		BasicConfigurator.configure(); // Log4j
		cfg = new Configuration().configure(); // hibernate.cfg.xml
		sf = cfg.buildSessionFactory();
		session = sf.openSession();
		tx = session.beginTransaction();
		session.save(p);
		tx.commit();
		session.close();
		sf.close();
	}

	private static Pessoa criaPessoa() {
		Pessoa p = new Pessoa();
		p.setNome("Euclides da Cunha");
		Calendar c = Calendar.getInstance();
		c.set(1866, 0, 20);	// 20/01/1866
	    p.setNascimento(c);
	    
	    // Dados abaixo são fictícios
	    p.setCasado(false);
	    p.setPeso(156.8f);
	    p.setSexo('M');
		return p;
	}
}