package list;

import junit.framework.TestCase;
import list.Departamento;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class DepartamentoTest extends TestCase {

	public void testCasoSimples() {
		ApplicationContext appCtx;
		String arq = "src/list/escola.xml";
		appCtx = new FileSystemXmlApplicationContext(arq);
		
		Departamento d = (Departamento) appCtx.getBean("departamento");
		assertEquals(d.toString(), "[Afonso, Beltrano, Afonso]");
	}
}
