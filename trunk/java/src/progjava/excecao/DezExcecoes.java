package progjava.excecao;

class E01 extends Thread {
	public void run() {
		new int[]{}[0] = 1;
	}	
}

class E02 extends Thread {
	public void run() {
		Object obj = "";
		((Byte)obj).shortValue();
	}
}

/**
 * Incompleta. Refactoring: substituir versões anônimas de classes por classes como
 * aquelas acima. Torna o código mais legível.
 * @author fabio
 *
 */
public class DezExcecoes {
	public static void main(String[] args) throws Exception {
		Thread[] threads = { new E01(), new E02() };
		if (args.length == 0) {
			for (Thread thread : threads)
				thread.start();
			for (Thread thread : threads)
				thread.join();
		} else {
			int thread = Integer.parseInt(args[0]);
			threads[thread].start();
			threads[thread].join();
		}
		Thread.sleep(100);
		System.out.println("fim do thread principal");		
		if (true) return;

		new Thread() {
			public void run() {
				class InnerThread extends Thread {
					public void run() {
						
					}
				}
				Thread t = new InnerThread();
				t.start();
				t.start();
			}
		}.start();
		
		// NullPointerException
		new Thread(new Runnable() {
			public void run() {
				throw null;
			}
		}, "5").start();

		// NumberFormatException
		new Thread(new Runnable() {
			public void run() {
				Integer.parseInt("dois");
			}
		}, "6").start();
		
		// AssertionError
		new Thread(new Runnable() {
			public void run() {
				assert false;
			}
		}, "7").start();
		
		// ExceptionInInitializerError
		new Thread(new Runnable() {
			public void run() {
				try {
					Class.forName("progjava.excecao.ExcecaoAoIniciar");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				run();
			}
		}).start();
	}
}

class ExcecaoAoIniciar extends Thread {
	static { int x = 5/0; }
}