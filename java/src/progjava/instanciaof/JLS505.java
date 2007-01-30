package progjava.instanciaof;

class Point {}
class Element {}

public class JLS505 {
	public static void main(String... args) {
		// Uma referência para Object pode referenciar
		// um objeto de qualquer classe em Java.
		Object p = new Point();
		Object e = new Element();		
		System.out.println(e instanceof Point);
		System.out.println(p instanceof Element);
		System.out.println(e instanceof RuntimeException);
		
		// Uma referência para Element só pode reter um objeto
		// do tipo Element ou de qualquer classe derivada de 
		// Element. Observe que, em tempo de compilação, pode-se
		// verificar se a construção instanceof pode produzir um
		// resultado positivo ou sempre um negativo. Este último
		// caso é tratado como erro. Se o casting for retirado da
		// segunda sentença abaixo, então teremos um erro de 
		// compilação
		
		Element outroE = new Element();
		System.out.println(((Object)outroE) instanceof Point); // Não compila sem cast
	}
}
