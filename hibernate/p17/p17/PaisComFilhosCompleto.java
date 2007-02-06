package p17;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PaisComFilhosCompleto {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		Pai p1 = newFamilia("1");
		for (Filho f : p1.getFilhos())
			session.save(f);
		session.save(p1);
		tx.commit();

		tx = session.beginTransaction();
		for (Filho f : p1.getFilhos()) {
			f.setPai(p1);
			session.save(f);
		}
		tx.commit();
	}

	private static Pai newFamilia(String nome) {
		Pai pai = new Pai();
		pai.setNome(nome);

		Filho f1 = new Filho();
		f1.setNome(nome + ".1");

		Filho f2 = new Filho();
		f2.setNome(nome + ".2");

		pai.getFilhos().add(f1);
		pai.getFilhos().add(f2);
		return pai;
	}
}
