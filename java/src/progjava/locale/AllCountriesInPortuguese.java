package progjava.locale;

import java.util.Locale;

public class AllCountriesInPortuguese {
	public static void main(String[] args) {
		Locale locale = new Locale("pt", "BR");
		for (String language : Locale.getISOLanguages())
			System.out.println(new Locale(language).getDisplayLanguage(locale));
	}
}
