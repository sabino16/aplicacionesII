package com.aplicaciones.modelo;

// Generated 06/01/2015 03:56:21 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Tarifa.
 * @see com.aplicaciones.modelo.Tarifa
 * @author Hibernate Tools
 */
@Stateless
public class TarifaHome {

	private static final Log log = LogFactory.getLog(TarifaHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void persist(Tarifa transientInstance) {
		log.debug("persisting Tarifa instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Tarifa persistentInstance) {
		log.debug("removing Tarifa instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Tarifa merge(Tarifa detachedInstance) {
		log.debug("merging Tarifa instance");
		try {
			Tarifa result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Tarifa findById(Integer id) {
		log.debug("getting Tarifa instance with id: " + id);
		try {
			Tarifa instance = entityManager.find(Tarifa.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	
}
