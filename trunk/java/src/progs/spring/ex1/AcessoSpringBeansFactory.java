package ex1;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/**
 * Exemplo trivial do Spring Framework (beans factory)
 * Bibliotecas usadas: 
 * commons-logging.jar
 * spring-core.jar
 * 
 */
public class AcessoSpringBeansFactory {
    public static void main(String[] args) {
        Resource resource = new ClassPathResource("dados.xml");
        ListableBeanFactory bf = new XmlBeanFactory(resource);

        TiposBasicos tb = (TiposBasicos) bf.getBean("teste");
        System.out.println(tb);
    }
}
