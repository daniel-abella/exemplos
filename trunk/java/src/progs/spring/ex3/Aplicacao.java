package ex3;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Aplicacao {
    public static final ListableBeanFactory bf;
    
    static {
        Resource resource = new ClassPathResource("dados.xml");
        bf = new XmlBeanFactory(resource);
    }
}
