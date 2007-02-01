package p15;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CriaEndereco {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session sessao = sf.openSession();
		Transaction tran = sessao.beginTransaction();
		sessao.save(criaEndereco());
		tran.commit();
		sessao.close();
	}
	
	private static Telefone criaTelefone() {
		Telefone telefone = new Telefone();
		telefone.setArea(Integer.toString((int)(Math.random() * 100)));
		telefone.setNumero("3521-1510");
		return telefone;
	}
	
	private static Endereco criaEndereco() {
		Endereco end = new Endereco();
		end.adicionaTelefone(criaTelefone());
		end.adicionaTelefone(criaTelefone());
		return end;
	}
}
