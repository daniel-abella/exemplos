package exp1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import junit.framework.TestCase;

public class SingletonSpringTest extends TestCase {

	public void testSingleton() {
		ClassPathResource xml = new ClassPathResource("exemplo.xml");
		BeanFactory factory = new XmlBeanFactory(xml);
		
		Ponto pt1 = (Ponto) factory.getBean("inferiorEsquerdo");
		Ponto pt2 = (Ponto) factory.getBean("inferiorEsquerdo");

		assertTrue(factory.isSingleton("inferiorEsquerdo"));
		assertTrue(pt1 == pt2);
	}

}
