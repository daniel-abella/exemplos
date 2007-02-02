package p12;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Selecao2007 {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		session.save(newProcessoSeletivo());
		tx.commit();
	}
	
	private static ProcessoSeletivo newProcessoSeletivo() {
		ProcessoSeletivo ps = new ProcessoSeletivo();
		Candidato c1 = new Candidato();
		c1.setNome("Pedro");
		
		Candidato c2 = new Candidato();
		c2.setNome("Miguel");
		
		ps.adicionaCandidato(c1);
		ps.adicionaCandidato(c2);		
		ps.setData(new Date());
		
		return ps;
	}
}
