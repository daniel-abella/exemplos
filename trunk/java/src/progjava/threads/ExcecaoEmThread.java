package progjava.threads;
public class ExcecaoEmThread implements Runnable {
    public void run() {
	throw new RuntimeException();
    }

    public static void main(String[] args) {
	new Thread(new ExcecaoEmThread()).start();
	System.out.println("passei por aqui");
    }
}
    
