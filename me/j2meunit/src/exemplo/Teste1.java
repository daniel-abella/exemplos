package exemplo;

import j2meunit.framework.Test;
import j2meunit.framework.TestCase;
import j2meunit.framework.TestMethod;
import j2meunit.framework.TestSuite;

public class Teste1 extends TestCase {
	public Teste1() {
	}

	public Teste1(String str, TestMethod tm) {
		super(str, tm);
	}

	public Test suite() {
		TestSuite suite = new TestSuite("simples teste");
		suite.addTest(new Teste1("testSempreIguais", new TestMethod() {
			public void run(TestCase tc) {
				((Teste1) tc).testSempreIguais();
			}
		}));
		return suite;
	}

	public void testSempreIguais() {
		assertEquals(1l, 1l);
	}
}
