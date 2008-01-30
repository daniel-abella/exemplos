package em1;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaAlgunsEntityManagerFactories {

	public static void main(String[] args) {
		int contador = 0;
		EntityManagerFactory emf = null;
		while (true) {
			emf = Persistence.createEntityManagerFactory("em1");
			// N�o libera recursos, em algun instante, ser� gerada
			// a exce��o java.lang.OutOfMemoryError!!!!
			// emf.close();
			if (++contador % 100 == 0)
				System.out.println(contador);
		}
	}
}
