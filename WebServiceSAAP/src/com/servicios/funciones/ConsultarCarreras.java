package com.servicios.funciones;

import com.google.gson.*;
import com.servicios.modelo.Carrera;
import com.servicios.modelo.CarreraHome;
import com.servicios.modelo.GeneralHome;
import com.servicios.modelo.Tarifa;
import com.servicios.modelo.TarifaHome;
import com.servicios.modelo.TipoUsuario;
import com.servicios.modelo.TipoUsuarioHome;
import com.servicios.modelo.Usuario;
import com.servicios.modelo.UsuarioHome;

import javax.persistence.EntityManager;


public class ConsultarCarreras {
	GeneralHome gh;
	EntityManager em;
	
	
	public String consultardatosusuario(int idUsuario){
		//retorna lista de carreras en format json
		
		gh = new GeneralHome();
		em = gh.initEntityManager();
		UsuarioHome uh = new UsuarioHome();
		uh.setEntityManager(em);   	
		TipoUsuarioHome th = new TipoUsuarioHome();
		th.setEntityManager(em);
		em.getTransaction().begin();
		
		
		
		Usuario usuario = uh.findById(idUsuario);
		TipoUsuario TUsuario = th.findById(usuario.getTipoUsuario().getIdTipousuario());
		
		
		
	    em.getTransaction().commit();
		gh.closeEntityManager(em);
		//return datos;
		return usuario.toString();
	}
	
	
		
	public String consultardatoscarrera(int idCarrera){
		
		gh = new GeneralHome();
		em = gh.initEntityManager();
		CarreraHome ch = new CarreraHome();
		ch.setEntityManager(em);   	
		UsuarioHome uh = new UsuarioHome();
		uh.setEntityManager(em); 
		TarifaHome tah = new TarifaHome();
		tah.setEntityManager(em); 
		em.getTransaction().begin();
		
		
		
		Carrera carrera = ch.findById(idCarrera);
		Usuario usuario = uh.findById(carrera.getUsuario().getIdUsuario());
		Tarifa tarifa = tah.findById(carrera.getTarifa().getIdTarifa());
			
		
		em.getTransaction().commit();
		gh.closeEntityManager(em);
		return carrera.toString();  
		}
	
		
		public String listahistorial(){
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
		
		
		
		return "";
		
		}
		
		public String consultarhistorial(int idUsuario){
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
			
			
			
			return "";
			
			}


	
	public static void main(String [ ] args)
	{
	      ConsultarCarreras rc = new ConsultarCarreras();
	      String a, b;
	      a = rc.consultardatosusuario(1);
	      b = rc.consultardatoscarrera(1);
	      System.out.println(a);
	      System.out.println(b);
	}
	
}
