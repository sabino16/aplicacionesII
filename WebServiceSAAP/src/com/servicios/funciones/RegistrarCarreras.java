package com.servicios.funciones;

import java.util.Date;

import com.servicios.modelo.Carrera;
import com.servicios.modelo.CarreraHome;
import com.servicios.modelo.Tarifa;
import com.servicios.modelo.TarifaHome;
import com.servicios.modelo.Taxi;
import com.servicios.modelo.TaxiHome;
import com.servicios.modelo.Usuario;
import com.servicios.modelo.UsuarioHome;



public class RegistrarCarreras {
	public boolean registrar(Integer id_taxi, Integer id_tarifa, Integer id_pasajero,
			String origen, String destino, Date tiempo, double velocidad, double precio,
			Date fecha, String estado)
	{
		CarreraHome ch = new CarreraHome();
		TaxiHome th = new TaxiHome();
		TarifaHome tth = new TarifaHome();
		UsuarioHome uh = new UsuarioHome();
		Taxi taxi = th.findById(id_taxi);
		Tarifa tarifa = tth.findById(id_tarifa);
		Usuario usuario = uh.findById(id_pasajero);
		Carrera  carrera = new Carrera(taxi, tarifa, usuario, origen, destino, tiempo, velocidad, precio, fecha, estado);
		ch.persist(carrera);
		return true;
	}
}
