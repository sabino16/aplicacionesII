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
	
	
	
	
	
	public static void main(String [ ] args)
	{
		  
	      ConsultarCarreras rc = new ConsultarCarreras();
	      String a, b, c, d, e, f;
	      a = rc.servicio_login("andrea", "1234");
	      b = rc.servicio_consultar_carrera(2);
	      c = rc.servicio_consultar_tarifa("Diurna");
	      System.out.println(a);
	      System.out.println(b);
	      System.out.println(c);
	     
	}
	
}
