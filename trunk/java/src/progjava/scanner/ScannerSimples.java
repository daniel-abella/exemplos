package progjava.scanner;

public class ScannerSimples {
	public static void main(String[] args) {
		String source = args.length > 0 ? args[0] : "A vida é bela";
		java.util.Scanner s = new java.util.Scanner(source);
		String delimitador = args.length > 1 ? args[1] : "\\s";
		s.useDelimiter(delimitador);
		while (s.hasNext()) {
			if (s.hasNextDouble())
				System.out.println("Double " + s.nextDouble());
			else
				s.next();
		}
	}
}
