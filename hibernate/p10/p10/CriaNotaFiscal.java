package p10;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CriaNotaFiscal {
	private static SessionFactory sf = null;
	private static List<Produto> lp = null;

	static {
		Configuration cfg = new Configuration().configure();
		sf = cfg.buildSessionFactory();
		lp = listaProdutos();
	}

	public static void main(String[] args) {
		NotaFiscal nf = criaNotaFiscal();
		persisteNota(nf);
	}

	private static void persisteNota(NotaFiscal nf) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(nf);
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	private static List<Produto> listaProdutos() {
		List<Produto> lp = null;
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		lp = session.createCriteria(Produto.class).list();
		tx.commit();
		session.close();
		return lp;
	}
	
	private static NotaFiscal criaNotaFiscal() {
		ItemNotaFiscal inf = new ItemNotaFiscal();
		inf.setQuantidade(1);
		inf.setProduto(lp.get(0));
		NotaFiscal nf = new NotaFiscal(inf);
		
		inf = new ItemNotaFiscal();
		inf.setQuantidade(2);
		inf.setProduto(lp.get(1));
		nf.getItens().add(inf);
		return nf;
	}
}
