package com.servicios.funciones;

import com.google.gson.*;

import javax.persistence.EntityManager;


import com.servicio.modelo.Carrera;
import com.servicio.modelo.CarreraHome;
import com.servicio.modelo.GeneralHome;
import com.servicio.modelo.Tarifa;
import com.servicio.modelo.TarifaHome;
import com.servicio.modelo.TipoUsuario;
import com.servicio.modelo.TipoUsuarioHome;
import com.servicio.modelo.Usuario;
import com.servicio.modelo.UsuarioHome;

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
		/*GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String datos =  gson.toJson(usuario);*/
		String datos = "{ 'number': "+ usuario.getIdUsuario() +",  'string': '" + TUsuario.getDescripcion() +"',  'String': '"+ usuario.getNombre()+"' ,  'string': '" + usuario.getApellido() +"',  'String': '"+ usuario.getCorreo()+"'}";
		
		
		
	    em.getTransaction().commit();
		gh.closeEntityManager(em);
		return datos;  
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
		/*GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String datos =  gson.toJson(carrera);*/
		String datos = "{ 'number': "+ carrera.getIdCarrera() +",  'String': '"+ usuario.getNombre()+"' ,  'string': '" + usuario.getApellido() +"',  'string': '" + tarifa.getTipoTarifa() +"',  'String': '"+ carrera.getOrigen()+"',  'String': '"+ carrera.getDestino()+"',  'String': '"+ carrera.getPrecio()+"',  'String': '"+ carrera.getTiempo()+"',  'String': '"+ carrera.getVelocidad()+"'}";
		
		
		em.getTransaction().commit();
		gh.closeEntityManager(em);
		return datos;  
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

	/*
	public static void main(String [ ] args)
	{
	      ConsultarCarreras rc = new ConsultarCarreras();
	      String a, b;
	      a = rc.consultardatosusuario(1);
	      b = rc.consultardatoscarrera(1);
	      System.out.println(a);
	      System.out.println(b);
	}*/
	
}
