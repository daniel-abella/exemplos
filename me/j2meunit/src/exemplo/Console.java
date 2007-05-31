package exemplo;

import j2meunit.framework.Test;
import j2meunit.framework.TestCase;
import j2meunit.framework.TestSuite;
import j2meunit.textui.TestRunner;

public class Console extends TestCase {
	
	public Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTest(new Teste1().suite());
		suite.addTest(new Teste2().suite());
		return suite;
	}
	
	public static void main(String[] args) {		
		String[] tsts = { "exemplo.Console" };
		TestRunner.main(tsts);
	}	
}