package exp1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import junit.framework.TestCase;

public class RetanguloGetBeanTest extends TestCase {

	public void testCasoSimples() {
		ClassPathResource xml = new ClassPathResource("exemplo.xml");
		BeanFactory factory = new XmlBeanFactory(xml);

		Retangulo ret = (Retangulo) factory.getBean("retanguloPadrao");
		assertTrue(ret.getIe().getX() == -1);
		assertTrue(ret.getIe().getY() == 2);
	}
}
