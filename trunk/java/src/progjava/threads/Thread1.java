package progjava.threads;

public class Thread1 extends Thread {
    Thread1(String a) { super(a); }
    public void run() { 
	// Prints the name of the current thread.
	System.out.println(Thread.currentThread().getName()); 

	// Prints the name of the Thread object
	System.out.println(getName());
    }

    public static void main(String[] args) {
	// Start a new thread and print OK followed by OK in a new line.
	Thread t = new Thread1("OK");
	t.start();

	try {t.join();} catch(InterruptedException e) {}

	// Does not start a new thread (just runs the run() method and
	// gets the name of the thread object.
	new Thread1("SIM").run();
    }
}
