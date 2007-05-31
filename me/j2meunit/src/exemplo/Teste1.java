package exemplo;

import j2meunit.framework.Test;
import j2meunit.framework.TestCase;
import j2meunit.framework.TestMethod;
import j2meunit.framework.TestSuite;

public class Teste1 extends TestCase {

	public Teste1() {}

	public Teste1(String str, TestMethod tm) {
		super(str, tm);
	}
	
	public void testSempreIguais() {
		assertEquals(1l, 1l);
	}

	public Test suite() {
		// uma instância para cada método a ser testado (conforme ilustrado)
		TestMethod t1 = new TestMethod() {
			public void run(TestCase tc) {
				((Teste1) tc).testSempreIguais();
			}
		};
		
		TestSuite suite = new TestSuite("simples teste");
		suite.addTest(new Teste1("testSempreIguais", t1));			
		return suite;
	}
}