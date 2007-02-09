package p10;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CriaProdutosEliminaExistentes {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();		
		
		removeProdutosExistentes(sf);
		insereNovosProdutos(sf, lista());
	}
	
	private static void insereNovosProdutos(SessionFactory sf, List<?> l) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		for (Object o : l) session.save(o);
		tx.commit();
		session.close();
	}

	private static void removeProdutosExistentes(SessionFactory sf) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Criteria q = session.createCriteria(Produto.class);
		List<Produto> lp = q.list();
		for (Produto p : lp) session.delete(p);
		tx.commit();
		session.close();
	}
	
	private static List<Produto> lista() {
		List<Produto> l = new ArrayList<Produto>();
		l.add(new Produto("Arroz"));
		l.add(new Produto("Feijão"));
		l.add(new Produto("Tomate"));
		l.add(new Produto("Banana"));
		l.add(new Produto("Maçã"));
		return l;
	}
}
