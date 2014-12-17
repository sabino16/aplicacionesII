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
	public String registrar(int id_tarifa, int id_pasajero, String user, String contrasena, 
			String origen, String destino, String tiempo, double velocidad, double precio,
			String fecha)
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
		
		Carrera  carrera = new Carrera(tarifa, usuario, origen, destino, tiempo,velocidad, precio, date, "1");
		if(usuario.getUser().equals(user)==true && usuario.getPass().equals(contrasena)==true ){
			ch.persist(carrera);
			em.getTransaction().commit();
			gh.closeEntityManager(em);
			return "Carrera registrada";
		}
		else{
			em.getTransaction().commit();
			gh.closeEntityManager(em);
			return "Error de Autenticación";
		}
	    }
	    catch (ParseException e)
	    {
	      e.printStackTrace();
	      return "Error";
	    }
	}
	
	public String registrarusuario(String nombres, String apellidos, String correo, 
			String cedula, String user, String contrasena)
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
					correo, cedula, "1");
			
			uh.persist(usuario);
			em.getTransaction().commit();
			gh.closeEntityManager(em);
			return "Usuario Registrado";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error";
		}
		
	}
	
	/*public static void main(String [ ] args)
	{
	      RegistrarCarreras rc = new RegistrarCarreras();
	      String a;
	      String b;
	      a = rc.registrarusuario("prueba2", "prueba", "prueba", "prueba",
	    		  "usuario1", "contraseña1", "1");
	      b = rc.registrar(1,7,"usuario1","contraseña1", "salinas", "la libertad", "15min", 43, 2.25, "17/12/2014", "1");
	      System.out.println("   "+b);
	}*/
	
}
