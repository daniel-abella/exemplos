
public class StartTwoTimes implements Runnable {
	public void run() {}
	
	public static void main(String[] args) {
		new Thread().start(); // no problem
		new Thread().start(); // no problem
		
		Runnable run = new StartTwoTimes();
		new Thread(run).start(); // no problem
		new Thread(run).start(); // no problem (different thread)
		
		Thread thread = new Thread();
		thread.start(); // no problem
		thread.start(); // PROBLEM!
	}
}
