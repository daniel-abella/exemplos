package progjava.colecoes;

import java.util.Map;
import java.util.TreeMap;

public class MapaNullKeyValues {
	public static void main(String[] args) {
		Map<Integer,String> m = new TreeMap<Integer,String>();
		
		System.out.print(m.put(null, null));
		System.out.format(" %d\n", m.size());
		
		System.out.print(m.put(null, null));
		System.out.printf(" %d\n", m.size());
		
		System.out.print(m.put(1, null));
		System.out.printf(" %d\n", m.size());
		
		for (Integer i : m.keySet())
			System.out.printf("Key: %1$-5d Valor: %2$s\n", i, m.get(i));
	}
}
