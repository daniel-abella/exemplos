package progjava.instanciaof;

import java.io.File;

enum Estado { GO, MG, SP, RJ };

public class Objeto {	
	public static void main(final String[] args) {
		final Object varA = new int[0];
		final Object varB = new File("c:/tmp");
		final Estado varE = Estado.GO;
		
		class Excecao extends RuntimeException {
			private static final long serialVersionUID = 1L;

			Excecao(final String msg) { super(msg); }
		}
		final RuntimeException varR = new Excecao("teste");

		System.out.println(varE instanceof Estado);
		System.out.println(varA instanceof int[]);
		System.out.println(varA instanceof Object);
		System.out.println(varB instanceof File);
		System.out.println(varR instanceof Object);
		System.out.println(varR instanceof Exception);
		
		System.out.println(varA instanceof String);
		System.out.println(null instanceof Object);
		System.out.println(varR instanceof ArrayIndexOutOfBoundsException);
	}
}