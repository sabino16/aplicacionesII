package com.servicios.controladoes;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;

import com.servicios.funciones.RegistrarCarrerasServiceLocator;
import com.servicios.funciones.RegistrarCarrerasSoapBindingStub;

public class IngresoLoginUsuarioControlador extends GenericForwardComposer<Component>{
	
	@Wire
	Textbox textbox_usuario,textbox_password;
	Button btnIngresar;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
	}
	
	public void IngresoLoginUsuario(){
		boolean RespuestaRegistroIngreso;	
		try {
			RegistrarCarrerasSoapBindingStub pbinding = (RegistrarCarrerasSoapBindingStub) new
					RegistrarCarrerasServiceLocator().getRegistrarCarreras(new URL("http://localhost:8080/WebServiceSAAP/services/RegistrarCarreras"));
		
			
			String user = textbox_usuario.getValue();
			String contrasena = textbox_password.getValue();
			
			RespuestaRegistroIngreso = pbinding.iniciarsesion(user, contrasena);
			
			alert("" + RespuestaRegistroIngreso);
			
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
	
	
	public void onClick$btnIngresar()
	{
		IngresoLoginUsuario();
	}

}
