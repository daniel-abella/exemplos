package progjava.colecao;

import java.util.Arrays;
import java.util.List;

public class C3 implements Comparable<C3> {
	private int valor;

	public C3(int valor) {
		setValor(valor);
	}
	
	public int getValor() {
		return valor;
	}
	
	private void setValor(final int valor) {
		this.valor = valor;
	}
	
	public int compareTo(final C3 outro) {
		return valor - outro.valor;
	}
	
	public String toString() {
		return Integer.toString(valor);
	}

	public static void main(final String[] args) {
		final C3[] array = { new C3(10), new C3(2), new C3(-2) };
		final List<C3> lista = Arrays.asList(array);
		System.out.println(lista);
		java.util.Collections.sort(lista);
		System.out.println(lista);
	}
}
