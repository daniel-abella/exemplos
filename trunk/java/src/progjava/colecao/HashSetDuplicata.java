package progjava.colecao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDuplicata {
	public static void main(String[] args) {
		Set<String> al = new HashSet<String>();
		System.out.println(al.add("Gato")); // true, "Gato" é inserido
		System.out.println(al.add("Gato")); // false, "Gato" já existe

		for (Iterator i = al.iterator(); i.hasNext();) {
			System.out.println(i.next());
		}
	}
}