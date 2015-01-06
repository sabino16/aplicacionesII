package com.aplicaciones.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Center;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.aplicaciones.modelo.GeneralHome;
import com.aplicaciones.modelo.TipoUsuarioHome;
import com.aplicaciones.modelo.Usuario;
import com.aplicaciones.modelo.UsuarioHome;



public class ListaUsuarioControlador extends GenericForwardComposer<Component>{

	//VARIABLES DEL MODELO A UTILIZAR
		EntityManagerFactory emfactory;
		GeneralHome gh;
		EntityManager em;
		UsuarioHome uh;
		TipoUsuarioHome tu;
		String validacion;
		
	@Wire
		Listbox listaUsuarios;
		Textbox textbox_Apellidos;
		Window WinListaUsuarios;
		Center centro;
		
		@Override
		public void doAfterCompose(Component comp) throws Exception {
			// TODO Auto-generated method stub
			super.doAfterCompose(comp);
			
			
			//INICIAR EL ENTITY MANAGER---------------------------
			gh = new GeneralHome();
			//ABRIR CONEXION PARA OBTENER EL ENTITY MANAGER--------------------
			em = gh.initEntityManager();
			//A CADA ENTIDAD SE SETEA EL ENTITY MANAGER--------------------------
			uh = new UsuarioHome();
			uh.setEntityManager(em);
			//TRANSICIONES------------------------
			//INICIAR LA TRANSICION
			em.getTransaction().begin();
			//cargarListaHabitacion();   //METODO CREADO EN ESTA CLASE
			cargarListaUsuarios();
			//COMMIT DE LA TRANSACCION
			em.getTransaction().commit();
			//CERRAR EL ENTITY MANAGER (CERRAR CONEXION)
			gh.closeEntityManager(em);
			
			
		}
	
	
		public void cargarListaUsuarios(){
			//PRIMERO SE REALIZA UN METODO DE BUSQUEDA EN LIBROHOME
			ArrayList<Usuario> lista=(ArrayList<Usuario>) uh.findAll();
			if(lista!=null){
				ListModelList<Usuario> listmodel = new ListModelList<Usuario>(lista);
				listaUsuarios.setModel(listmodel);
				//REFRESCAR LISTA
				listaUsuarios.renderAll();
			}else{
				alert("lista de libros no encontrada");
			}
			
	}
		
		public void filtrarUsuarioPorApellidos(){
			em = gh.initEntityManager();
			uh.setEntityManager(em);
			em.getTransaction().begin();
			
			String apellidos = textbox_Apellidos.getValue();
			List<Usuario> lista = uh.filtrarPorApellidos(apellidos);
				
			if(lista!=null){	//TRABAJAR CON LA LISTA DE LA VISTA
				//alert("tamaño de la lista"+lista.size());
				ListModelList<Usuario> listModel= new ListModelList<Usuario>(lista);
				listaUsuarios.setModel(listModel);
				//REFRESCAR LISTA
				listaUsuarios.renderAll();
			}
			em.getTransaction().commit();
			gh.closeEntityManager(em);
		}

		public void onChange$textbox_Apellidos(){
			filtrarUsuarioPorApellidos();
		}
		
		public void onSelect$listaUsuarios(){
			if(centro.getFirstChild()!=null){
				centro.removeChild(centro.getFirstChild());
			}
				Usuario UsuarioSeleccionado = listaUsuarios.getSelectedItem().getValue();
				Session session;
				session=Sessions.getCurrent();
				session.setAttribute("UsuarioSeleccionado", UsuarioSeleccionado);
				
				Window win = (Window)Executions.createComponents("Interfaz/usuario.zul", centro, null);
			}
		
		
}
