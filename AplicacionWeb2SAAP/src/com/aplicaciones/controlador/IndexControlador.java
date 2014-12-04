package com.aplicaciones.controlador;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Center;
import org.zkoss.zul.Label;
import org.zkoss.zul.Menu;
import org.zkoss.zul.Menubar;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Menupopup;
import org.zkoss.zul.Window;


import com.aplicaciones.modelo.Usuario;

public class IndexControlador extends GenericForwardComposer<Component> {
	
	Menu menuUsuarios;
	Menu menuCarreras;
	Menu menuReportes;
	
	Menuitem menuitemUIngresar;
	Menuitem menuitemUEditar;
	Menuitem menuitemUEliminar;
	Menuitem menuitemUVisualizar;
	Menuitem menuitemCVisualizar;
	Menuitem menuitemRVisualizar;
	
	@Wire
	Button btnIniciararSesion;
	Center centro;
	Label lblUsuario;
	Label lblNombre;
	Menubar barraMenu;
	
	public void  crearMenu(){
		menuUsuarios = new Menu("Usuarios");
		Menupopup menuCliente = new Menupopup();
		menuUsuarios.setVisible(false);
		menuitemUIngresar = new Menuitem("Ingresar");
		menuitemUEditar = new Menuitem("Editar");
		menuitemUEliminar = new Menuitem("Eliminar");
		menuitemUVisualizar = new Menuitem("Visualizar");
		menuitemUIngresar.setVisible(false);
		menuitemUEditar.setVisible(false);
		menuitemUEliminar.setVisible(false);
		menuitemUVisualizar.setVisible(false);
		menuitemUIngresar.setValue("Interfaz/usuario.zul");
		menuitemUIngresar.addEventListener("onClick", new MenuListener());
		menuitemUEditar.setValue("Interfaz/lista_usuarios.zul");
		menuitemUEditar.addEventListener("onClick", new MenuListener());
		menuitemUEliminar.setValue("Interfaz/lista_usuarios.zul");
		menuitemUEliminar.addEventListener("onClick", new MenuListener());
		menuitemUVisualizar.setValue("Interfaz/lista_usuarios.zul");
		//menuitemCVisualizar.addEventListener("onClick", new MenuListener());
		menuCliente.appendChild(menuitemUIngresar);
		menuCliente.appendChild(menuitemUEditar);
		menuCliente.appendChild(menuitemUEliminar);
		menuCliente.appendChild(menuitemUVisualizar);
		menuUsuarios.appendChild(menuCliente);
		barraMenu.appendChild(menuUsuarios);
		
		menuCarreras = new Menu("Carreras");
		menuCarreras.setVisible(false);
		Menupopup menuHabitacion = new Menupopup();
		menuitemCVisualizar = new Menuitem("Visualizar");
		menuitemCVisualizar.setVisible(false);
		menuitemCVisualizar.setValue("Interfaz/Lista_carrera.zul");
		menuitemCVisualizar.addEventListener("onClick", new MenuListener());
				
		menuHabitacion.appendChild(menuitemCVisualizar);
		menuCarreras.appendChild(menuHabitacion);
		barraMenu.appendChild(menuCarreras);
		
		
		menuReportes = new Menu("Reportes");
		Menupopup menuReporte = new Menupopup();
		menuUsuarios.setVisible(false);
		menuitemRVisualizar = new Menuitem("Visualizar");
		menuitemRVisualizar.setVisible(false);
		menuitemRVisualizar.setValue("InterfazHotel/ListaClientes.zul");
		//menuitemCVisualizar.addEventListener("onClick", new MenuListener());
		
		menuReporte.appendChild(menuitemRVisualizar);
		menuReportes.appendChild(menuReporte);
		barraMenu.appendChild(menuReportes);
		
	}
	
	//clase interna
		class MenuListener implements EventListener<Event>{

			@Override
			public void onEvent(Event arg0) throws Exception {
				// obtener la ruta del zul a cargar
				Menuitem itemseleccionado = (Menuitem)arg0.getTarget();
				String pagina = itemseleccionado.getValue();
				// eliminar lo que haya en el centro
				
				if(centro.getFirstChild()!=null){
					centro.removeChild(centro.getFirstChild());
				}
				//crear ventanas
				
				String s = itemseleccionado.getLabel();
				Session session;
				session=Sessions.getCurrent();
				session.setAttribute("accion", s);
				
				Window win = (Window)Executions.createComponents(pagina, centro, null);
				
			}
			
		}
	
	
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		Usuario user =new Usuario();
		user = null;
		crearMenu();
		Session sesion=Sessions.getCurrent();
		user = (Usuario)sesion.getAttribute("usuario");
		
		if(user!=null){
			
			//btnCerrarSesion.setVisible(true);
			btnIniciararSesion.setVisible(false);
			lblUsuario.setValue("USUARIO: "+ user.getUser());
			lblNombre.setValue("NOMBRE: "+ user.getNombre()+" "+user.getApellido());
			
			if(user.getTipoUsuario().getIdTipousuario() == 1)
			{
				menuUsuarios.setVisible(true);
				menuCarreras.setVisible(true);
				menuReportes.setVisible(true);
				menuitemUIngresar.setVisible(true);
				menuitemUEditar.setVisible(true);
				menuitemUEliminar.setVisible(true);
				menuitemUVisualizar.setVisible(true);
				menuitemCVisualizar.setVisible(true);
				menuitemRVisualizar.setVisible(true);
		}else
			{
					btnIniciararSesion.setVisible(true);
					//btnCerrarSesion.setVisible(false);
					
				}
			}
		}
	
	
	public void onClick$btnIniciararSesion()
	{
		execution.sendRedirect("login.zul");		
	}

}
