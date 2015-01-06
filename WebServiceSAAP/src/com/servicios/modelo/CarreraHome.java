package com.servicios.modelo;

// Generated 31/12/2014 10:18:01 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * Home object for domain model class Carrera.
 * @see com.servicios.modelo.Carrera
 * @author Hibernate Tools
 */
@Stateless
public class CarreraHome {

	private static final Log log = LogFactory.getLog(CarreraHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void persist(Carrera transientInstance) {
		log.debug("persisting Carrera instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Carrera persistentInstance) {
		log.debug("removing Carrera instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Carrera merge(Carrera detachedInstance) {
		log.debug("merging Carrera instance");
		try {
			Carrera result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Carrera findById(Integer id) {
		log.debug("getting Carrera instance with id: " + id);
		try {
			Carrera instance = entityManager.find(Carrera.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
		
	public Carrera Servicio_Consultar_Carrera(int idCarrera){
		try{
		Carrera carrera;
		String sql = "select c from Carrera c, Usuario u, Tarifa t where c.usuario.idUsuario = u.idUsuario and c.tarifa.idTarifa = t.idTarifa and u.estado='1' and c.estado='1' and t.estado='1' and c.idCarrera= :idCarrera";
		
		carrera = (Carrera) entityManager.createQuery(sql).setParameter("idCarrera",idCarrera).getSingleResult();
		return carrera;
		}catch(RuntimeException re){
			log.error("Error en filtrarReservaciones: CarreraHome" + re.getMessage());
			return null;
		}
	}

	
		
}
