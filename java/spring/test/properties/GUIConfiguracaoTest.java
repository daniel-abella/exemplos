package properties;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GUIConfiguracaoTest extends TestCase {

	public void testIoC() {
		ApplicationContext appCtx;
		appCtx = new ClassPathXmlApplicationContext("gui.xml");
		
		GUIConfiguracao gui = (GUIConfiguracao) appCtx.getBean("gui");
		assertEquals(gui.getPropriedade("user"), "fulano");
		assertEquals(gui.getPropriedade("tela.x"), "10");
	}
	
	public void testProperties() throws Exception {
		GUIConfiguracao gui = new GUIConfiguracao();
		gui.leProperties("src/properties/gui.properties");
		
		assertEquals(gui.getPropriedade("user"), "fulano");
		assertEquals(gui.getPropriedade("tela.x"), "10");
		
	}
}
