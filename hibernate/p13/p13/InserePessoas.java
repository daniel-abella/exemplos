package p13;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InserePessoas {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Fulano");
        CPF cpf1 = new CPF();
        cpf1.setNumero("1");
        p1.setCpf(cpf1);
        
        Pessoa p2 = new Pessoa("Ciclano");
        CPF cpf2 = new CPF();
        cpf2.setNumero("2");
        p2.setCpf(cpf2);
        
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        Transaction tr = s.beginTransaction();
        s.save(p1);
        s.save(p2);
        tr.commit();
    }
}
