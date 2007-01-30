package exp3;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class SingletonPrototypeTest extends TestCase {
	private final int TOTAL_INSTANCIAS = 5000;
	
	public void testMuitasInstancias() {
		ClassPathResource xml = new ClassPathResource("prototype.xml");
		XmlBeanFactory factory = new XmlBeanFactory(xml);

		Map<Prototype, Integer> mapa = new HashMap<Prototype, Integer>();
		int numInstancias = TOTAL_INSTANCIAS;
		while (numInstancias-- > 0) {
			mapa.put((Prototype) factory.getBean("prototipo"), numInstancias);
		}

		assertEquals(mapa.size(), TOTAL_INSTANCIAS);
		assertEquals(Prototype.getNumInstancias(), TOTAL_INSTANCIAS);	
	}
}
