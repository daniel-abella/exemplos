package progjava.locale;

import java.util.Locale;

public class GetDisplay {
	public static void main(String... args) {
		System.out.println(Locale.getDefault().getDisplayCountry());
		System.out.println(Locale.getDefault().getDisplayLanguage());
	}
}
