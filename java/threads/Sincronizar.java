public class Sincronizar extends Thread {
	private static long saldo = 20000;

	public void debito(long v) {
		// Observe que sinchronized aplicado ao método ou 
		// synchronized(this) não resolve o problema!
		synchronized (Sincronizar.class) { 
			saldo = saldo - v; 
		}
	}

	public void run() {
		for (int i = 0; i < 10000; i++)
			debito(1);
	}

	public static void main(String[] args) throws Exception {
		Sincronizar thread1 = new Sincronizar();
		Sincronizar thread2 = new Sincronizar();
		thread1.start(); // Inicia thread (deveria debitar 10000)
		thread2.start(); // Inicia thread (deveria debitar 10000)

		thread1.join();
		thread2.join();

		// Saldo inicial é 20000 ou seja, o saldo final
		// deveria ser 0
		System.out.println("Saldo final: " + saldo);
	}
}