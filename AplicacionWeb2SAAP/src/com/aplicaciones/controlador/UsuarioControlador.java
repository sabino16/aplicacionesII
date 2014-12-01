package com.aplicaciones.controlador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Center;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.aplicaciones.modelo.GeneralHome;
import com.aplicaciones.modelo.TipoUsuario;
import com.aplicaciones.modelo.Usuario;
import com.aplicaciones.modelo.UsuarioHome;

public class UsuarioControlador extends GenericForwardComposer<Component>{
	
	//VARIABLES DEL MODELO A UTILIZAR
	EntityManagerFactory emfactory;
	GeneralHome gh;
	EntityManager em;
	UsuarioHome uh;
	TipoUsuario tu;
	String validacion;
	Usuario usuario = null;
	
@Wire
	Textbox textbox_Apellidos,textbox_Nombres,textbox_Cedula,
	textbox_Email,textbox_User,textbox_Password,textbox_PasswordC;
	Button btnOpcion,btnLimpiar;
	Combobox cbbTipoUsuario;
	

}
