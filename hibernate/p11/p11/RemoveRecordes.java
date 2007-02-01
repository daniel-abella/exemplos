package p11;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 * Só se pode remover um recorde caso ele não seja anterior
 * de nenhum outro recorde.
 *
 */
public class RemoveRecordes {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		Session s = cfg.buildSessionFactory().openSession();
		List lr = s.getNamedQuery("SQL-RecordeNãoQuebrado").list();
		System.out.println(lr);
		s.close();
	}
}