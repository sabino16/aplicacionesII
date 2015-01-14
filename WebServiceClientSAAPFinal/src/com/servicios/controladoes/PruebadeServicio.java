package com.servicios.controladoes;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.servicios.funciones.ConsultarCarreras;
import com.servicios.funciones.ConsultarCarrerasServiceLocator;
import com.servicios.funciones.ConsultarCarrerasSoapBindingStub;

public class PruebadeServicio {
	
	public void ConsultarCarrera(){
		String Login;
		String ConsultarCarrera_idCarrera;
		String ConsultarTarifa;
		String ConsultarCarrera_idUsuario;
		String ConsultarCarrera_Fechas;
		String ConsultarCarrera_OrigenDestino;
		
		try {
			ConsultarCarrerasSoapBindingStub pbinding = (ConsultarCarrerasSoapBindingStub) new
			ConsultarCarrerasServiceLocator().getConsultarCarreras(new URL("http://localhost:8080/WebServiceSAAP/services/ConsultarCarreras"));
		
			
			Login = pbinding.servicio_login("andrea", "1234");
			ConsultarCarrera_idCarrera = pbinding.servicio_consultar_carrera(2);
			ConsultarTarifa = pbinding.servicio_consultar_tarifa("Diurna");
			ConsultarCarrera_idUsuario = pbinding.servicio_consultar_usuario("barcelona");
			ConsultarCarrera_Fechas = pbinding.servicio_consultar_usuario_fechas("2014-12-25", "2015-05-12","barcelona");
			ConsultarCarrera_OrigenDestino = pbinding.servicio_consultar_usuario_origen_destino("salinas","lucho");
			System.out.println(Login);
		    System.out.println(ConsultarCarrera_idCarrera);
		    System.out.println(ConsultarTarifa);
		    System.out.println(ConsultarCarrera_idUsuario);
		    System.out.println(ConsultarCarrera_Fechas);
		    System.out.println(ConsultarCarrera_OrigenDestino);
	
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String [ ] args)
	{
		PruebadeServicio rc = new PruebadeServicio();
	      rc.ConsultarCarrera();
	      
	      
	}

}
