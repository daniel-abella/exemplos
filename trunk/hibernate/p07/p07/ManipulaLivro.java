package p07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManipulaLivro {
	public static void main(String[] args) {
		Livro livro = newLivro();
		
		BasicConfigurator.configure();
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();	
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		s.save(livro);
		tx.commit();
		
		tx = s.beginTransaction();
		Criteria c = s.createCriteria(Livro.class);
		List<Livro> ll = c.list();
		for (Livro l : ll) {
			s.delete(l);
			System.out.println("Removido: " + l);
		}
		tx.commit();		
	}

	private static Livro newLivro() {
		Livro livro = new Livro();
		livro.setTitulo("A pergunta");
		List<String> autores = new ArrayList<String>();
		autores.add("Pedro");
		autores.add("Antonio");
		autores.add("Benevides");
		Collections.sort(autores);
		livro.setAutores(autores);
		return livro;
	}
}
