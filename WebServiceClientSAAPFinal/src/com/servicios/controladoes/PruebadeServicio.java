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
		String ConsultarCarrera;
		String ConsultarCarrera2;
		
		try {
			ConsultarCarrerasSoapBindingStub pbinding = (ConsultarCarrerasSoapBindingStub) new
			ConsultarCarrerasServiceLocator().getConsultarCarreras(new URL("http://localhost:8080/WebServiceSAAP/services/ConsultarCarreras"));
		
			
			ConsultarCarrera = pbinding.consultardatosusuario(1);
			ConsultarCarrera2 = pbinding.consultardatoscarrera(1);
			System.out.println(ConsultarCarrera);
		     System.out.println(ConsultarCarrera2);
			
	
			
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
