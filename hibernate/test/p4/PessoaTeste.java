package p4;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

import java.util.Calendar;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import p04.Pessoa;

public class PessoaTeste {
	private static Configuration cfg;

	Session session;

	private static SessionFactory sf;

	Transaction tx;

	@Test
	public void autorOsSertoes() {
		Pessoa p = new Pessoa();
		p.setNome("Euclides da Cunha");
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 20);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.YEAR, 1866);
		p.setNascimento(c);

		// Dados abaixo são fictícios
		// (ao contrário da data de nascimento)
		p.setCasado(false);
		p.setPeso(156.8f);
		p.setSexo('M');
		assertNull(p.getId());

		session.save(p);
		assertNotNull(p.getId());
	}

	@Test
	public void x() {
		//
	}

	@Before
	public void setUp() {
		session = sf.openSession();
		tx = session.beginTransaction();
	}

	@After
	public void tearDown() {
		tx.commit();
		session.close();
	}

	@BeforeClass
	public static void inicia() {
		BasicConfigurator.configure(); // Log4j
		cfg = new Configuration().configure();
		sf = cfg.buildSessionFactory();
	}

	@AfterClass
	public static void termina() {
		sf.close();
	}
}
