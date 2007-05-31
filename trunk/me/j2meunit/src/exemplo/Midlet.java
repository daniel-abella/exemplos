package exemplo;

import j2meunit.midletui.TestRunner;

public class Midlet extends TestRunner {
	
	protected void startApp() {	
		String[] tsts = { "exemplo.Teste1", "exemplo.Teste2" };
		start(tsts);
	}
}
