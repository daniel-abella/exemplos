package progjava.locale;

import java.util.Locale;

public class AllCountries {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		int colunas = 21;
		for (String pais : Locale.getISOCountries()) {
			sb.append(" | " + pais);
			if (--colunas == 0) {
				sb.append(" |\n");
				colunas = 21;
			}
		}
		sb.append("\nTOTAL: " + Locale.getISOCountries().length);
		System.out.println(sb);
		
	}
}
