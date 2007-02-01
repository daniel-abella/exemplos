package p04;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class RemovePessoa {
	private static Configuration cfg;
	private static Session session;
	private static SessionFactory sf;
	private static Transaction tx;

	public static void main(String[] args) {		
		BasicConfigurator.configure();
		cfg = new Configuration().configure();
		sf = cfg.buildSessionFactory();
		session = sf.openSession();
		tx = session.beginTransaction();
		Pessoa p = (Pessoa) session.get(Pessoa.class, Long.valueOf(0));
		if (p != null) session.delete(p);
		tx.commit();
		session.close();
		
		System.out.println("Pessoa abaixo existe em memória apenas:");
		System.out.println(p);
		
		session = sf.openSession();
		tx = session.beginTransaction();
		Query consulta = session.createQuery("from Pessoa");
		List<Pessoa> resultados = consulta.list();
		if (resultados.size() == 0) {
			System.out.println("Nenhuma pessoa encontrada no repositório");
		}
		
		for (Pessoa pes : resultados) {
		    System.out.println(pes);
		}

		tx.commit();
		session.close();
		sf.close();
	}
}
