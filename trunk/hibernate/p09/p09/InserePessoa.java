package p09;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InserePessoa {
	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa();
		Endereco endereco = new Endereco();
		endereco.setRua("Rua 15");
		pessoa.adicionaEndereco(endereco);

		Configuration cfg = new Configuration().configure();
		Session session = cfg.buildSessionFactory().openSession();
		Transaction tran = session.beginTransaction();
		session.save(pessoa);
		tran.commit();
		session.close();
		
		System.out.println(pessoa + " " + pessoa.getEnderecos());
	}
}
