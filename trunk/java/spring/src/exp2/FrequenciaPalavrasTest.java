package exp2;

import junit.framework.TestCase;

public class FrequenciaPalavrasTest extends TestCase {

	public void testCasoSimples() {
		String[] strs = { "a", "b", "a", "a", "c" };
		
		FrequenciaPalavras.getFrequencia(strs);
		int n = FrequenciaPalavras.getTotalPalDistintas();
		
		assertTrue(n == 3);
		
		n = FrequenciaPalavras.getFrequencia("c");
		assertTrue(n == 1);
		
		n = FrequenciaPalavras.getFrequencia("x");
		assertTrue(n == 0);
	}
}
