package p07;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManipulaPrevidencia {
	public static void main(String[] args) {
		Previdencia prev = fazPrevidencia();
		
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		s.save(prev);
		tr.commit();
		
		List<Previdencia> lp = s.createCriteria(Previdencia.class).list();
		for (Previdencia p : lp) {
			System.out.println("Previdência: " + p);
		}
		s.close();
	}

	private static Previdencia fazPrevidencia() {
		Previdencia prev = new Previdencia();
		prev.setNome("INSS");
		Map<String,String> b = new HashMap<String,String>();
		b.put("1", "Pedro");
		b.put("2", "Jackson");
		prev.setBeneficiarios(b);
		return prev;
	}
}
