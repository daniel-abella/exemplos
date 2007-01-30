public class SimpleWait extends Thread {
	public void run() {
		synchronized (this) {
			System.out.println("synchronized (this)");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {}
		}
	}

	public static void main(String[] args) throws Exception {
		SimpleWait sw = new SimpleWait();
		sw.start();
		Thread.sleep(100);
		synchronized (sw) {
			System.out.println(sw.isAlive());
			sw.wait();
			System.out.println(sw.isAlive());
		}
		System.out.println("fim main");
	}
}
