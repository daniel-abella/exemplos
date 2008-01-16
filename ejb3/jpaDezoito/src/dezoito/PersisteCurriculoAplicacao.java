package dezoito;

import java.io.FileInputStream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersisteCurriculoAplicacao {
	public static void main(String[] args) {
		newCurriculo("wp1.jpg", "texto.txt");
	}

	public static void persisteCurriculo(String foto, String texto) {
		Curriculo curriculo = newCurriculo(foto, texto);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaDezoito");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(curriculo);

		tx.commit();
		em.close();
	}
	
	public static Curriculo newCurriculo(String fotoFile, String textoFile) {
		byte[] ramFoto = new byte[200 * 1024];
		try {			
			FileInputStream fis = new FileInputStream(fotoFile);
			byte[] buffer = new byte[1024 * 4];
			int bytesLidos = -1;
			int inicio = 0;
			while ((bytesLidos = fis.read(buffer)) != -1) {
				System.arraycopy(buffer, 0, ramFoto, inicio, bytesLidos);
				inicio += bytesLidos;
			}
			fis.close();
		} catch (Exception e) {
			return null;
		}
		
		return new Curriculo(ramFoto,"");
	}
}
