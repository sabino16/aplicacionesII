package com.aplicaciones.modelo;

// Generated 06/01/2015 03:56:21 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
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
	
	
	

public List<Carrera> findAllIdUsuario(int IdUsuario) { //DEVUELVE UNA LISTA DE CLIENTES
		log.debug("getting usuario instance instances"); //IMPRIME EN CONSOLA UN MENSAJE
		try {
			List<Carrera> lista = entityManager.createQuery("from Carrera where estado='1' and usuario.idUsuario = :id ").setParameter("id", IdUsuario).getResultList();
			//EN HIBERNATE SE UTILIZA EL LENGUAJE HQL
			//SE ESCRIBE EL NOMBRE DE LA ENTIDAD LIBR O
			log.debug("get successful");	//MENSAJE EN CONSOLA
			return lista;
		} catch (RuntimeException re) {	 //POSIBLE EXCEPCION
			log.error("get failed in findAll: CarreraHome", re);
			throw re;
		}
	}
	
	
	public List<Carrera> findAllIdUsuarioFiltrosTodos(int IdUsuario, String tarifa, String origen, String destino ) { //DEVUELVE UNA LISTA DE CLIENTES
		log.debug("getting usuario instance instances"); //IMPRIME EN CONSOLA UN MENSAJE
		try {
			List<Carrera> lista = entityManager.createQuery("from Carrera where estado='1' and usuario.idUsuario = :id and tarifa.tipoTarifa like :tarifa and origen like :origen and destino like :destino ").setParameter("id", IdUsuario).setParameter("tarifa", "%"+tarifa+"%").setParameter("origen", "%"+origen+"%").setParameter("destino", "%"+destino+"%").getResultList();
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


	public List<Carrera> filtarcamposStringHQL(String usuario , String tarifa, String origen, String destino, String tiempo){
		try{
		List<Carrera> lista;
		String sql = "select c from Carrera as c where c.estado = '1' and (c.usuario.user like :criterio1 and " +
				"c.tarifa.tipoTarifa like :criterio2 and c.origen like :criterio3 and c.destino like :criterio4 and " +
				"c.tiempo like :criterio5 )";
		lista = getEntityManager().createQuery(sql).setParameter("criterio1","%" + usuario + "%")
													.setParameter("criterio2", "%" + tarifa + "%")
													.setParameter("criterio3", "%" + origen + "%")
													.setParameter("criterio4", "%" + destino + "%")
													.setParameter("criterio5", "%" + tiempo + "%")
													.getResultList();
		
		return lista;
		}catch(RuntimeException re){
			log.error("error en filtrar por usuario, tarifa, origen, destino y tiempo" +re.getMessage());
			return null;
		}
	}

	/*
	public List<Carrera> filtarcamposDoubleKmHQL(Double km_recorridos){
		try{
		List<Carrera> lista;
		String sql = "select c from Carrera as c where c.estado = '1' and (c.km_recorridos = :criterio1)";
		lista = getEntityManager().createQuery(sql).setParameter("criterio1", km_recorridos).getResultList();
		
		return lista;
		}catch(RuntimeException re){
			log.error("error en filtrar por km CarreraHome" +re.getMessage());
			return null;
		}
	}
	
	public List<Carrera> filtarcamposDoublePrecioHQL(Double precio){
		try{
		List<Carrera> lista;
		String sql = "select c from Carrera as c where c.estado = '1' and (c.precio = :criterio1)";
		lista = getEntityManager().createQuery(sql).setParameter("criterio1", precio).getResultList();
		
		return lista;
		}catch(RuntimeException re){
			log.error("error en filtrar por precio CarreraHome" +re.getMessage());
			return null;
		}
	}
	
	public List<Carrera> filtarcamposFechaHQL(Date fecha){
		try{
		List<Carrera> lista;
		String sql = "select c from Carrera as c where c.estado = '1' and (c.fecha between" +
				" :criterio1 and :criterio2)";
		lista = getEntityManager().createQuery(sql).setParameter("criterio1", fecha)
				.setParameter("criterio2", fecha).getResultList();
		
		return lista;
		}catch(RuntimeException re){
			log.error("error en filtrar por fecha CarreraHome" +re.getMessage());
			return null;
		}
	}*/
	
	public List<Carrera> filtarcamposStringKmHQL(String usuario , String tarifa, String origen, String destino, 
			String tiempo, Double km){
		try{
		List<Carrera> lista;
		String sql = "select c from Carrera as c where c.estado = '1' and (c.usuario.user like :criterio1 and " +
				"c.tarifa.tipoTarifa like :criterio2 and c.origen like :criterio3 and c.destino like :criterio4 and " +
				"c.tiempo like :criterio5 and c.kmRecorridos = :criterio6)";
		lista = getEntityManager().createQuery(sql).setParameter("criterio1","%" + usuario + "%")
													.setParameter("criterio2", "%" + tarifa + "%")
													.setParameter("criterio3", "%" + origen + "%")
													.setParameter("criterio4", "%" + destino + "%")
													.setParameter("criterio5", "%" + tiempo + "%")
													.setParameter("criterio6",km)
													.getResultList();
		
		return lista;
		}catch(RuntimeException re){
			log.error("error en filtrar por usuario, tarifa, origen, destino, tiempo y km" +re.getMessage());
			return null;
		}
	}
	
	public List<Carrera> filtarcamposStringPrecioHQL(String usuario , String tarifa, String origen, String destino, 
			String tiempo, Double precio){
		try{
		List<Carrera> lista;
		String sql = "select c from Carrera as c where c.estado = '1' and (c.usuario.user like :criterio1 and " +
				"c.tarifa.tipoTarifa like :criterio2 and c.origen like :criterio3 and c.destino like :criterio4 and " +
				"c.tiempo like :criterio5 and c.precio = :criterio6)";
		lista = getEntityManager().createQuery(sql).setParameter("criterio1","%" + usuario + "%")
													.setParameter("criterio2", "%" + tarifa + "%")
													.setParameter("criterio3", "%" + origen + "%")
													.setParameter("criterio4", "%" + destino + "%")
													.setParameter("criterio5", "%" + tiempo + "%")
													.setParameter("criterio6",precio)
													.getResultList();
		
		return lista;
		}catch(RuntimeException re){
			log.error("error en filtrar por usuario, tarifa, origen, destino, tiempo y precio" +re.getMessage());
			return null;
		}
	}
	
	public List<Carrera> filtarcamposStringFechaHQL(String usuario , String tarifa, String origen, String destino, 
			String tiempo, Date fecha){
		try{
		List<Carrera> lista;
		String sql = "select c from Carrera as c where c.estado = '1' and (c.usuario.user like :criterio1 and " +
				"c.tarifa.tipoTarifa like :criterio2 and c.origen like :criterio3 and c.destino like :criterio4 and " +
				"c.tiempo like :criterio5 and c.fecha between" +
				" :criterio6 and :criterio7)";
		lista = getEntityManager().createQuery(sql).setParameter("criterio1","%" + usuario + "%")
													.setParameter("criterio2", "%" + tarifa + "%")
													.setParameter("criterio3", "%" + origen + "%")
													.setParameter("criterio4", "%" + destino + "%")
													.setParameter("criterio5", "%" + tiempo + "%")
													.setParameter("criterio6",fecha)
													.setParameter("criterio7",fecha)
													.getResultList();
		
		return lista;
		}catch(RuntimeException re){
			log.error("error en filtrar por usuario, tarifa, origen, destino, tiempo y fecha" +re.getMessage());
			return null;
		}
	}
	
	public List<Carrera> filtarcamposStringKmPrecioHQL(String usuario , String tarifa, String origen, String destino, 
			String tiempo, Double precio, Double Km){
		try{
		List<Carrera> lista;
		String sql = "select c from Carrera as c where c.estado = '1' and (c.usuario.user like :criterio1 and " +
				"c.tarifa.tipoTarifa like :criterio2 and c.origen like :criterio3 and c.destino like :criterio4 and " +
				"c.tiempo like :criterio5 and c.precio = :criterio6 and c.kmRecorridos = :criterio7)";
		lista = getEntityManager().createQuery(sql).setParameter("criterio1","%" + usuario + "%")
													.setParameter("criterio2", "%" + tarifa + "%")
													.setParameter("criterio3", "%" + origen + "%")
													.setParameter("criterio4", "%" + destino + "%")
													.setParameter("criterio5", "%" + tiempo + "%")
													.setParameter("criterio6",precio)
													.setParameter("criterio7",Km)
													.getResultList();
		
		return lista;
		}catch(RuntimeException re){
			log.error("error en filtrar por usuario, tarifa, origen, destino, tiempo, precio y Km" +re.getMessage());
			return null;
		}
	}
	
	public List<Carrera> filtarcamposStringKmFechaHQL(String usuario , String tarifa, String origen, String destino, 
			String tiempo, Double Km, Date fecha){
		try{
		List<Carrera> lista;
		String sql = "select c from Carrera as c where c.estado = '1' and (c.usuario.user like :criterio1 and " +
				"c.tarifa.tipoTarifa like :criterio2 and c.origen like :criterio3 and c.destino like :criterio4 and " +
				"c.tiempo like :criterio5 and c.kmRecorridos = :criterio6 and c.fecha between" +
				" :criterio7 and :criterio8)";
		lista = getEntityManager().createQuery(sql).setParameter("criterio1","%" + usuario + "%")
													.setParameter("criterio2", "%" + tarifa + "%")
													.setParameter("criterio3", "%" + origen + "%")
													.setParameter("criterio4", "%" + destino + "%")
													.setParameter("criterio5", "%" + tiempo + "%")
													.setParameter("criterio6",Km)
													.setParameter("criterio7",fecha)
													.setParameter("criterio8",fecha)
													.getResultList();
		
		return lista;
		}catch(RuntimeException re){
			log.error("error en filtrar por usuario, tarifa, origen, destino, tiempo, Km y fecha" +re.getMessage());
			return null;
		}
	}
	
	public List<Carrera> filtarcamposStringPrecioFechaHQL(String usuario , String tarifa, String origen, String destino, 
			String tiempo, Double precio, Date fecha){
		try{
		List<Carrera> lista;
		String sql = "select c from Carrera as c where c.estado = '1' and (c.usuario.user like :criterio1 and " +
				"c.tarifa.tipoTarifa like :criterio2 and c.origen like :criterio3 and c.destino like :criterio4 and " +
				"c.tiempo like :criterio5 and c.precio = :criterio6 and c.fecha between" +
				" :criterio7 and :criterio8)";
		lista = getEntityManager().createQuery(sql).setParameter("criterio1","%" + usuario + "%")
													.setParameter("criterio2", "%" + tarifa + "%")
													.setParameter("criterio3", "%" + origen + "%")
													.setParameter("criterio4", "%" + destino + "%")
													.setParameter("criterio5", "%" + tiempo + "%")
													.setParameter("criterio6",precio)
													.setParameter("criterio7",fecha)
													.setParameter("criterio8",fecha)
													.getResultList();
		
		return lista;
		}catch(RuntimeException re){
			log.error("error en filtrar por usuario, tarifa, origen, destino, tiempo, precio y fecha" +re.getMessage());
			return null;
		}
	}
	
	public List<Carrera> filtarcamposStringPrecioKmFechaHQL(String usuario , String tarifa, String origen, String destino, 
			String tiempo, Double precio, Double Km, Date fecha){
		try{
		List<Carrera> lista;
		String sql = "select c from Carrera as c where c.estado = '1' and (c.usuario.user like :criterio1 and " +
				"c.tarifa.tipoTarifa like :criterio2 and c.origen like :criterio3 and c.destino like :criterio4 and " +
				"c.tiempo like :criterio5 and c.kmRecorridos = :criterio6 and c.precio = :criterio7 and c.fecha between" +
				" :criterio8 and :criterio9)";
		lista = getEntityManager().createQuery(sql).setParameter("criterio1","%" + usuario + "%")
													.setParameter("criterio2", "%" + tarifa + "%")
													.setParameter("criterio3", "%" + origen + "%")
													.setParameter("criterio4", "%" + destino + "%")
													.setParameter("criterio5", "%" + tiempo + "%")
													.setParameter("criterio6",Km)
													.setParameter("criterio7",precio)
													.setParameter("criterio8",fecha)
													.setParameter("criterio9",fecha)
													.getResultList();
		
		return lista;
		}catch(RuntimeException re){
			log.error("error en filtrar por usuario, tarifa, origen, destino, tiempo, precio, Km y fecha" +re.getMessage());
			return null;
		}
	}
}
