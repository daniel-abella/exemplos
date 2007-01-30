package progjava.acesso.caso1.um;

import progjava.acesso.caso1.dois.FazAlgo;

public class X implements FazAlgo {
	protected int x = 10;
	
	protected X() {
		System.out.println("instância de X criada");
	}
	
	public X(int x) {
		this.x = x;
	}
	
	native synchronized public void algo();
	
	public void fazAlgo() throws RuntimeException {
		System.out.println("fiz algo");
	}
	
	protected void umaAcao() {
		System.out.println("umaAcao: X");
	}
	
	public static void estatico() {
		System.out.println("X.estatico");
	}
}
