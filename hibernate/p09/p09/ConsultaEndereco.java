package p09;

import java.util.List;

import org.hibernate.Query;

public class ConsultaEndereco {
	public static void main(String[] args) {
		HibernateUtils.start();
		HibernateUtils.beginTransaction();
		
		// Alguém mora na Av T-7?
		String hql = "from Endereco e where e.rua = 'Av T-7'";		
		Query q = HibernateUtils.getSession().createQuery(hql);
		List<Endereco> le = q.list();
		for (Endereco e : le)
			System.out.println(e.getPessoa());
		HibernateUtils.commitTransaction();
		System.out.println("Total: " + le.size());
	}
}
