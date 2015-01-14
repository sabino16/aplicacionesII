package com.serviciosa.modelo;

// Generated 14/01/2015 08:56:38 AM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * Home object for domain model class Usuario.
 * @see com.serviciosa.modelo.Usuario
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
	
	
	public Usuario Servicio_Login(String user, String contrasena)
	{
		try{
			Usuario usuario;
			String sql="select u from Usuario u, TipoUsuario tu where u.tipoUsuario.idTipousuario = tu.idTipousuario and u.user = :userr and u.pass = :passs and  u.estado='1'";
			
			usuario =  (Usuario) entityManager.createQuery(sql).setParameter("userr", user).setParameter("passs", contrasena).getSingleResult();
			
			return usuario;
		}catch(RuntimeException re){
			log.error("Error en iniciarsesion: UsuarioHome" + re.getMessage());
			return null;
		}
	}
	
	
	public List<Usuario> iniciarsesion(String user, String contrasena){
		try{
		List<Usuario> usuario;
		String sql = "select u from Usuario as u "+ 
			      "where u.user = :userr and u.pass = :passs and"+
			      " u.estado='1' and u.tipoUsuario.idTipousuario = 1";  
	
		usuario = entityManager.createQuery(sql).setParameter("userr", user)
														.setParameter("passs", contrasena)
							.getResultList();
		return usuario;
		}catch(RuntimeException re){
			log.error("Error en iniciarsesion: UsuarioHome" + re.getMessage());
			return null;
		}
	}
	
	public List<Usuario> validacionusuario(String user){
		try{
		List<Usuario> usuario;
		String sql = "select u from Usuario as u "+ 
			      "where u.user = :userr and"+
			      " u.estado='1' and u.tipoUsuario.idTipousuario = 1";  
	
		usuario = entityManager.createQuery(sql).setParameter("userr", user)
							.getResultList();
		return usuario;
		}catch(RuntimeException re){
			log.error("Error en iniciarsesion: UsuarioHome" + re.getMessage());
			return null;
		}
	}

}
