public class SynchronizedContext {
	class X implements Runnable {
		synchronized public void run() {
			System.out.println(run("X"));
		}

		public String run(String a) {
			try {
				wait(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return a;
		}
	}

	public static void main(String[] args) throws Exception {
		SynchronizedContext sc = new SynchronizedContext();
		new Thread(sc.new X()).start();
		Thread.sleep(1010);
	}

}
