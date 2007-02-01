package p09;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InserePessoaSemEndereco {
	public static void main(String[] args) {
		Pessoa p1 = new Pessoa();		
		Configuration cfg = new Configuration().configure();
		Session session = cfg.buildSessionFactory().openSession();
		Transaction tran = session.beginTransaction();
		session.save(p1);
		tran.commit();
		session.close();
		System.out.println("Primary key: " + p1.getId());
	}
}
