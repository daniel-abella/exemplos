package set;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProgramaDisciplinaTest extends TestCase {

	public void testCasoSimples() {
		ApplicationContext appCtx;
		appCtx = new ClassPathXmlApplicationContext("set.xml");
		
		ProgramaDisciplina prg;
		prg = (ProgramaDisciplina) appCtx.getBean("prg");
		System.out.println(prg);
	}
}
