package progjava.colecao;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class C4 implements Comparator<C4>, Comparable<C4> {
	private int valor;

	public int compareTo(final C4 outro) {
		return compare(outro, this);
	}

	public int compare(final C4 este, final C4 outro) {
		return outro.valor - este.valor;
	}
	
	public boolean equals(final Object outro) {
		return outro instanceof C4;
	}
	
	public int hashCode() { return valor; }
	
	public C4(int valor) { this.valor = valor; }
	
	public String toString() {
		return Integer.toString(valor);
	}
	
	public static void main(final String[] args) {
		List<C4> lista = Arrays.asList(new C4[] { new C4(3), new C4(2) });
		System.out.println(lista);
		Collections.sort(lista);
		System.out.println(lista);
		Collections.sort(lista, new C4(10));
		System.out.println(lista);
	}
}