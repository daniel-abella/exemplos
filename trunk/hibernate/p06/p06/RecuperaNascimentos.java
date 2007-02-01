package p06;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.hibernate.Query;

public class RecuperaNascimentos {

	public static void main(String[] args) {
		Locale loc = new Locale("pt", "BR");
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG,loc);
		HibernateUtils.start();
		HibernateUtils.startTransaction();
		Query q = HibernateUtils.getSession().createQuery("select p.nascimento from Pessoa p");
		List<Calendar> lp = q.list();
		HibernateUtils.commitTransaction();
		
		System.out.println("Total de pessoas: " + lp.size());
		for (Calendar p : lp) {
			System.out.println(df.format(p.getTime()));
		}
		
	}
}