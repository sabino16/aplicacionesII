package com.servicio.modelo;

// Generated 09/12/2014 03:58:34 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Usuario.
 * @see com.servicio.modelo.Usuario
 * @author Hibernate Tools
 */
@Stateless
public class UsuarioHome {

	private static final Log log = LogFactory.getLog(UsuarioHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void persist(Usuario transientInstance) {
		log.debug("persisting Usuario instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Usuario persistentInstance) {
		log.debug("removing Usuario instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Usuario merge(Usuario detachedInstance) {
		log.debug("merging Usuario instance");
		try {
			Usuario result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Usuario findById(Integer id) {
		log.debug("getting Usuario instance with id: " + id);
		try {
			Usuario instance = entityManager.find(Usuario.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	
	
	public Usuario consultarusuario(int idUsuario){
		try{
		Usuario usuario;
		String sql = "select * from usuario as u, carrera as c, tarifa as t"+ 
			      "where c.id_usuario=u.id_usuario and"+
			      "c.id_tarifa=t.id_tarifa"+  
			      "and u.estado='1' and tax.estado='1' and c.estado='1' and t.estado='1'"+
			      "u.apellido= :apellidos";
		
		usuario = (Usuario) entityManager.createQuery(sql).setParameter("idUsuario",idUsuario).getResultList();
		return usuario;
		}catch(RuntimeException re){
			log.error("Error en filtrarReservaciones: CarreraHome" + re.getMessage());
			return null;
		}
	}
	
	
	
}