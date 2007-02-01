package p02;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.cfg.Configuration;

public class BemVindoHibernate {
	public static void main(String[] args) {
		// Configura Log4j sem exigir arquivo
		BasicConfigurator.configure();

		// Hibernate procura por 'hibernate.properties'
		// Deve estar disponível no CLASSPATH
		new Configuration();
		
		System.out.println("Bem-vindo ao curso de Hibernate");
	}
}