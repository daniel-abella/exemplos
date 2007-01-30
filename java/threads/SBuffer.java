public class SBuffer extends Thread {
	private StringBuffer sb;

	private static int nadds = 0;

	public void run() {
		for (int i = 0; i < 10000; i++, nadds++)
			sb.append("x");
	}

	SBuffer(StringBuffer sb) {
		this.sb = sb;
	}

	public static void main(String[] args) throws Exception {
		long inicio = System.nanoTime();
		StringBuffer sb = new StringBuffer();
		SBuffer sq1 = new SBuffer(sb);
		SBuffer sq2 = new SBuffer(sb);
		sq1.start();
		sq2.start();
		sq1.join();
		sq2.join();
		System.out.print(sb.length() + " " + SBuffer.nadds);
		long delta = System.nanoTime() - inicio;
		System.out.print(" " + (delta / 1000.0 / 1000.0));
	}
}
