class Total {
	private long soma;

	public long getSoma() {
		return soma;
	}

	public void setSoma(long soma) {
		this.soma = soma;
	}
}

class Adiciona implements Runnable {
	Total parcial;
	
	Adiciona(Total valor) {
		parcial = valor;
	}
	
	public void run() {
		long v = Long.valueOf(Thread.currentThread().getName());
		synchronized (parcial) {
			try {
				parcial.wait();
			} catch (InterruptedException e) {}
			parcial.setSoma(parcial.getSoma() + v);
		}
	}
}

public class Soma100PrimeirosInteirosUsando100Threads {
	
	public static void somaSimples() {
		long inicio = System.nanoTime();
		long somatorio = 0;
		for (int i = 1; i <= 100; i++)
			somatorio += i;

		System.out.print("Soma simples: " + somatorio);
		System.out.println(" " + ((System.nanoTime() - inicio) / 1000.0 / 1000.0));
	}
	public static void main(String[] args) {
		somaSimples();
		somaThreads();
	}
	
	public static void somaThreads() {
		long inicio = System.nanoTime();
		Thread[] ts = new Thread[100];
		Total total = new Total();
		for (int i = 0; i < 100; i++) {
			ts[i] = new Thread(new Adiciona(total));
			ts[i].setName(Integer.toString(i+1));
		}
		
		for (Thread t : ts)
			t.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {}
		
		synchronized (total) {
			total.notifyAll();
		}
		
		for (Thread t : ts)
			try {
				t.join();
			} catch (InterruptedException e) {}
			
		System.out.print("Soma threads: " + total.getSoma());
		System.out.print(" " + ((System.nanoTime() - inicio) / 1000.0 / 1000.0));
	}
}
