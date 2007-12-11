package dominio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Implementa reposit�rio para Conteiner. 
 * 
 * <br>N�o h� demarca��o expl�cita de transa��o.
 * <br><i>EntityManager</i> � injetado via anota��o <i>PersistenceContext</i>.
 * @author F�bio Nogueira de Lucena
 *
 */
public class ConteinerRepositoryDefault implements ConteinerRepository {
	
	@PersistenceContext
    private EntityManager em;

	public void persiste(Conteiner conteiner) {
		em.persist(conteiner);
	}

	@SuppressWarnings("unchecked")
	public Conteiner obtem(String nome) {
		Query q = em.createNamedQuery("encontrePorNome");
		q.setParameter("nome", nome);
		List<Conteiner> lc = q.getResultList();
		return lc.size() != 0 ? lc.get(0) : null;
	}
	
	public void remove(Conteiner obj) {
		em.remove(obj);
	}
	
	public void atualiza(Conteiner obj) {
		em.merge(obj);
	}
}
