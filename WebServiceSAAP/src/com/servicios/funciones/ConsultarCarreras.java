package com.servicios.funciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.*;
import com.serviciosa.modelo.Carrera;
import com.serviciosa.modelo.CarreraHome;
import com.serviciosa.modelo.GeneralHome;
import com.serviciosa.modelo.Tarifa;
import com.serviciosa.modelo.TarifaHome;
import com.serviciosa.modelo.TipoUsuario;
import com.serviciosa.modelo.TipoUsuarioHome;
import com.serviciosa.modelo.Usuario;
import com.serviciosa.modelo.UsuarioHome;

import javax.persistence.EntityManager;


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
	
	
	
	
	public String servicio_consultar_usuario(String usuario){
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
		ArrayList<Carrera> ListaCarrera =  (ArrayList<Carrera>) ch.Servicio_Consultar_Carrera_usuario(usuario);
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
	
	
	
	public String servicio_consultar_usuario_fechas(String f_inicio, String f_fin, String usuario){
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
		ArrayList<Carrera> ListaCarrera =  (ArrayList<Carrera>) ch.Servicio_Consultar_Carrera_fechas(f_inicio, f_fin, usuario);
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
	
	

	public String servicio_consultar_usuario_origen_destino(String parametro, String usuario){
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
		ArrayList<Carrera> ListaCarrera =  (ArrayList<Carrera>) ch.Servicio_Consultar_Carrera_origen_destino(parametro, usuario);
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
	      d = rc.servicio_consultar_usuario("barcelona");
	      e = rc.servicio_consultar_usuario_fechas("2014-12-25", "2015-05-12","barcelona");
	      f = rc.servicio_consultar_usuario_origen_destino("salinas","lucho");
	      System.out.println(a);
	      System.out.println(b);
	      System.out.println(c);
	      System.out.println(d);
	      System.out.println(e);
	      System.out.println(f);
	     
	}
	
}
