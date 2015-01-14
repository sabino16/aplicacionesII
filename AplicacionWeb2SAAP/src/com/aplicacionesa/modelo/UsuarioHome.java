package com.aplicacionesa.modelo;

// Generated 14/01/2015 09:20:48 AM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



/**
 * Home object for domain model class Usuario.
 * @see com.aplicacionesa.modelo.Usuario
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
	
	public Usuario buscarUsuario(String identificador, String contrasena){
		try{
			Usuario usuario=null;
			String sql = "select u from Usuario as u where u.estado='1' and" +
					" u.user = :id and u.pass = :c";  
			usuario = (Usuario) getEntityManager().createQuery(sql).setParameter("id", identificador)
								.setParameter("c", contrasena).getSingleResult();
			return usuario;
			}catch(RuntimeException re){
				log.error("Error en datosUsuario: UsuarioHome" + re.getMessage());
				return null;
			}
	}
	
	public List<Usuario> filtrarPorApellidos(String apellido){
		try{
		List<Usuario> lista;
		String sql = "select u from Usuario as u where u.estado='1' and (u.apellido like :apellido)";  
	
		lista = entityManager.createQuery(sql).setParameter("apellido", "%"+apellido+"%").getResultList();
		return lista;
		}catch(RuntimeException re){
			log.error("Error en filtrarPorApellidos: UsuarioHome" + re.getMessage());
			return null;
		}
	}
	
	public List<Usuario> findAll() { //DEVUELVE UNA LISTA DE CLIENTES
		log.debug("getting usuario instance instances"); //IMPRIME EN CONSOLA UN MENSAJE
		try {
			List<Usuario> lista = entityManager.createQuery("from Usuario where estado='1'").getResultList();
			//EN HIBERNATE SE UTILIZA EL LENGUAJE HQL
			//SE ESCRIBE EL NOMBRE DE LA ENTIDAD LIBR O
			log.debug("get successful");	//MENSAJE EN CONSOLA
			return lista;
		} catch (RuntimeException re) {	 //POSIBLE EXCEPCION
			log.error("get failed in findAll: UsuarioHome", re);
			throw re;
		}
	}


	public List<Usuario> Reporte_Lista_Pasajeros(){
		log.debug("getting usuario instance instances"); //IMPRIME EN CONSOLA UN MENSAJE
		try {
			List<Usuario> lista = entityManager.createQuery("select u from Usuario u, TipoUsuario tu where u.tipoUsuario.idTipousuario = tu.idTipousuario and tu.idTipousuario = 1 and  u.estado='1'").getResultList();
			//EN HIBERNATE SE UTILIZA EL LENGUAJE HQL
			//SE ESCRIBE EL NOMBRE DE LA ENTIDAD LIBR O
			log.debug("get successful");	//MENSAJE EN CONSOLA
			return lista;
		} catch (RuntimeException re) {	 //POSIBLE EXCEPCION
			log.error("get failed in findAll: UsuarioHome", re);
			throw re;
		}
	}
	
	
	
	public List<Usuario> Reporte_Lista_Pasajeros_todos_filtros(String Nombre, String Apellido, String Cedula){
		log.debug("getting usuario instance instances"); //IMPRIME EN CONSOLA UN MENSAJE
		try {
			List<Usuario> lista = entityManager.createQuery("select u from Usuario u, TipoUsuario tu where u.tipoUsuario.idTipousuario = tu.idTipousuario and tu.idTipousuario = 1 and  u.estado='1' and u.nombre like :nombre and u.apellido like :apellido and u.cedula like :cedula" ).setParameter("nombre", "%"+ Nombre+ "%").setParameter("apellido", "%"+ Apellido+ "%").setParameter("cedula", "%"+ Cedula+ "%").getResultList();
			//EN HIBERNATE SE UTILIZA EL LENGUAJE HQL
			//SE ESCRIBE EL NOMBRE DE LA ENTIDAD LIBR O
			log.debug("get successful");	//MENSAJE EN CONSOLA
			return lista;
		} catch (RuntimeException re) {	 //POSIBLE EXCEPCION
			log.error("get failed in findAll: UsuarioHome", re);
			throw re;
		}
	}

	
}
