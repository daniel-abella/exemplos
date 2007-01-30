package progjava.array;

public class Array1 {
	private static int valor = 2;
	
	private Array1() {
		valor = 3;
	}
	
	public static void main(String[] args) {
		int[] a;
		a = new int[0];

		// Caussa ArrayIndexOutOfBoundsException
		// a[0] = 1;

		System.out.println(a == null);
		for (int x : a)
			System.out.print(x + " ");
	}
}
