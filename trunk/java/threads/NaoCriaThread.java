public class NaoCriaThread {
	public static void main(String[] args) {
		Runnable r = new Runnable() {
			public void run() {
				System.out.println("Anonymous implementer");
			}
		};
		r.run();
		
		Thread t = new Thread() {
			public void run() {
				System.out.println("Anonymous class");
			}
		};
		t.run();
		
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t = new Thread(r);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Todos os threads terminaram...");
	}
}
