package progjava.array;

public class ValoresIniciais {
	public static void main(String[] args) {
		Double[] doubles = { Double.valueOf(1L), 2.3 };
		boolean[] booleans = new boolean[3];
		
		for (boolean b : booleans)
			System.out.print(b + " ");
		
		System.out.println();
		
		for (double d : doubles)
			System.out.print(d + " ");
	}
}
