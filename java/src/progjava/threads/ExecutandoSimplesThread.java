package progjava.threads;

public class ExecutandoSimplesThread {
	public static void main(String[] args) {
		new Thread() { public void run() { System.out.println("ok"); } }.start();
	}
}
