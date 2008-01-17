package dezenove;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AtividadesAplicacao {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("jpaDezenove");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Atividade uma = newAtividade();
		em.persist(uma);
		tx.commit();
		em.close();
		
		System.out.println("Atividade persistida:\n" + uma);
				
		em = emf.createEntityManager();
		Atividade atv = em.find(Atividade.class, 1L);
		System.out.println("Atividade recuperada:\n" + atv);
	}

	public static Atividade newAtividade() {
		Calendar agora = Calendar.getInstance();

		Calendar noveHoras30minutos = Calendar.getInstance();
		noveHoras30minutos.set(Calendar.HOUR_OF_DAY, 9);
		noveHoras30minutos.set(Calendar.MINUTE, 30);

		Calendar amanha = Calendar.getInstance();
		amanha.add(Calendar.DAY_OF_MONTH, 1);

		Calendar umMesAposHoje = Calendar.getInstance();
		umMesAposHoje.add(Calendar.MONTH, 1);

		return new Atividade(agora.getTime(), noveHoras30minutos.getTime(),
				amanha.getTime(), umMesAposHoje);
	}
}
