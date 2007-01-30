package progjava.locale;

import java.util.Locale;

public class AllLanguages {
	public static void main(String[] args) {
		int colunas = 22;
		StringBuilder sb = new StringBuilder();
		for (String lang : Locale.getISOLanguages()) {
			sb.append(" | " + lang);
			if (--colunas == 0) {
				sb.append(" |\n");
				colunas = 22;
			}
		}
		sb.append("\nTOTAL: " + Locale.getISOLanguages().length);
		System.out.println(sb);
	}
}
