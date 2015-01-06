package com.aplicaciones.modelo;

// Generated 06/01/2015 03:56:21 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Carrera.
 * @see com.aplicaciones.modelo.Carrera
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
	
	public List<Carrera> findAll() { //DEVUELVE UNA LISTA DE CLIENTES
		log.debug("getting Reservacion instance instances"); //IMPRIME EN CONSOLA UN MENSAJE
		try {
			List<Carrera> lista = getEntityManager().createQuery("select c.* from usuario as u, taxi as tax, carrera as c, tarifa as t where c.id_usuario=u.id_usuario and c.id_taxi=tax.id_taxi and c.id_tarifa=t.id_tarifa  and u.estado='1' and tax.estado='1' and c.estado='1' and t.estado='1'").getResultList();
			//EN HIBERNATE SE UTILIZA EL LENGUAJE HQL
			//SE ESCRIBE EL NOMBRE DE LA ENTIDAD LIBR O
			log.debug("get successful");	//MENSAJE EN CONSOLA
			return lista;
		} catch (RuntimeException re) {	 //POSIBLE EXCEPCION
			log.error("get failed in findAll: CarreraHome", re);
			throw re;
		}
	}
	
	public List<Carrera> findAllHQL() { //DEVUELVE UNA LISTA DE CLIENTES
		log.debug("getting usuario instance instances"); //IMPRIME EN CONSOLA UN MENSAJE
		try {
			List<Carrera> lista = entityManager.createQuery("from Carrera where estado='1'").getResultList();
			//EN HIBERNATE SE UTILIZA EL LENGUAJE HQL
			//SE ESCRIBE EL NOMBRE DE LA ENTIDAD LIBR O
			log.debug("get successful");	//MENSAJE EN CONSOLA
			return lista;
		} catch (RuntimeException re) {	 //POSIBLE EXCEPCION
			log.error("get failed in findAll: CarreraHome", re);
			throw re;
		}
	}
	
	public List<Carrera> filtrarCompleto(String nombres, String apellidos){
		try{
		List<Carrera> lista;
		String sql = "select * from usuario as u, taxi as tax, carrera as c, tarifa as t"+ 
      "where c.id_usuario=u.id_usuario and"+ 
      "c.id_taxi=tax.id_taxi and"+
      "c.id_tarifa=t.id_tarifa"+  
      "and u.estado='1' and tax.estado='1' and c.estado='1' and t.estado='1' and " +
      "u.nombre= :nombres and u.apellidos= :apellidos and tax.placa= :placa";  
	
		lista = entityManager.createQuery(sql).setParameter("nombres", "%"+nombres+"%")
											.setParameter("apellidos", "%"+apellidos+"%").getResultList();
		return lista;
		}catch(RuntimeException re){
			log.error("Error en filtrarReservaciones: CarreraHome" + re.getMessage());
			return null;
		}
	}
	
	public List<Carrera> filtrarNombre(String nombres){
		try{
		List<Carrera> lista;
		String sql = "select * from usuario as u, taxi as tax, carrera as c, tarifa as t"+ 
      "where c.id_usuario=u.id_usuario and"+ 
      "c.id_taxi=tax.id_taxi and"+
      "c.id_tarifa=t.id_tarifa"+  
      "and u.estado='1' and tax.estado='1' and c.estado='1' and t.estado='1'"+
      "u.nombre= :nombres";  
	
		lista = entityManager.createQuery(sql).setParameter("nombres", "%"+nombres+"%").getResultList();
		return lista;
		}catch(RuntimeException re){
			log.error("Error en filtrarReservaciones: CarreraHome" + re.getMessage());
			return null;
		}
	}
	
	public List<Carrera> filtrarApellido(String apellidos){
		try{
		List<Carrera> lista;
		String sql = "select * from usuario as u, taxi as tax, carrera as c, tarifa as t"+ 
			      "where c.id_usuario=u.id_usuario and"+ 
			      "c.id_taxi=tax.id_taxi and"+
			      "c.id_tarifa=t.id_tarifa"+  
			      "and u.estado='1' and tax.estado='1' and c.estado='1' and t.estado='1'"+
			      "u.apellido= :apellidos";
		
		lista = entityManager.createQuery(sql).setParameter("apellidos", "%"+apellidos+"%").getResultList();
		return lista;
		}catch(RuntimeException re){
			log.error("Error en filtrarReservaciones: CarreraHome" + re.getMessage());
			return null;
		}
	}



	
	
}
