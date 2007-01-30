package progjava.colecao;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExemplo {

	public static void main(String[] args) {
		List<String> al = new ArrayList<String>();
		System.out.println(al);

		al.add("Gato");
		al.add("Capivara");
		al.add("Anta");
		al.add(Integer.toString(1));

		for (int i = 0; i < al.size(); i++)
			System.out.print(al.get(i) + " ");
		
		System.out.println();
		System.out.println(al);
		for (Object o : al.toArray())
			System.out.print(o + " ");
	}
}
