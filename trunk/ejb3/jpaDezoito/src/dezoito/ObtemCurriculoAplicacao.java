package dezoito;

import java.io.FileOutputStream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ObtemCurriculoAplicacao {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaDezoito");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		// Supõe a existência de instância com id de valor 1
		Curriculo curriculo = (Curriculo) em.find(Curriculo.class, 1);

		tx.commit();
		em.close();
		
		criaCopiaCurriculo(curriculo,"outro.jpg", "");
	}
	
	public static void criaCopiaCurriculo(Curriculo curriculo, String fotoFile, String textoFile) {
		try {			
			FileOutputStream fos = new FileOutputStream(fotoFile);
			fos.write(curriculo.getFoto());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
