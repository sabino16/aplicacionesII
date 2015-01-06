package com.servicios.funciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.*;

import javax.persistence.EntityManager;


import com.servicios.modelo.Carrera;
import com.servicios.modelo.CarreraHome;
import com.servicios.modelo.GeneralHome;
import com.servicios.modelo.Tarifa;
import com.servicios.modelo.TarifaHome;
import com.servicios.modelo.TipoUsuario;
import com.servicios.modelo.TipoUsuarioHome;
import com.servicios.modelo.Usuario;
import com.servicios.modelo.UsuarioHome;
public class ConsultarCarreras {
	GeneralHome gh;
	EntityManager em;
	
	
	
	public String servicio_login(String user, String contrasena){
		gh = new GeneralHome();
		em = gh.initEntityManager();
		UsuarioHome uh = new UsuarioHome();
		uh.setEntityManager(em);   	
		TipoUsuarioHome th = new TipoUsuarioHome();
		th.setEntityManager(em);
		em.getTransaction().begin();
		
		Usuario usu = uh.Servicio_Login(user, contrasena);
		TipoUsuario TUsuario = th.findById(usu.getTipoUsuario().getIdTipousuario());
		
		em.getTransaction().commit();
		gh.closeEntityManager(em);
		
		
		return usu.toJsonLogin();
	}
	
	
public String servicio_consultar_carrera(int idCarrera){
		
		gh = new GeneralHome();
		em = gh.initEntityManager();
		CarreraHome ch = new CarreraHome();
		ch.setEntityManager(em);   	
		UsuarioHome uh = new UsuarioHome();
		uh.setEntityManager(em); 
		TarifaHome tah = new TarifaHome();
		tah.setEntityManager(em); 
		em.getTransaction().begin();
		
		
		
		Carrera carrera = ch.Servicio_Consultar_Carrera(idCarrera);
		Usuario usuario = uh.findById(carrera.getUsuario().getIdUsuario());
		Tarifa tarifa = tah.findById(carrera.getTarifa().getIdTarifa());
			
		
		em.getTransaction().commit();
		gh.closeEntityManager(em);
		
		return carrera.toJsonCDCarrera();  
		}
	
public String servicio_consultar_tarifa(String tipoTarifa){
	
	gh = new GeneralHome();
	em = gh.initEntityManager();
	TarifaHome th = new TarifaHome();
	th.setEntityManager(em);   	
	em.getTransaction().begin();
	
	
	
	Tarifa tarifa = th.Servicio_Consultar_Tarifa(tipoTarifa);
		
	
	em.getTransaction().commit();
	gh.closeEntityManager(em);
	
	return tarifa.toJsonCDTarifa();  
	}
	
	
	
	
	public String servicio_consultar_usuario(int idUsuario){
		//retorna lista de carreras en format json
		
		gh = new GeneralHome();
		em = gh.initEntityManager();
		CarreraHome ch = new CarreraHome();
		ch.setEntityManager(em); 
		UsuarioHome uh = new UsuarioHome();
		uh.setEntityManager(em);   	
		TipoUsuarioHome th = new TipoUsuarioHome();
		th.setEntityManager(em);
		em.getTransaction().begin();
		
		String lista= "[";
		int cont = 0;
		ArrayList<Carrera> ListaCarrera =  (ArrayList<Carrera>) ch.Servicio_Consultar_Carrera_usuario(idUsuario);
		Iterator iterador = ListaCarrera.listIterator();
		while(iterador.hasNext()){
			cont = cont + 1;
			Carrera c = (Carrera) iterador.next();
			
			if (cont== 1){
				lista = lista + c.toJsonCDCarrera();
			}
			if (cont != 1){
				lista = lista + ", " +c.toJsonCDCarrera();
			}
			
		}
			
	    em.getTransaction().commit();
		gh.closeEntityManager(em);
		//return datos;
		return  lista+ "]";
	}
	
	
	
	public String servicio_consultar_usuario_fechas(String f_inicio, String f_fin, int idUsuario){
		//retorna lista de carreras en format json
		
		gh = new GeneralHome();
		em = gh.initEntityManager();
		CarreraHome ch = new CarreraHome();
		ch.setEntityManager(em); 
		UsuarioHome uh = new UsuarioHome();
		uh.setEntityManager(em);   	
		TipoUsuarioHome th = new TipoUsuarioHome();
		th.setEntityManager(em);
		em.getTransaction().begin();
		
		String lista= "[";
		int cont = 0;
		ArrayList<Carrera> ListaCarrera =  (ArrayList<Carrera>) ch.Servicio_Consultar_Carrera_fechas(f_inicio, f_fin, idUsuario);
		Iterator iterador = ListaCarrera.listIterator();
		while(iterador.hasNext()){
			cont = cont + 1;
			Carrera c = (Carrera) iterador.next();
			
			if (cont== 1){
				lista = lista + c.toJsonCDCarrera();
			}
			if (cont != 1){
				lista = lista + ", " +c.toJsonCDCarrera();
			}
			
		}
			
	    em.getTransaction().commit();
		gh.closeEntityManager(em);
		//return datos;
		return  lista+ "]";
	}
	
	

	public String servicio_consultar_usuario_origen_destino(String parametro, int idUsuario){
		//retorna lista de carreras en format json
		
		gh = new GeneralHome();
		em = gh.initEntityManager();
		CarreraHome ch = new CarreraHome();
		ch.setEntityManager(em); 
		UsuarioHome uh = new UsuarioHome();
		uh.setEntityManager(em);   	
		TipoUsuarioHome th = new TipoUsuarioHome();
		th.setEntityManager(em);
		em.getTransaction().begin();
		
		String lista= "[";
		int cont = 0;
		ArrayList<Carrera> ListaCarrera =  (ArrayList<Carrera>) ch.Servicio_Consultar_Carrera_origen_destino(parametro, idUsuario);
		Iterator iterador = ListaCarrera.listIterator();
		while(iterador.hasNext()){
			cont = cont + 1;
			Carrera c = (Carrera) iterador.next();
			
			if (cont== 1){
				lista = lista + c.toJsonCDCarrera();
			}
			if (cont != 1){
				lista = lista + ", " +c.toJsonCDCarrera();
			}
			
		}
			
	    em.getTransaction().commit();
		gh.closeEntityManager(em);
		//return datos;
		return  lista+ "]";
	}
	
	
	
	public static void main(String [ ] args)
	{
		  
	      ConsultarCarreras rc = new ConsultarCarreras();
	      String a, b, c, d, e, f;
	      a = rc.servicio_login("andrea", "1234");
	      b = rc.servicio_consultar_carrera(2);
	      c = rc.servicio_consultar_tarifa("Diurna");
	      d = rc.servicio_consultar_usuario(7);
	      e = rc.servicio_consultar_usuario_fechas("2014-12-25", "2015-05-12",9);
	      f = rc.servicio_consultar_usuario_origen_destino("salinas",4);
	      System.out.println(a);
	      System.out.println(b);
	      System.out.println(c);
	      System.out.println(d);
	      System.out.println(e);
	      System.out.println(f);
	     
	}
	
}
