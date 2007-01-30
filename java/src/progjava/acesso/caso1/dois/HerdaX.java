package progjava.acesso.caso1.dois;

import progjava.acesso.caso1.um.X;

public class HerdaX extends X {{--x;}
	
	public void faz() {
		algo();
		x = -2;
		// new X(0).x = 10; // Não compila
	}
	
	public void umaAcao() {
		System.out.println("umaAcao: HerdaX");
	}
}
