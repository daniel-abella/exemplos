package progjava.acesso.caso1.um;

import progjava.acesso.caso1.dois.HerdaX;

public class Teste {
	public static void main(String ... args) {
		X xs[] = new X[] { new X(), new HerdaX() };
		for (X x: xs)
			x.umaAcao();
		
		// Compiler error
		// new HerdaX().umaAcao();
	}
}
