package com.googlecode.exemplos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

public class UsuarioRepositoryDefault implements UsuarioRepository {

    private EntityManagerFactory emf;	

    @PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@SuppressWarnings("unchecked")
	public Usuario getFromUserId(String userid) {
		EntityManager em = emf.createEntityManager();
		//Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.userid = :userid");
		Query q = em.createNamedQuery("userid");
		q.setParameter("userid", userid);
		List<Usuario> lc = q.getResultList();
		
		if (lc != null && lc.size() > 0)
			return (Usuario) lc.get(0);
		else 
			return null;
	}
}
