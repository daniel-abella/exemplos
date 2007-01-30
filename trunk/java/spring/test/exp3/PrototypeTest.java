package exp3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import junit.framework.TestCase;

public class PrototypeTest extends TestCase {

	public void testCasoSimples() {
		ClassPathResource xml = new ClassPathResource("prototype.xml");
		BeanFactory factory = new XmlBeanFactory(xml);
		
		Prototype p1 = (Prototype) factory.getBean("prototipo");		
		assertNotNull(p1.getProximo());
		assertNull(p1.getProximo().getProximo());
		assertEquals(p1.getProximo().getValor(), -1.0);
		
		Prototype p2 = (Prototype) factory.getBean("prototipo");		
		assertNotSame(p1,p2);
		assertSame(p1.getProximo(), p2.getProximo());
		
		// Comprovar diferenças
		assertEquals(p1.getValor(), p2.getValor());
		p1.setValor(45);
		p2.setValor(50);
		assertFalse(p1.getValor() == p2.getValor());
		
		p1.getProximo().setValor(45678);
		p2.getProximo().setValor(4);
		assertTrue(p1.getProximo().getValor() == 4);
	}
}
