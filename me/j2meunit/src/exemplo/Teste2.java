package exemplo;

import j2meunit.framework.Test;
import j2meunit.framework.TestCase;
import j2meunit.framework.TestMethod;
import j2meunit.framework.TestSuite;

public class Teste2 extends TestCase {
	private String variavelNull;
	
	public Teste2() {}

	public Teste2(String str, TestMethod tm) {
		super(str, tm);
	}

	public Test suite() {
		TestMethod t1 = new TestMethod() {
			public void run(TestCase tc) {
				((Teste2) tc).testJamaisNull();
			}
		};
		
		TestMethod t2 = new TestMethod() {
			public void run(TestCase tc) {
				((Teste2) tc).testSempreNull();
			}
		};
			
		TestSuite suite = new TestSuite("simples teste");
		suite.addTest(new Teste2("testJamaisNull", t1));
		suite.addTest(new Teste2("testSempreNull", t2));
		return suite;
	}

	public void testJamaisNull() {
		assertNotNull(this);
	}
	
	public void testSempreNull() {
		assertNull(variavelNull);
	}
}