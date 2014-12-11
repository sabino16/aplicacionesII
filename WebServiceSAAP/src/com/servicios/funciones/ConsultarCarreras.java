package com.servicios.funciones;

import com.google.gson.*;

import javax.persistence.EntityManager;


import com.servicio.modelo.Carrera;
import com.servicio.modelo.CarreraHome;
import com.servicio.modelo.GeneralHome;
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
		em.getTransaction().begin();
		
		
		
		Usuario usuario = uh.consultarusuario(idUsuario);
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String datos =  gson.toJson(usuario);
		
		
		
	    em.getTransaction().commit();
		gh.closeEntityManager(em);
		return datos;  
	}
	
	
		
	public String consultardatoscarrera(int idCarrera){
		
		gh = new GeneralHome();
		em = gh.initEntityManager();
		CarreraHome ch = new CarreraHome();
		ch.setEntityManager(em);   	
		em.getTransaction().begin();
		
		
		
		Carrera carrera = ch.consultarcarrera(idCarrera);
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String datos =  gson.toJson(carrera);
		
		
		
	    em.getTransaction().commit();
		gh.closeEntityManager(em);
		return datos;  
		}
	
	
	

	
	public String consultarhistorial(int idUsuario){
		//retorna lista de carreras en format json
		
		return "";
		
		}

}
