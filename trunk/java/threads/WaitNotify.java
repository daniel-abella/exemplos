public class WaitNotify {
	static public void main(String... args) throws Exception {
		WaitNotify.Notify n = new WaitNotify.Notify();
		
		synchronized (n) {
			n.start();
			n.wait();
			System.out.println("reassumi o controle");	
			n.notify();
		}
		System.out.println("fim Wait");
	}

	static class Notify extends Thread {
		public void run() {
			synchronized (this) {
				try {
					Thread.sleep(1000);
					System.out.println("já dormi");
					notify();
					wait();
					System.out.println("dormindo novamente");
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
			}
			System.out.println("fim Notify");
		}
	}
}
