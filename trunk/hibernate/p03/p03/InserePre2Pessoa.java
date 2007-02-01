package p03;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InserePre2Pessoa {
    public static void main(String[] args) {        
        Pre2Pessoa p2p = new Pre2Pessoa(); 
        p2p.setNome("Dom Pedro II");
        
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        session.save(p2p);
        tx.commit();
        
        session.close();
    }
}
