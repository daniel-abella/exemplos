package p11;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsereAtletas {
	public static void main(String[] args) {
		BasicConfigurator.configure();
		SessionFactory sf = null;
		sf = new Configuration().configure().buildSessionFactory();	
		
		Atleta a1 = newAtleta("João do Pulo");		
		Atleta a2 = newAtleta("Ronaldinho Gaúcho");

		Recorde r1 = newRecorde("futebol");
		Recorde r2 = newRecorde("futebol");
		r2.setAnterior(r1);
		
		Set<Recorde> set = new HashSet<Recorde>();
		set.add(r1);
		set.add(r2);
		
		a2.setRecordes(set);
		
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		session.save(a1);
		session.save(a2);
		tran.commit();
		session.close();		
	}

	private static Atleta newAtleta(String atleta) {
		Atleta a1 = new Atleta();
		a1.setNome(atleta);
		return a1;
	}

	private static Recorde newRecorde(String descricao) {
		Recorde r1 = new Recorde();
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		r1.setData(c);
		r1.setDescricao(descricao);
		return r1;
	}
}
