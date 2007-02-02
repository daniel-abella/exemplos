package p07;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClasseDeElementosTeste {
	public static void main(String... args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		s.save(newInstance());
		tr.commit();
		s.close();
	}
	
	private static ClasseDeElementos newInstance() {
		ClasseDeElementos cde = new ClasseDeElementos();
		List<Elemento> le = new ArrayList<Elemento>();
		Elemento e = null;
		for (int i = 0; i < 10; i++) {
			e = new Elemento();
			e.setInteiro(i);
			e.setNome(Integer.toString(i));
			le.add(0,e);
		}
		cde.setLista(le);
		return cde;
	}
}
