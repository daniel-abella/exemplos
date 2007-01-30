public class Deadlock extends Thread {
	public void run() {
		synchronized (Deadlock.class) {}
	}

	synchronized public static void main(String[] args) throws Exception {
		Deadlock d = new Deadlock();
		d.start();
		d.join();
	}
}