package com.googlecode.exemplos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class UsuarioRepositoryDefault implements UsuarioRepository {

	@PersistenceContext
    private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public Usuario getFromUserId(String userid) {
		Query q = em.createNamedQuery("encontrePorNome");
		q.setParameter("userid", userid);
		List<Usuario> lc = q.getResultList();
		return lc.size() != 0 ? lc.get(0) : null;
	}
}
