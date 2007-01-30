package exp1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import junit.framework.TestCase;

public class PontoCompartilhadoTest extends TestCase {

	public void testCasoSimples() {
		ClassPathResource xml = new ClassPathResource("exemplo.xml");
		BeanFactory factory = new XmlBeanFactory(xml);

		long n = 1000 * 1000;
		long c = 0;
		Ponto pt;
		while (n-- > 0) {
			pt = null;
			pt = (Ponto) factory.getBean("inferiorEsquerdo");
			if (pt != null) {
				c = c + 1;
			}
		}
		System.out.println(n + " " + c);
	}
}