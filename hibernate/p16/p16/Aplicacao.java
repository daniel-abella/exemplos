package p16;

import java.util.Collections;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Aplicacao {
	private static ClassPathXmlApplicationContext ctx;
	
	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ClasseDao classeDao = (ClasseDao) ctx.getBean("classeDao");
		System.out.println(classeDao.objetos());
		
		Classe obj1 = new Classe();		
		Classe obj2 = new Classe();
		
		classeDao.save(obj1);
		classeDao.save(obj2);
		
		List<Classe> lista = classeDao.objetos();
		Collections.sort(lista);
		System.out.println(lista);
	}
}