package progjava.colecao;

import java.util.HashMap;
import java.util.Map;

public class HashMapExemplo {

	public static void main(String[] args) {
		final Map<String,Integer> numeros = new HashMap<String,Integer>();
		numeros.put("um", 1);
		numeros.put("dois", 2);
		numeros.put("tres", 3);

		System.out.println(numeros);
	}
}