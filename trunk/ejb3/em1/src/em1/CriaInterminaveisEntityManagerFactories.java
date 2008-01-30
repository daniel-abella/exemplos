package em1;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaInterminaveisEntityManagerFactories {

	public static void main(String[] args) {
		int contador = 0;
		EntityManagerFactory emf = null;
		while (true) {
			emf = Persistence.createEntityManagerFactory("em1");
			emf.close();
			if (++contador % 100 == 0)
				System.out.println(contador);
		}
	}
}
