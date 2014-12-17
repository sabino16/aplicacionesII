package com.servicios.controladoes;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Date;

import javax.xml.rpc.ServiceException;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Textbox;

import com.servicios.funciones.RegistrarCarrerasServiceLocator;
import com.servicios.funciones.RegistrarCarrerasSoapBindingStub;

public class RegistrarCarreraControlador extends GenericForwardComposer<Component>{

	Textbox textbox_pasajero,textbox_origen,textbox_destino,textbox_tiempo;
	Textbox textbox_usuario,textbox_contrasena;
	Doublebox textbox_precio,textbox_velocidad;
	Datebox datebox_Inicio;
	Combobox cbbTarifa;
	Button btnGuardar,btnCancelar;
	
	public void RegistrarCarrera(){
		String RegistroCarrera;
		
		try {
			RegistrarCarrerasSoapBindingStub pbinding = (RegistrarCarrerasSoapBindingStub) new
					RegistrarCarrerasServiceLocator().getRegistrarCarreras(new URL("http://localhost:8080/WebServiceSAAP/services/RegistrarCarreras"));
		
			String origen = textbox_origen.getValue();
			String destino = textbox_destino.getValue();
			String tiempo = textbox_tiempo.getValue();
			Double velocidad = textbox_velocidad.getValue();
			Double precio = textbox_precio.getValue();
			String fecha = "17/12/2014";
			String usuario = textbox_usuario.getValue();
			String contrasena= textbox_contrasena.getValue();
			
			RegistroCarrera = pbinding.registrar(1, 9,usuario , contrasena , origen, destino, tiempo, velocidad, precio, fecha);
		
			alert("" + RegistroCarrera);
			
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
	
	public void onClick$btnGuardar()
	{
		RegistrarCarrera();
	}
	
}
