
public class JoinInutil {
	public static void main(String[] args) {
		class X implements Runnable {
			public void run() {}
		}
		
		Thread t = new Thread(new X());
		t.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ie) {}
		
		System.out.println(t.isAlive());
		try {
			t.join();
		} catch (InterruptedException e) {}
		
		System.out.println("fim");
	}
}
