package exemplo;

import j2meunit.framework.Test;
import j2meunit.framework.TestCase;
import j2meunit.framework.TestMethod;
import j2meunit.framework.TestSuite;

public class Teste2 extends TestCase {
	public Teste2() {
	}

	public Teste2(String str, TestMethod tm) {
		super(str, tm);
	}

	public Test suite() {
		TestSuite suite = new TestSuite("simples teste");
		suite.addTest(new Teste2("testJamaisNull", new TestMethod() {
			public void run(TestCase tc) {
				((Teste2) tc).testJamaisNull();
			}
		}));
		return suite;
	}

	public void testJamaisNull() {
		assertNotNull(this);
	}

}
