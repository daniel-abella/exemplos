package p04;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class RecuperaPessoa {
	private static Configuration cfg;
	private static Session session;
	private static SessionFactory sf;

	public static void main(String[] args) {
		BasicConfigurator.configure(); // Log4j
		cfg = new Configuration().configure(); // hibernate.cfg.xml
		sf = cfg.buildSessionFactory();
		session = sf.openSession();

		// Todas as instâncias de Pessoa
		Criteria consulta = session.createCriteria(Pessoa.class);
		
		// Apenas aquelas cujos nomes se iniciam por 'Eu'
		Criterion cron = Restrictions.like("nome","Eu%");
		consulta.add(cron);
		
		// Obtenha em ordem descrescente de peso
		consulta.addOrder(Order.desc("peso"));
		
		// Forneça apenas os pesos
		ProjectionList pl = Projections.projectionList();
		pl.add(Projections.property("peso"));
		consulta.setProjection(pl);		
		
		System.out.println(consulta.list());
		session.close();
	}
}
