package progjava.locale;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

public class LocalesAreNotFlyweightsAsCurrencies {
	public static void main(String[] args) {
		Locale locale1 = new Locale("pt","BR");
		Locale locale2 = new Locale("pt","BR");
		System.out.println(locale1 == locale2);
		
		Currency c1 = Currency.getInstance(locale1);
		Currency c2 = Currency.getInstance(locale1);
		System.out.println(c1 == c2);

		List<Currency> lista = new ArrayList<Currency>();
		for (long i = 0; i < (1000 * 1000 * 2); i++)
			lista.add(Currency.getInstance("BRL"));
		lista.clear();
		System.out.println(lista.size());
		
		// You can run out of memory
		List<Locale> lcs = new ArrayList<Locale>();
		for (int i = 0; i < 1000 * 1000; i++) {
			lcs.add(new Locale("pt","BR"));
		}
	}
}
