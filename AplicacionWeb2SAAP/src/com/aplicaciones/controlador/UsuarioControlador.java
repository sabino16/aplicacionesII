package com.aplicaciones.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Center;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.aplicacionesa.modelo.GeneralHome;
import com.aplicacionesa.modelo.TipoUsuario;
import com.aplicacionesa.modelo.TipoUsuarioHome;
import com.aplicacionesa.modelo.Usuario;
import com.aplicacionesa.modelo.UsuarioHome;



public class UsuarioControlador extends GenericForwardComposer<Component>{
	
	//VARIABLES DEL MODELO A UTILIZAR
	EntityManagerFactory emfactory;
	GeneralHome gh;
	EntityManager em;
	UsuarioHome uh;
	TipoUsuarioHome tu;
	String validacion;
	Usuario usuario = null;
	
@Wire
	Textbox textbox_Apellidos,textbox_Nombres,textbox_Cedula,
	textbox_Email,textbox_User,textbox_Password,textbox_PasswordC;
	Button btnOpcion,btnLimpiar;
	Combobox cbbTipoUsuario;
	Window WinUsuario;
	

	
@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		
		
		Session session;
		session=Sessions.getCurrent();
		validacion = session.getAttribute("accion").toString();
		usuario= (Usuario)session.getAttribute("UsuarioSeleccionado");
		cargarComboTipoUsuario();
		if(validacion.equals("Ingresar")){
			btnOpcion.setLabel("Guardar");
			btnOpcion.setVisible(true);
		}
		if(validacion.equals("Editar")){
			btnOpcion.setLabel("Editar");
			btnOpcion.setVisible(true);
		}
		if(validacion.equals("Eliminar")){
			btnOpcion.setLabel("Eliminar");
			btnOpcion.setVisible(true);
		}
		if(validacion.equals("Visualizar")){
			btnLimpiar.setVisible(false);
		}
		if(usuario!=null && validacion.equals("Ingresar")==false){
			//cargar datos en el formulario mediante la session
			textbox_Apellidos.setValue(usuario.getApellido());
			textbox_Nombres.setValue(usuario.getNombre());
			textbox_Cedula.setValue(usuario.getCedula());
			textbox_Email.setValue(usuario.getCorreo());
			textbox_Password.setValue(usuario.getPass());
			textbox_User.setValue(usuario.getUser());
			
			
		}
	}

	public void onCreate$WinUsuario(){
		if(validacion.equals("Editar") || validacion.equals("Eliminar") || validacion.equals("Visualizar")){
		List<Comboitem> comboitems = cbbTipoUsuario.getItems();
		for(Comboitem item : comboitems){
			if(item.getValue().equals(usuario.getTipoUsuario().getIdTipousuario())){
				cbbTipoUsuario.setSelectedItem(item);
				break;
			}
		}
		}
	}

