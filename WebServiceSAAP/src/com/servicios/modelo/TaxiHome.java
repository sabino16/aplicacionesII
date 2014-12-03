package com.servicios.modelo;

// Generated 03/12/2014 01:14:00 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Taxi.
 * @see com.servicios.modelo.Taxi
 * @author Hibernate Tools
 */
@Stateless
public class TaxiHome {

	private static final Log log = LogFactory.getLog(TaxiHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Taxi transientInstance) {
		log.debug("persisting Taxi instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Taxi persistentInstance) {
		log.debug("removing Taxi instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Taxi merge(Taxi detachedInstance) {
		log.debug("merging Taxi instance");
		try {
			Taxi result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Taxi findById(Integer id) {
		log.debug("getting Taxi instance with id: " + id);
		try {
			Taxi instance = entityManager.find(Taxi.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
