package com.aplicaciones.controlador;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Center;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.aplicacionesa.modelo.GeneralHome;
import com.aplicacionesa.modelo.Usuario;
import com.aplicacionesa.modelo.UsuarioHome;



public class ListaGeneralPasajerosControlador extends GenericForwardComposer<Component> {
	
	EntityManagerFactory emfactory;
	GeneralHome gh;
	EntityManager em;
	UsuarioHome uh;
	
	@Wire
	Listbox listaPasajeros;
	Textbox textbox_Nombres, textbox_Apellidos, textbox_Cedula;
	Window WinListaPasajeros;
	Center centro;
	Button button_buscar;
	
	
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
		cargarListaPasajeros();
		//COMMIT DE LA TRANSACCION
		em.getTransaction().commit();
		//CERRAR EL ENTITY MANAGER (CERRAR CONEXION)
		gh.closeEntityManager(em);
	}
	
	
	public void cargarListaPasajeros(){
		//PRIMERO SE REALIZA UN METODO DE BUSQUEDA EN LIBROHOME
		
		    ArrayList<Usuario> lista = (ArrayList<Usuario>) uh.Reporte_Lista_Pasajeros();
			if(lista!=null){
				ListModelList<Usuario> listmodel = new ListModelList<Usuario>(lista);
				listaPasajeros.setModel(listmodel);
				//REFRESCAR LISTA
				listaPasajeros.renderAll();
			}else{
				alert("lista de pasajeros no encontrada");
			}
		
	}
	
	
	public void onClick$button_buscar(){
		filtrarPasajerosTodosFiltros(textbox_Nombres.getValue(), textbox_Apellidos.getValue(), textbox_Cedula.getValue());
	}
		
	
	public void filtrarPasajerosTodosFiltros(String nombre, String apellido, String cedula){
		//PRIMERO SE REALIZA UN METODO DE BUSQUEDA EN LIBROHOME
		gh = new GeneralHome();
		//ABRIR CONEXION PARA OBTENER EL ENTITY MANAGER--------------------
		em = gh.initEntityManager();
		//A CADA ENTIDAD SE SETEA EL ENTITY MANAGER--------------------------
		uh = new UsuarioHome();
		uh.setEntityManager(em);
		//TRANSICIONES------------------------
		//INICIAR LA TRANSICION
		em.getTransaction().begin();
		
		ArrayList<Usuario> lista = (ArrayList<Usuario>) uh.Reporte_Lista_Pasajeros_todos_filtros(nombre, apellido, cedula);
		if(lista!=null){
			ListModelList<Usuario> listmodel = new ListModelList<Usuario>(lista);
			listaPasajeros.setModel(listmodel);
			//REFRESCAR LISTA
			listaPasajeros.renderAll();
		}else{
			alert("lista de pasajeros no encontrada");
		}
		
		em.getTransaction().commit();
		//CERRAR EL ENTITY MANAGER (CERRAR CONEXION)
		gh.closeEntityManager(em);

		
	}
	
	
	public void onSelect$listaPasajeros(){
		if(centro.getFirstChild()!=null){
			centro.removeChild(centro.getFirstChild());
		}
			Usuario UsuarioSeleccionada = listaPasajeros.getSelectedItem().getValue();
			Session session;
			session=Sessions.getCurrent();
			session.setAttribute("UsuarioSeleccionada", UsuarioSeleccionada);
			
			Window win = (Window)Executions.createComponents("Reportes/Lista_General_Pasajeros_Carrera.zul", centro, null);
		}			


}
