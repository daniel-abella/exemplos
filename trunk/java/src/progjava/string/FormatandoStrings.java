package progjava.string;

public class FormatandoStrings {
	public static void main(String[] args) {
		String formato = "%-5b %+05d %0(5.2f %-5c %-5s\n";
		System.out.printf(formato, true, 2, -2., 'a', 'a');

		Object[] argumentos = { Boolean.TRUE, Integer.valueOf(2),
				-2.0, new Character('a'), String.valueOf('a') };
		
		System.out.printf(formato, argumentos);
	}
}