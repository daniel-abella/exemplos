package exp3;

import java.util.Enumeration;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Aplicacao {
	
	public static void fazAlgo() {
		// ICalculo calculo = CalculoFactory.newICalculo();
		// double d = calculo.media(DadosFactory.newDados());

		ClassPathResource xml = new ClassPathResource("nossoFactory.xml");
		BeanFactory factory = new XmlBeanFactory(xml);

		ICalculo calculo = (ICalculo) factory.getBean("calculo");
		double d = calculo.media((Enumeration) factory.getBean("dados"));
		System.out.println(d);
	}
	
	public static void main(String[] args) {
		fazAlgo();
	}
}

class DadosXML implements Enumeration {
	transient private final Integer[] ints = new Integer[] { 1, 2, 9 };

	private int contador = 0;
	
	public boolean hasMoreElements() {		
		return contador < ints.length;
	}

	public Object nextElement() {
		return ints[contador++];
	}	
}

class DadosSGBD implements Enumeration {
	transient private final Integer[] ints = new Integer[] { 1, 2, 6 };

	private int contador = 0;
	
	public boolean hasMoreElements() {		
		return contador < ints.length;
	}

	public Object nextElement() {
		return ints[contador++];
	}	
}
