package com.servicios.funciones;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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




//Borrar clases generadas

public class RegistrarCarreras {
	GeneralHome gh;
	EntityManager em;
	public int registrarcarrera(int id_tarifa, String user, String contrasena, 
			String origen, String destino, String tiempo, double km_recorridos, double precio,
			String fecha, double latitud_origen, double longitud_origen, double latitud_destino, double longitud_destino)
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
			List<Usuario> usuario = uh.iniciarsesion(user, contrasena);
			Date date = null;
		    String expectedPattern = "MM/dd/yyyy";
		    SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
		    
		      date = formatter.parse(fecha);
		      System.out.println(date);
		if(usuario.isEmpty()){
			em.getTransaction().commit();
			gh.closeEntityManager(em);
			return 1;
			
		}
		else{
			Carrera  carrera = new Carrera(tarifa, usuario.get(0), origen, destino, tiempo,km_recorridos, precio, date, latitud_origen,
					longitud_origen, latitud_destino, longitud_destino, "1");
			
				ch.persist(carrera);
				em.getTransaction().commit();
				gh.closeEntityManager(em);
				return 0;
		}
	    }
	    catch (ParseException e)
	    {
	      e.printStackTrace();
	      return 2;
	    }
	}
	
	public boolean registrarusuario(String nombres, String apellidos, String correo, 
			String cedula, String user, String contrasena)
	{
		try {
			boolean validacion = validacionusuario(user);
			gh = new GeneralHome();
			em = gh.initEntityManager();
			UsuarioHome uh = new UsuarioHome();
			uh.setEntityManager(em);
			TipoUsuarioHome tuh = new TipoUsuarioHome();
			tuh.setEntityManager(em);
			em.getTransaction().begin();
			TipoUsuario tipo_usuario = tuh.findById(1);
			
			if(validacion == false){
				Usuario  usuario = new Usuario(tipo_usuario, user, contrasena, nombres, apellidos,
						correo, cedula, "1");
				uh.persist(usuario);
				em.getTransaction().commit();
				gh.closeEntityManager(em);
				return true;
			}else{
				em.getTransaction().commit();
				gh.closeEntityManager(em);
				return false;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean iniciarsesion(String user, String contrasena){
		try {
			gh = new GeneralHome();
			em = gh.initEntityManager();
			UsuarioHome uh = new UsuarioHome();
			uh.setEntityManager(em);
			
			em.getTransaction().begin();
			List<Usuario>  usuario = uh.iniciarsesion(user, contrasena);
			em.getTransaction().commit();
			gh.closeEntityManager(em);
			if(usuario.isEmpty()){
				return false;
			}else{
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean validacionusuario(String userr){
		try {
			gh = new GeneralHome();
			em = gh.initEntityManager();
			UsuarioHome uh = new UsuarioHome();
			uh.setEntityManager(em);
			
			em.getTransaction().begin();
			List<Usuario>  usuario = uh.validacionusuario(userr);
			em.getTransaction().commit();
			gh.closeEntityManager(em);
			if(usuario.isEmpty()){
				return false;
			}else{
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static void main(String [ ] args)
	{
		RegistrarCarreras rc = new RegistrarCarreras();
	      boolean a;
	      boolean d;
	      //int b;
	      d = rc.validacionusuario("barcelona5");
	      a = rc.registrarusuario("asdsd", "ddfd", "fdfef", "2342424", "barcelona5", "dfdfsff");
	      
	      
	    		  /* b = rc.registrarcarrera(1, "barcelona", "campeon", "salinas", "santa elena",
	    		  "25min", 12.2, 2, "12/25/2014", 0.3453546464, -0.465645632, 0.5454454334, -0.454565635);
	    boolean a;
	    a = rc.iniciarsesion("kevin", "12");*/
		System.out.println("   "+d + "    " + a);
	}
	
}
