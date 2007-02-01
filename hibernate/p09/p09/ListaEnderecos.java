package p09;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class ListaEnderecos {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		Session session = cfg.buildSessionFactory().openSession();
		Query q = session.createQuery("from Endereco");
		List<Endereco> le = q.list();
		for (Endereco e : le)
			System.out.println(e);
		session.close();
	}
}
