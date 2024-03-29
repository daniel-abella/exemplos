package p07;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManipulaEmpresa {
	public static void main(String[] args) {
		BasicConfigurator.configure();                       // Log4j
		Configuration cfg = new Configuration().configure(); // hibernate.cfg.xml
		SessionFactory sf = cfg.buildSessionFactory();	     // fábrica de sessões
		Session s = sf.openSession();                        // única sessão
		
		Transaction tx = s.beginTransaction(); // Alteração exige transação
		s.save(newEmpresa());                  // persiste 'emp'
		tx.commit();
		
		tx = s.beginTransaction();
		Criteria crit = s.createCriteria(Empresa.class);
		List<Empresa> le = crit.list();
		for (Empresa e : le) {
			s.delete(e);
			System.out.println("Removido: " + e);
		}
		tx.commit();	
	}

	private static Empresa newEmpresa() {
		Empresa emp = new Empresa();
		emp.setNome("Kyriosdata");
		Set<String> emails = new TreeSet<String>();
		emails.add("teste@kyriosdata.com");
		emails.add("outro@kyriosdata.com");
		emails.add("contato@kyriosdata.com");
		emails.add("a@kyriosdata.com");
		emails.add("B@kyriosdata.com");
		emp.setEmails(emails);
		return emp;
	}
}
