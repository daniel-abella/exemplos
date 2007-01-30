package progjava.colecao;

import java.util.Arrays;

public class C2 {
	private C2() {}
	
	public static void main(final String[] args) {
		final Integer[] arrayI = { 5, 4, 3, 2, 1 };		
		System.out.println(arrayI); // object.toString()
		
		System.out.println(Arrays.toString(arrayI)); // Formato legível
		Arrays.sort(arrayI);
		System.out.println(Arrays.toString(arrayI));
	}
}