package exp1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Factory {
	private static ClassPathResource xml;
	
	private static BeanFactory factory;
	
	static {
		xml = new ClassPathResource("exemplo.xml");
	    factory = new XmlBeanFactory(xml);
	}	
	
	public static Object getInstancia(String nome) {
		return factory.getBean(nome);
	}
}
