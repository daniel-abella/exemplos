
public class ChamandoRunFromThread extends Thread {
	public void run() { System.out.printf("%s\n", getClass().getName()); }
	public static void main(String[] args) {
		Thread t = new ChamandoRunFromThread();
		t.run();
		t.start();
		t.run();
	}
}
