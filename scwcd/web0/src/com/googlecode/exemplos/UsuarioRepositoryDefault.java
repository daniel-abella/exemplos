package com.googlecode.exemplos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class UsuarioRepositoryDefault implements UsuarioRepository {
	
	private EntityManagerFactory emf;
	
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Usuario getFromUserId(String userid) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		Query q = em.createNamedQuery("encontrePorNome");
		q.setParameter("userid", userid);
		List<Usuario> lc = q.getResultList();
		Usuario retorno = lc.size() != 0 ? lc.get(0) : null;
		etx.commit();
		return retorno;
	}
}
