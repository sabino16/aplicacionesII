package com.serviciosa.modelo;

// Generated 14/01/2015 08:56:38 AM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * Home object for domain model class Carrera.
 * @see com.serviciosa.modelo.Carrera
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
	
	
	public List<Carrera> Servicio_Consultar_Carrera_usuario(int idUsuario){
		try{
		List<Carrera> lista;
		String sql = "select c from Carrera c, Usuario u, Tarifa t where c.usuario.idUsuario = u.idUsuario and c.tarifa.idTarifa = t.idTarifa and u.estado='1' and c.estado='1' and t.estado='1' and c.usuario.idUsuario = :idUsuario";
		
		lista = entityManager.createQuery(sql).setParameter("idUsuario", idUsuario).getResultList();
		return lista;
		}catch(RuntimeException re){
			log.error("Error en filtrarUsuario: CarreraHome" + re.getMessage());
			return null;
		}
	}
	
	public List<Carrera> Servicio_Consultar_Carrera_fechas(String f_inicio, String f_fin, int idUsuario){
		try{
		List<Carrera> lista;
		String sql = "select c from Carrera c, Usuario u, Tarifa t where c.usuario.idUsuario = u.idUsuario and c.tarifa.idTarifa = t.idTarifa and u.estado='1' and c.estado='1' and t.estado='1' and fecha >= :f_inicio and fecha <= :f_fin  and c.usuario.idUsuario = :idUsuario";
		
		lista = entityManager.createQuery(sql).setParameter("f_inicio", f_inicio).setParameter("f_fin", f_fin).setParameter("idUsuario", idUsuario).getResultList();
		return lista;
		}catch(RuntimeException re){
			log.error("Error en filtrarUsuario: CarreraHome" + re.getMessage());
			return null;
		}
	}
	
	
	public List<Carrera> Servicio_Consultar_Carrera_origen_destino(String parametro, int idUsuario){
		try{
		List<Carrera> lista;
		String sql = "select c from Carrera c, Usuario u, Tarifa t where c.usuario.idUsuario = u.idUsuario and c.tarifa.idTarifa = t.idTarifa and u.estado='1' and c.estado='1' and t.estado='1' and (c.origen like :parametro or c.destino like :parametro)  and c.usuario.idUsuario = :idUsuario";
		
		lista = entityManager.createQuery(sql).setParameter("parametro", "%"+parametro+"%").setParameter("idUsuario", idUsuario).getResultList();
		return lista;
		}catch(RuntimeException re){
			log.error("Error en filtrarUsuario: CarreraHome" + re.getMessage());
			return null;
		}
	}
	

	
}
