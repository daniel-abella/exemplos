package p08;

import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class RemoveTodosB {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		List<B> lb = session.createCriteria(B.class).list();
		for (B b : lb)
			session.delete(b);
		tr.commit();
	}
}