public void GuardarUsuario(){
		Usuario usuario= new Usuario();
		
		if(textbox_Apellidos.getValue().equals(" ")==false && textbox_Nombres.getValue().equals(" ")==false
				&& textbox_Cedula.getValue().equals(" ")==false && textbox_User.getValue().equals(" ")==false
				&& textbox_Email.getValue().equals(" ")==false && textbox_Password.getValue().equals(" ")==false
				&& textbox_PasswordC.getValue().equals(" ")==false && textbox_Password.getValue().equals(textbox_PasswordC.getValue())==true){
			
			TipoUsuario tipou;
			if(cbbTipoUsuario.getSelectedItem()!=null){
				tipou = tu.findById((Integer)cbbTipoUsuario.getSelectedItem().getValue());
			}else{
				alert("Por favor seleccione un tipo de usuario");
				return;
			}
			usuario.setTipoUsuario(tipou);
			
			usuario.setApellido(textbox_Apellidos.getValue());
			usuario.setNombre(textbox_Nombres.getValue());
			usuario.setCedula(textbox_Cedula.getValue());
			usuario.setCorreo(textbox_Email.getValue());
			usuario.setPass(textbox_Password.getValue());
			usuario.setUser(textbox_User.getValue());
			usuario.setEstado("1");
			
			uh.persist(usuario);
			alert("Usuario Registrado");
			limpiar();
		}else{
			alert("No ha llenado todos los datos");
		}

	}
	
	public void EditarUsuario(){
		
		Usuario usuarioeditar= uh.findById(usuario.getIdUsuario());
		
		if(textbox_Apellidos.getValue().equals(" ")==false && textbox_Nombres.getValue().equals(" ")==false
				&& textbox_Cedula.getValue().equals(" ")==false && textbox_User.getValue().equals(" ")==false
				&& textbox_Email.getValue().equals(" ")==false && textbox_Password.getValue().equals(" ")==false
				&& textbox_PasswordC.getValue().equals(" ")==false){
			
			TipoUsuario tipou;
			if(cbbTipoUsuario.getSelectedItem()!=null){
				tipou = tu.findById((Integer)cbbTipoUsuario.getSelectedItem().getValue());
			}else{
				alert("Por favor seleccione un tipo de usuario");
				return;
			}
			usuarioeditar.setTipoUsuario(tipou);
						
			usuarioeditar.setApellido(textbox_Apellidos.getValue());
			usuarioeditar.setNombre(textbox_Nombres.getValue());
			usuarioeditar.setCedula(textbox_Cedula.getValue());
			usuarioeditar.setCorreo(textbox_Email.getValue());
			usuarioeditar.setPass(textbox_Password.getValue());
			usuarioeditar.setUser(textbox_User.getValue());
			usuarioeditar.setEstado("1");
			
			uh.persist(usuarioeditar);
			alert("Usuario Editado");
			limpiar();
		}else{
			alert("No ha llenado todos los campos!");
		}

	}
	
	public void EliminarUsuario(){
		
		Usuario usuarioeliminar= uh.findById(usuario.getIdUsuario());
		
		usuarioeliminar.setEstado("0");
		uh.persist(usuarioeliminar);
		alert("Datos Usuario Eliminados");
		limpiar();
	}
	
	public void onClick$btnOpcion(){
		
		gh = new GeneralHome();
		em = gh.initEntityManager();
		uh = new UsuarioHome();
		uh.setEntityManager(em);
		tu = new TipoUsuarioHome();
		tu.setEntityManager(em);
		em.getTransaction().begin();		
		
		if(validacion.equals("Ingresar")){
			GuardarUsuario();
		}
		if(validacion.equals("Editar")){
			EditarUsuario();
		}
		if(validacion.equals("Eliminar")){
			EliminarUsuario();
		}

	
		em.getTransaction().commit();
		gh.closeEntityManager(em);

	}
	
	public void limpiar(){
		textbox_Apellidos.setValue(" ");
		textbox_Nombres.setValue(" ");
		textbox_Cedula.setValue(" ");
		textbox_Email.setValue(" ");
		textbox_Password.setValue("");
		textbox_PasswordC.setValue("");
		textbox_User.setValue(" ");
		
	}
	
	public void onClick$btnLimpiar(){
		limpiar();
	}
	
	
	public void cargarComboTipoUsuario(){
		
		gh = new GeneralHome();
		em = gh.initEntityManager();
		
		uh = new UsuarioHome();
		uh.setEntityManager(em);
		
		tu = new TipoUsuarioHome();
		tu.setEntityManager(em);
		
		em.getTransaction().begin();
		
		List<TipoUsuario> listaTipoUsuario = tu.findAll();
		ListModelList<TipoUsuario> listmodelT;
		if(listaTipoUsuario!=null){
			listmodelT = new ListModelList<TipoUsuario>(listaTipoUsuario);
			cbbTipoUsuario.setModel(listmodelT);
		}else{
			alert("no existen temas");
		}
		
		em.getTransaction().commit();
		gh.closeEntityManager(em);
		
	}	
	
	public void onChange$cbbTipoUsuario(){
		TipoUsuario tipou = null;
		if(cbbTipoUsuario.getSelectedItem()!=null){
			gh = new GeneralHome();
			em = gh.initEntityManager();
			
			tu = new TipoUsuarioHome();
			tu.setEntityManager(em);
			
			em.getTransaction().begin();
			tipou = tu.findById((Integer)cbbTipoUsuario.getSelectedItem().getValue());
			
			em.getTransaction().commit();
			gh.closeEntityManager(em);
		}

	}


	
}

