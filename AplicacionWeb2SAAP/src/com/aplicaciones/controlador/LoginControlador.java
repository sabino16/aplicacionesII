package com.aplicaciones.controlador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;

import com.aplicacionesa.modelo.GeneralHome;
import com.aplicacionesa.modelo.Usuario;
import com.aplicacionesa.modelo.UsuarioHome;



public class LoginControlador extends GenericForwardComposer<Component>{
	EntityManagerFactory emfactory;
	EntityManager em;
	GeneralHome gh;
	UsuarioHome uh;
	
	@Wire
	Textbox txtUsuario;
	Textbox txtPassword;
	Button btnIngresar;
	Label lblMensaje;

	public void onClick$btnIngresar(){
		String usuario=txtUsuario.getValue();
		String clave=txtPassword.getValue();
		
		gh=new GeneralHome();
		em = gh.initEntityManager();
		
		uh = new UsuarioHome();
		uh.setEntityManager(em);
		em.getTransaction().begin();
		
		Usuario	usuari = uh.buscarUsuario(usuario, clave);
		
		if(usuari!=null && usuari.getTipoUsuario().getIdTipousuario()==2){
			Session session;
			session=Sessions.getCurrent();
			session.setAttribute("usuario", usuari);
			Executions.sendRedirect("../index.zul");
		}else{
			lblMensaje.setValue("usuario y/o clave incorrectos");
		}
	
		
		em.getTransaction().commit();
		gh.closeEntityManager(em);
	}

}
