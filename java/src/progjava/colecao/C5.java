package progjava.colecao;

import java.util.Set;
import java.util.TreeSet;

public class C5 {
	public static void main(String[] args) {
		Set<String> conjunto = new TreeSet<String>();
		conjunto.add("f");
		conjunto.add(String.valueOf('c'));
		conjunto.add("a");
		conjunto.add(String.valueOf(2));
		conjunto.add(String.valueOf(2));
		for (Object objeto : conjunto) 
			System.out.println(objeto);
	}
}
