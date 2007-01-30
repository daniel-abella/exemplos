package progjava.generics;

interface Interface {}
interface A {}

public class CriaArrayT<Tipo extends Thread & A> {
	<K> CriaArrayT(Tipo t) {}
	
	static <T extends Runnable & Interface & A> void imprime(T str) {		
		str.run();
	}
	
	public static void main(String[] args) {
		class X extends Thread implements Interface, A {
			public void run() {
				System.out.println("ok");
			}
		}
		imprime(new X());
		class Teste extends Thread implements A, Interface {
			public void run() {}
		}
		new CriaArrayT<Teste>(new Teste());
		CriaArrayT.imprime(new Teste());
	}
}
