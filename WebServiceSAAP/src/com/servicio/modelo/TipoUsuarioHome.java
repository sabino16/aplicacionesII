package com.servicio.modelo;

// Generated 09/12/2014 03:58:34 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class TipoUsuario.
 * @see com.servicio.modelo.TipoUsuario
 * @author Hibernate Tools
 */
@Stateless
public class TipoUsuarioHome {

	private static final Log log = LogFactory.getLog(TipoUsuarioHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void persist(TipoUsuario transientInstance) {
		log.debug("persisting TipoUsuario instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TipoUsuario persistentInstance) {
		log.debug("removing TipoUsuario instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TipoUsuario merge(TipoUsuario detachedInstance) {
		log.debug("merging TipoUsuario instance");
		try {
			TipoUsuario result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TipoUsuario findById(Integer id) {
		log.debug("getting TipoUsuario instance with id: " + id);
		try {
			TipoUsuario instance = entityManager.find(TipoUsuario.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
