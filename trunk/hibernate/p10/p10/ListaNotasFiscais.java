package p10;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ListaNotasFiscais {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();		
		List<NotaFiscal> lnf = s.createCriteria(NotaFiscal.class).list();
		for (NotaFiscal nf : lnf)
			System.out.println(nf); 
		s.close();
	}
}
