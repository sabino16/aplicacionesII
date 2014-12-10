package com.servicios.funciones;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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


//Borrar clases generadas

public class RegistrarCarreras {
	GeneralHome gh;
	EntityManager em;
	public boolean registrar(int id_tarifa, int id_pasajero,
			String origen, String destino, String tiempo, double velocidad, double precio,
			String fecha, String estado)
	{
		try
	    {
			gh = new GeneralHome();
			em = gh.initEntityManager();
			CarreraHome ch = new CarreraHome();
			ch.setEntityManager(em);
			TarifaHome tth = new TarifaHome();
			tth.setEntityManager(em);
			UsuarioHome uh = new UsuarioHome();
			uh.setEntityManager(em);
			Tarifa tarifa = tth.findById(id_tarifa);
			em.getTransaction().begin();
			Usuario usuario = uh.findById(id_pasajero);
			Date date = null;
		    String expectedPattern = "MM/dd/yyyy";
		    SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
		    
		      date = formatter.parse(fecha);
		      System.out.println(date);
		
		Carrera  carrera = new Carrera(tarifa, usuario, origen, destino, tiempo,velocidad, precio, date, estado);
		ch.persist(carrera);
		em.getTransaction().commit();
		gh.closeEntityManager(em);
		return true;
	    }
	    catch (ParseException e)
	    {
	      e.printStackTrace();
	      return false;
	    }
	}
	
	public boolean registrarusuario(String nombres, String apellidos, String correo, 
			String cedula, String user, String contrasena, String estado)
	{
		
		
		try {
			gh = new GeneralHome();
			em = gh.initEntityManager();
			UsuarioHome uh = new UsuarioHome();
			uh.setEntityManager(em);
			TipoUsuarioHome tuh = new TipoUsuarioHome();
			tuh.setEntityManager(em);
			em.getTransaction().begin();
			TipoUsuario tipo_usuario = tuh.findById(1);
			Usuario  usuario = new Usuario(tipo_usuario, user, contrasena, nombres, apellidos,
					correo, cedula, estado);
			
			uh.persist(usuario);
			em.getTransaction().commit();
			gh.closeEntityManager(em);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static void main(String [ ] args)
	{
	      RegistrarCarreras rc = new RegistrarCarreras();
	      boolean a,b;
	      a = rc.registrarusuario("prueba2", "prueba", "prueba", "prueba",
	    		  "prueba", "prueba", "1");
	      b = rc.registrar(1, 4, "salinas", "la libertad", "10min", 40, 1.25, "12/10/2014", "1");
	      System.out.println(" "+ a +"   "+b);
	      
	      
	}
	
}
