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

import bsh.org.objectweb.asm.Label;

import com.servicios.funciones.RegistrarCarrerasServiceLocator;
import com.servicios.funciones.RegistrarCarrerasSoapBindingStub;



public class RegistrarPasajeroControlador extends GenericForwardComposer<Component>{

	
		@Wire
		Textbox textbox_nombre,textbox_apellido,textbox_correo,textbox_cedula,textbox_usuario,textbox_password,textbox_comparacion;
		Button btnGuardar,btnCancelar;
		
		
		
		@Override
		public void doAfterCompose(Component comp) throws Exception {
			// TODO Auto-generated method stub
			super.doAfterCompose(comp);
		}

		public void RegistrarPasajero(){
			boolean RespuestaRegistro;	
			try {
				RegistrarCarrerasSoapBindingStub pbinding = (RegistrarCarrerasSoapBindingStub) new
						RegistrarCarrerasServiceLocator().getRegistrarCarreras(new URL("http://localhost:8080/WebServiceSAAP/services/RegistrarCarreras"));
			
				String nombres = textbox_nombre.getValue();
				String apellidos = textbox_apellido.getValue();
				String correo = textbox_correo.getValue();
				String cedula = textbox_cedula.getValue();
				String user = textbox_usuario.getValue();
				String contrasena = textbox_password.getValue();
				
				
				RespuestaRegistro = pbinding.registrarusuario(nombres, apellidos, correo, cedula, user, contrasena);
				
				alert("" + RespuestaRegistro);
				
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
		
		
		public void ValidacionUsuario(){
			
			boolean RespuestaRegistro;	
			try {
				RegistrarCarrerasSoapBindingStub pbinding = (RegistrarCarrerasSoapBindingStub) new
						RegistrarCarrerasServiceLocator().getRegistrarCarreras(new URL("http://localhost:8080/WebServiceSAAP/services/RegistrarCarreras"));
			
				String userr = textbox_usuario.getValue();
				RespuestaRegistro = pbinding.validacionusuario(userr);
				
				textbox_comparacion.setText(" " + RespuestaRegistro);
				//alert("" + RespuestaRegistro);
				
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
			RegistrarPasajero();
		}
		
		public void onChange$textbox_usuario()
		{
			ValidacionUsuario();
		}
		
		
		
}
