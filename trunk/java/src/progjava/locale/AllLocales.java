package progjava.locale;

import java.util.Arrays;
import java.util.Locale;

public class AllLocales {
	public static void main(String[] args) {
		Locale[] ls = Locale.getAvailableLocales();
		String[] sl = new String[ls.length];
		for (int i = 0; i < ls.length; i++) 
			sl[i] = ls[i].toString();
		Arrays.sort(sl);
		StringBuilder sb = new StringBuilder();
		int colunas = 9;
		for (String l : sl) {
			sb.append(String.format(" | %9s", l));
			if (--colunas == 0) {
				sb.append(" |\n");
				colunas = 9;
			}
		}
		System.out.println(sb);
		System.out.println(Locale.getAvailableLocales().length);
	}
}
