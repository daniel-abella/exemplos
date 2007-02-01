package p05;

import java.util.Calendar;

import p04.Pessoa;

public class ArmazenaPessoaRevisada {

	public static void main(String[] args) {
		HibernateUtils.start();
		
		Pessoa p = new Pessoa();
		p.setNome("Euclides da Cunha");
		Calendar c = Calendar.getInstance();
		c.set(1866, Calendar.JANUARY, 20);
		p.setNascimento(c);

		// Dados abaixo são fictícios
		p.setCasado(false);
		p.setPeso(156.8f);
		p.setSexo('M');

		// Persiste 'p'
		HibernateUtils.persiste(p);
	}
}