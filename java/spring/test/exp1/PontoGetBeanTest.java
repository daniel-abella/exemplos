package exp1;

import junit.framework.TestCase;

public class PontoGetBeanTest extends TestCase {

	public void testCasoSimples() {
		Ponto ie = PontoFactory.criaPonto("inferiorEsquerdo");
		assertTrue(ie.getX() == -1);
		assertTrue(ie.getY() == 2);

		Ponto sd = PontoFactory.criaPonto("superiorDireito");
		assertTrue(sd.getX() == 5);
		assertTrue(sd.getY() == 9);
	}
}
