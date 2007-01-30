public class VariosThreadsSimples {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++)
			new Thread(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName());
				}
			}).start();
	}
}
