package p11;

import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsereRecordes {
	public static void main(String[] args) {		
		// Cria primeiro recorde
		Recorde r1 = new Recorde();
		Calendar c = Calendar.getInstance();
		r1.setData(c);
		r1.setDescricao("futebol");
		
		// Segundo recorde 1 hora depois
		Recorde r2 = new Recorde();
		c = Calendar.getInstance();
		c.add(Calendar.HOUR, 1);     
		r2.setData(c);
		r2.setDescricao("basquete");
		
		// Terceiro recorde 1 hora após o segundo
		Recorde r3 = new Recorde();
		c = Calendar.getInstance();
		c.add(Calendar.HOUR, 2);     
		r3.setData(c);
		r3.setDescricao("nado");
		
		// Recorde r2 sucede o recorde r1
		r2.setAnterior(r1);
		r3.setAnterior(r2);
		
		Configuration cfg = new Configuration().configure();
		Session s = cfg.buildSessionFactory().openSession();
		Transaction tr = s.beginTransaction();
		s.save(r3);
		tr.commit();
	}
}
