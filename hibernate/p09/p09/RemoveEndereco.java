package p09;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RemoveEndereco {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		Session session = cfg.buildSessionFactory().openSession();
		Transaction tran = session.beginTransaction();		
		Query q = session.createQuery("from Pessoa");
		List<Pessoa> lp = q.list();
		Endereco remover = lp.get(0).getEndereco();
		if (remover != null)
			lp.get(0).getEnderecos().remove(remover);   // Remove end associado a pessoa
		session.saveOrUpdate(lp.get(0));                    // Realiza atualização em pessoa
		tran.commit();
		session.close();
	}
}
