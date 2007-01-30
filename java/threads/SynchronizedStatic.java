import java.util.ArrayList;
import java.util.List;

public class SynchronizedStatic implements Runnable {
	static int x = 0;

	// Without synchronized keyword this program does print
	// different values for the result in x. 
	// It also shows that synchronized code runs slowly than
	// ordinary ones.
	static synchronized void faz() {
		x = x + 1;
	}

	public void run() {
		for (int i = 0; i < 1000 * 1000; i++)
			faz();
	}

	public static void main(String[] args) throws InterruptedException {
		long inicio = System.currentTimeMillis();
		List<Thread> threads = new ArrayList<Thread>();
		for (int i = 0; i < 100; i++) {
			threads.add(new Thread(new SynchronizedStatic()));
			threads.get(i).start();
		}
					
		for (Thread thread : threads) thread.join();
		System.out.printf("x = %d (%fs)", x,(System.currentTimeMillis() - inicio) / 1000.0);
	}
}