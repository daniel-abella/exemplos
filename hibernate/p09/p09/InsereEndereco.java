package p09;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsereEndereco {
	public static void main(String[] args) {
		Endereco end = new Endereco();
		end.setRua("Rua T-2");

		Configuration cfg = new Configuration().configure();
		Session session = cfg.buildSessionFactory().openSession();
		Transaction tran = session.beginTransaction();
		Query q = session.createQuery("from Pessoa");
		List<Pessoa> lp = q.list();
		if (lp.size() != 0) {
			end.setPessoa(lp.get(0));
			lp.get(0).adicionaEndereco(end);
		}
		tran.commit();
		session.close();		
	}
}
