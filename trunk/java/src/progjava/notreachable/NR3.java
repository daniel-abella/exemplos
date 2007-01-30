package progjava.notreachable;

public class NR3 {
	public static void main(String... ar) {
		System.out.println(faz(new int[] { 0 }));
	}

	private static int faz(int... x) {
		return x[0];
		// Line below does not compile (unreachable code)
		// x[0]++;
		// return 0;
	}
}
