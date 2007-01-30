package progjava.colecao;

import java.util.Arrays;

public class ArraysAsList {
	private static boolean called = false;
	
	public static void main(String... args) {
		System.out.println(Arrays.asList(args));
		if (called)
			return;
		else {
			called = true;
			main("A", "B", "C");
		}		
	}
}