package progjava.boxing;

public class SimplestBoxing extends Thread {
	private int inicio = 0;
	private int fim = 0;

	public static void main(String[] args) {
		long d = 1000 * 1000 * 60;
		long fim;
		for (long l = Integer.MIN_VALUE; l <= Integer.MAX_VALUE; l = fim + 1) {
			fim = (l + d) > Integer.MAX_VALUE ? Integer.MAX_VALUE : l + d;
			new SimplestBoxing((int) l, (int) fim).start();
		}
	}

	public SimplestBoxing(int i, int f) { inicio = i; fim = f; }

	public void run() {
		int i;
		for (i = inicio; i < fim; i++)
			assert new Integer(i) == i && new Integer(i).equals(i);
		assert new Integer(i) == i && new Integer(i).equals(i);
		System.out.println(fim);
	}
}