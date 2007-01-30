package progjava.colecao;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetExemplo {
	public static void main(String[] args) {
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		lhs.add("Capivara");
		lhs.add("Anta");
		lhs.add("Gato");
		
		for (Iterator i = lhs.iterator(); i.hasNext(); ) {
			System.out.println(i.next());
		}
	}
}