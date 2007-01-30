public class VerySimpleWait extends Thread {
	private static boolean notificou = false;

	public void run() {
		synchronized (VerySimpleWait.class) {
			System.out.println("Antes de notificar");
			VerySimpleWait.class.notifyAll();
			notificou = true;
			System.out.println("Após notificar");
		}
	}

	public static void main(String[] args) throws Exception {
		new VerySimpleWait().start();
		synchronized (VerySimpleWait.class) {
			if (!notificou) {
				System.out.println("Antes do wait");
				VerySimpleWait.class.wait();
				System.out.println("Após o wait");
			}
		}
		System.out.println("fim");
	}
}