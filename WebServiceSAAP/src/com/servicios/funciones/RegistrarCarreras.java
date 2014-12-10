package com.servicios.funciones;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.servicio.modelo.Carrera;
import com.servicio.modelo.CarreraHome;
import com.servicio.modelo.Tarifa;
import com.servicio.modelo.TarifaHome;
import com.servicio.modelo.Usuario;
import com.servicio.modelo.UsuarioHome;


//Borrar clases generadas

public class RegistrarCarreras {
	public boolean registrar(int id_tarifa, int id_pasajero,
			String origen, String destino, String tiempo, double velocidad, double precio,
			String fecha, String estado)
	{
		CarreraHome ch = new CarreraHome();
		TarifaHome tth = new TarifaHome();
		UsuarioHome uh = new UsuarioHome();
		Tarifa tarifa = tth.findById(id_tarifa);
		Usuario usuario = uh.findById(id_pasajero);
		Date date = null;
		    String expectedPattern = "MM/dd/yyyy";
		    SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
		    try
		    {
		      date = formatter.parse(fecha);
		      System.out.println(date);
		    }
		    catch (ParseException e)
		    {
		      e.printStackTrace();
		    }
		
		Carrera  carrera = new Carrera(tarifa, usuario, origen, destino, tiempo,velocidad, precio, date, estado);
		ch.persist(carrera);
		return true;
	}
	
	
}
