
public class JoinSemThread extends Thread {
	public static void main(String[] args) throws Exception {
		Thread thread = new JoinSemThread();
		thread.join();
	}
}
