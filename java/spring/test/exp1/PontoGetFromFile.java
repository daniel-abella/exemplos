package exp1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import junit.framework.TestCase;

public class PontoGetFromFile extends TestCase {

	public void testObtemDeArquivo() {

		// Cria factory de beans (Spring)
		String arq = "src/exp1/exemplo.xml";
		FileSystemResource fileRes = new FileSystemResource(arq);
		BeanFactory factory = new XmlBeanFactory(fileRes);

		// Cria um bean da configuração obtida da URL
		Retangulo ret = (Retangulo) factory.getBean("retanguloPadrao");
		assertTrue(ret.getIe().getX() == -1);
		assertTrue(ret.getIe().getY() == 2);
	}
}
