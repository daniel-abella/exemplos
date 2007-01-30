package progjava.misc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * This application shows how to parse a simple data file and
 * get information for each line that contains the locale corresponding
 * to the value that follows the locale. Only these two information
 * are available for line. See the example below:
 * 
 * pt_BR 1,2
 * en_US 1.2
 * 
 * The file above contains the same value represented by two different locales.
 * After reading those lines, the values recovered must be the same. The number
 * of lines of those files are always even such that each pair of lines contain
 * the same value.
 * 
 * @author fabio
 *
 */
public class LeArquivoNumerosConformeLocale {
	public static void main(String[] args) throws IOException, ParseException {
		String fileName = args.length != 0 ? args[0] : "c:/tmp/dados.txt";
		
		generateFile();
		
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		for (String linha; (linha = br.readLine()) != null; ) {
			double v1 = parseLine(linha);
			double v2 = parseLine(br.readLine());
			if (v1 != v2)
				System.out.println("Some problem with file format!");
		}
	}

	private static double parseLine(String linha) throws ParseException {
		String[] tokens = linha.split(" ");
		String[] details = tokens[0].split("_");
		Locale locale = details.length > 1 ? new Locale(details[0], details[1]) : new Locale(details[0]);
		NumberFormat nf = NumberFormat.getInstance(locale);
		return nf.parse(tokens[1]).doubleValue();
	}
	
	private static void generateFile() {
		double value = 3.1415;
		Locale[] locales = Locale.getAvailableLocales();
		NumberFormat nf;
		for (Locale locale : locales) {
			nf = NumberFormat.getNumberInstance(locale);
			System.out.printf("%s %s\n",locale.toString(), nf.format(value));
		}
	}
}
