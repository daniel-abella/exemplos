package exemplo;

import j2meunit.framework.Test;
import j2meunit.framework.TestCase;
import j2meunit.framework.TestMethod;
import j2meunit.framework.TestSuite;
import j2meunit.textui.TestRunner;

public class ConsoleTestes extends TestCase {
	
	public ConsoleTestes() {}
	public ConsoleTestes(String str, TestMethod tm) {
		super(str,tm);
	}
	
	public Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTest(new Teste1().suite());
		suite.addTest(new Teste2().suite());
		return suite;
	}
	
	public static void main(String[] args) {		
		// Execute os testes (saída no console)
		//TestRunner.main(tsts);
		TestRunner.main(new String[] { "exemplo.ConsoleTestes" } );
	}	
}