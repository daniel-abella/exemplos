package progjava.colecoes;

import java.util.Map;
import java.util.TreeMap;

public class MapaWhoCanBeAKey {
	class X {}
	
	public static void main(String[] args) {
		Map<X,String> m = new TreeMap<X,String>();
		m.put(new MapaWhoCanBeAKey().new X(), String.valueOf(1));
		m.put(new MapaWhoCanBeAKey().new X(), String.valueOf(1));
	}
}
