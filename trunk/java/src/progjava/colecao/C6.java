package progjava.colecao;

import java.util.LinkedHashMap;
import java.util.Map;

public class C6 {
	public static void main(String[] args) {
		Map<Object, String> mapa = new LinkedHashMap<Object, String>();
		mapa.put("a", "a");
		Boi boi = new Boi("soberano");
		mapa.put(boi, "boi");
		mapa.put(new Gato(), "gato");
		
		// Neste ponto o mapa está construído. 
		// Alterações nos objetos ou nas chaves (estado) não
		// irão provocar um "rearranjo" do mapa.
		
		System.out.println(mapa);
		System.out.println(mapa.get("a"));
		System.out.println(mapa.get("soberano"));
		System.out.println(mapa.get(boi));
		
		boi.setNome("12345678");
		System.out.println(mapa.get(new Boi("12345678")));
	}
}

class Boi {
	private String nome;

	Boi(String nome) {
		this.nome = nome;
	}
	
	public void setNome(String nome) { this.nome = nome; }

	public boolean equals(Object objeto) {
		return nome.equals(((Boi) objeto).nome);
	}

	public int hashCode() {
		return nome.length();
	}

	public String toString() {
		return "boi";
	}
}

class Gato {
	public String toString() { return "gato"; }
}
