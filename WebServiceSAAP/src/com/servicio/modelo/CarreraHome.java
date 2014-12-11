package com.servicio.modelo;

// Generated 09/12/2014 03:58:34 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



/**
 * Home object for domain model class Carrera.
 * @see com.servicio.modelo.Carrera
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
	
	
	
	public Carrera consultarcarrera(int idCarrera){
		try{
		Carrera carrera;
		String sql = "select * from usuario as u, carrera as c, tarifa as t"+ 
			      "where c.id_usuario=u.id_usuario and"+
			      "c.id_tarifa=t.id_tarifa"+  
			      "and u.estado='1' and tax.estado='1' and c.estado='1' and t.estado='1'"+
			      "u.apellido= :apellidos";
		
		carrera = (Carrera) entityManager.createQuery(sql).setParameter("idCarrera",idCarrera).getResultList();
		return carrera;
		}catch(RuntimeException re){
			log.error("Error en filtrarReservaciones: CarreraHome" + re.getMessage());
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Carrera> consultarcarrera(){
		try{
		List<Carrera> lista;
		lista = getEntityManager().createQuery("select c.* from usuario as u,"+
				"carrera as c, tarifa as t where c.id_usuario=u.id_usuario and"+ 
				"c.id_tarifa=t.id_tarifa  and u.estado='1' and c.estado='1' and"+
				"t.estado='1'").getResultList();
		return lista;
		}catch(RuntimeException re){
			log.error("Error en filtrarReservaciones: CarreraHome" + re.getMessage());
			return null;
		}
	}
	
}
