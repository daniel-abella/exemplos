package progjava.colecao;

import java.util.ArrayList;
import java.util.List;

public class ListOfObjects {
	public static void main(String[] args) {
		final List<Object> lista = new ArrayList<Object>();		
		lista.add(3.14);
		lista.add(3);		
		System.out.println(lista);		
	}
}
