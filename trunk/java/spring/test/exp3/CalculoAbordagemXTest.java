package exp3;

import java.util.Enumeration;

import junit.framework.TestCase;

public class CalculoAbordagemXTest extends TestCase {

	public void testCasoSimples() {
		ICalculo obj = new CalculoAbordagemX();		
		assertTrue(obj.media(new Dados()) == 3.0);
	}
}

class Dados implements Enumeration {
	transient private final Integer[] ints = new Integer[] { 1, 2, 6 };

	private int contador = 0;
	
	public boolean hasMoreElements() {		
		return contador < ints.length;
	}

	public Object nextElement() {
		return ints[contador++];
	}	
}
