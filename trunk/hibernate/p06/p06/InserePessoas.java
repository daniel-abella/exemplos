package p06;

import java.util.Calendar;

public class InserePessoas {
	
	public static void inserePessoas() {
		HibernateUtils.startTransaction();
		Pessoa p = null;
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR, -101);
		for (int i = 1; i <= 10; i++) {
			p = new Pessoa();
			p.setNome(Integer.toString(i));
			c.add(Calendar.YEAR, 1);
			p.setNascimento((Calendar)c.clone());
			p.setSexo(i % 2 == 0 ? 'M' : 'F');
			p.setCasado(i % 2 == 0);
			p.setPeso(i);
			HibernateUtils.getSession().save(p);
		}
		HibernateUtils.commitTransaction();
	}

	public static void main(String[] args) {
		HibernateUtils.start();
		inserePessoas();
	}
}