
class Problema implements Runnable {
	int state;

	public synchronized void run() {
		if (state++ < 3) {
			//System.out.print(" " + Thread.currentThread().getId());
			try {
				this.wait();
			} catch (Exception e) {
			}
			//System.out.print(" " + Thread.currentThread().getId());
		} else {
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
			}
			notify();
			notifyAll();
		}
	}

	public static void main(String[] args) {
		Problema w1 = new Problema();
		Problema w2 = new Problema();
		Thread[] threads = new Thread[4];
		threads[0] = new Thread(w1);
		threads[1] = new Thread(w1);
		threads[2] = new Thread(w2);
		threads[3] = new Thread(w2);
		
		for (Thread thread : threads)
			thread.start();
		
		System.out.printf("Thread ID (current thread) = %d\n", Thread.currentThread().getId());
		for (Thread thread : Thread.getAllStackTraces().keySet())
			System.out.println(thread.getId());
		
		for (Thread thread : threads)
			System.out.println(thread.getId());
	}
}