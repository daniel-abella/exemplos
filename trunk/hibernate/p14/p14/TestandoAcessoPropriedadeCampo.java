package p14;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestandoAcessoPropriedadeCampo {
	public static void main(String[] args) {
		Campo c = new Campo();             
		Propriedade p = new Propriedade(); // access="property"
		p.setX(1);
		
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();       
        Session session = sf.openSession();        
        Transaction tx = session.beginTransaction();
        session.save(c);
        session.save(p);
        tx.commit();        
        session.close();
        
        System.out.println("\nLendo valores persistidos...");
        
        session = sf.openSession();
        Campo c1 = (Campo) session.load(Campo.class, c.getId());
        Propriedade p1 = (Propriedade) session.load(Propriedade.class, p.getId());
        System.out.println("\nCampo: " + c1 + "\nPropriedade: " + p1);
        session.close();                
	}
}
