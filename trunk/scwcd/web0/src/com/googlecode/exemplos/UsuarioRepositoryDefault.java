package com.googlecode.exemplos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UsuarioRepositoryDefault implements UsuarioRepository {
	
	/*
	 * EntityManager em n�o est� sendo empregado. � injetado pelo Spring.
	 * Contudo, uma exce��o informa que a transa��o n�o pode ser obtida por
	 * meio de EntityManager shared. Ou seja, � indicado o emprego de 
	 * transa��es pelo Spring. Enquanto isto, usa-se a inje��o de 
	 * EntityManagerFactory que cria um EntityManager n�o compartilhado.
	 */
	private EntityManager em;
	private EntityManagerFactory emf;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	@PersistenceUnit
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
