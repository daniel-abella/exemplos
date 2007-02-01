package p09;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ListaPessoas {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		Session session = cfg.buildSessionFactory().openSession();
		Transaction tran = session.beginTransaction();
		Query q = session.createQuery("from Pessoa");
		List<Pessoa> lp = q.list();
		for (Pessoa p : lp) {
			System.out.println(p);
			Set<Endereco> ce = p.getEnderecos();
			for (Endereco endereco : ce) {
				System.out.println(endereco);
			}
		}
		tran.commit();
		session.close();
	}
}
