
public class JoinDeadlock extends Thread {
	public void run() {
		try {
			this.join(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new JoinDeadlock().start();
	}
}
