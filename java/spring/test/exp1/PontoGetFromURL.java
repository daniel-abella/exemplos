package exp1;

import java.net.MalformedURLException;
import java.net.URL;

import junit.framework.TestCase;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.UrlResource;

public class PontoGetFromURL extends TestCase {

	public void testObtemDeURL() {
		
		// Monta URL onde se encontra arquivo de configuração
		URL url = null;
		try {
			String host = "http://www.inf.ufg.br/~fabio/spring.xml";
			url = new URL(host);
		} catch (MalformedURLException e) {
			fail("URL está correta!");
		}
		
		// Cria factory de beans (Spring)
		UrlResource urlRes = new UrlResource(url);
		BeanFactory factory = new XmlBeanFactory(urlRes);

		// Cria um bean da configuração obtida da URL
		Retangulo ret = (Retangulo) factory.getBean("retanguloPadrao");
		assertTrue(ret.getIe().getX() == -1);
		assertTrue(ret.getIe().getY() == 2);
	}
}
