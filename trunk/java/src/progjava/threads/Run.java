package progjava.threads;

class B extends Thread { public void run() { System.out.println("B"); } }
class A extends B { public void run() { System.out.println("A"); } }
public class Run extends A {
	public static void main(String[] args) {
		new Run().start();
		new Runnable() { public void run() { System.out.print("A"); } }.run();
	}
}
