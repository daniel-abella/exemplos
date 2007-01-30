package progjava.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Busca {
	public static void main(final String[] args) {
		final Pattern padrao = Pattern.compile(args[0]);
		final Matcher loc = padrao.matcher(args[1]);
		while (loc.find()) {
			System.out.println(loc.start() + " " + loc.group());
		}
	}
}
