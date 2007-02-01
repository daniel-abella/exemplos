package p07;

import java.util.Currency;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManipulaConfiguracao {
	public static void main(String[] args) {		
		Configuracao c = newConfiguracao();
		
		BasicConfigurator.configure();                       // Log4j
		Configuration cfg = new Configuration().configure(); // hibernate.cfg.xml
		SessionFactory sf = cfg.buildSessionFactory();       // Fábrica de sessões			
		Session s = sf.openSession();                        // Única sessão
		
		Transaction tx = s.beginTransaction();               // Persiste 'c'
		s.save(c);
		tx.commit();
		
		System.out.println("Inserido: " + c);
		
		tx = s.beginTransaction();
		Query q = s.createQuery("from Configuracao c where c.local = 'pt_BR'");
		List<Configuracao> lc = q.list();
		for (Configuracao conf : lc) {
			s.delete(conf);
			System.out.println("Removido: " + conf);
		}
		tx.commit();
		
		System.out.println(s.createQuery("from Configuracao").list().size());
	}

	private static Configuracao newConfiguracao() {
		Locale local = new Locale("pt", "BR");
		Configuracao c = new Configuracao();
		c.setLocal(local);
		c.setMoeda(Currency.getInstance(local));
		return c;
	}
}
