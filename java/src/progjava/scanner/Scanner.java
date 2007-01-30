package progjava.scanner;

import java.net.URL;

public class Scanner {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://www.inf.ufg.br/~fabio/formas");		
		java.util.Scanner s = new java.util.Scanner(url.openStream(),"iso-8859-1");
		s.useDelimiter("\n");
		StringBuilder sb = new StringBuilder();
		int n = 0;
		while (s.hasNext()) {
			sb.append(s.next());
			sb.append(" ");
			n++;
		}
		System.out.println(n);
		System.out.println(sb.length());
		
		java.util.Scanner s2 = new java.util.Scanner(sb.toString());
		String achou = null;
		while ((achou = s2.findInLine("\\s\\w+ção")) != null)
			System.out.println(achou);
		
//		System.out.println(sb.toString().split("\\s").length);
	}
}
