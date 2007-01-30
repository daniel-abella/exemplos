package exp1;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PontoApplicationContextTest extends TestCase {
	
	public void testCasoSimples() {
		String arq = "exemplo.xml";
		ApplicationContext appCtx;
		appCtx = new ClassPathXmlApplicationContext(arq);
		
		Ponto p1 = (Ponto) appCtx.getBean("inferiorEsquerdo");
		assertEquals(p1.getX(), -1);
		assertEquals(p1.getY(), 2);			
	}

}
