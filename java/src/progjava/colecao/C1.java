package progjava.colecao;

import java.util.Arrays;

public class C1 implements Comparable<C1> {
	int valor = 0;

	public String toString() {
		return Integer.toString(valor);
	}

	C1(int valor) {
		this.valor = valor;
	}

	public int compareTo(C1 o) {
		return this.valor - o.valor;
	}

	public static void main(String[] args) {
		C1[] oa = { new C1(5), new C1(3), new C1(-4) };
		Arrays.sort(oa);
		System.out.println(Arrays.asList(oa));
	}
}