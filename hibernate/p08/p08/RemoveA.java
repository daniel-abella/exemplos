package p08;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RemoveA {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		List<A> la = session.createCriteria(A.class).list();
		List<B> lb = session.createCriteria(B.class).list();
		
		// Para todo B necessariamente existe um A e, portanto, 
		// não se remove A sem remover o B correspondente
		// Só será possível remover A para o qual não existe B
		// AÇÃO: remova dentre os As aqueles para os quais não existe B
		for (B b : lb) la.remove(b.getA());		
		
		// Os As em la não são referenciados por nenhum B e,
		// portanto, podem ser removidos.
		for (A a : la) session.delete(a);
		tr.commit();
	}
}
