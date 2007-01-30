
public class WaitError {
	static public void main(String... args) throws Exception {
		WaitError we = new WaitError();
		try {
			we.wait();
		} catch (IllegalMonitorStateException ims) {
			System.out.println("Runtime exception");
			
			synchronized (we) {
				we.wait(2000);
				System.out.println("Epero, mas nao indefinidamente ...");
			}
		}
	}
}
