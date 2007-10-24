package com.googlecode.exemplos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UsuarioRepositoryDefault implements UsuarioRepository {
	
	private EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Usuario getFromUserId(String userid) {
		Query q = em.createNamedQuery("encontrePorNome");
		q.setParameter("userid", userid);
		List<Usuario> lc = q.getResultList();
		Usuario retorno = lc.size() != 0 ? lc.get(0) : null;
		return retorno;
	}
}