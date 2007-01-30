public class SBuilder extends Thread {
	private static StringBuilder sb = new StringBuilder();

	public void run() {
		for (int i = 0; i < 1000; i++)
			sb.append("x");
	}

	public static void main(String[] args) throws Exception {
		Thread[] threads = { new SBuilder(), new SBuilder() };
		for (Thread th : threads) th.start();
		for (Thread th : threads) th.join();
		System.out.print(sb.length());
	}
}
