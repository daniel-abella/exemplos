package map;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DisciplinaRepositoryTest extends TestCase {

	public void testCasoSimples() {
		ApplicationContext appCtx;
		appCtx = new ClassPathXmlApplicationContext("map.xml");

		DisciplinaRepository dr;
		dr = (DisciplinaRepository) appCtx.getBean("disciplinas");
		assertEquals(dr.size(), 2);

		assertEquals(dr.getDisciplinas().toString(),
				"{poo=poo POO, jboss=jboss JBoss}");
	}
}
