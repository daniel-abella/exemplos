package p15;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ListaEndereco {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session sessao = sf.openSession();
		Transaction tran = sessao.beginTransaction();
		Criteria crt = sessao.createCriteria(Endereco.class);
		for (Endereco endereco : (List<Endereco>) crt.list()) {
			System.out.println(endereco);
		}
		tran.commit();
		sessao.close();
	}
}
