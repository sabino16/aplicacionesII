package com.aplicaciones.controlador;


import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Center;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.aplicaciones.modelo.Carrera;
import com.aplicaciones.modelo.CarreraHome;
import com.aplicaciones.modelo.GeneralHome;
import com.aplicaciones.modelo.TarifaHome;
import com.aplicaciones.modelo.TipoUsuarioHome;
import com.aplicaciones.modelo.Usuario;
import com.aplicaciones.modelo.UsuarioHome;

public class ListaGeneralPasajeroCarreraControlador extends GenericForwardComposer<Component> {

	//VARIABLES DEL MODELO A UTILIZAR
	EntityManagerFactory emfactory;
	GeneralHome gh;
	EntityManager em;
	CarreraHome ch;
	TarifaHome th;
	UsuarioHome uh;
	TipoUsuarioHome tu;
	
@Wire
	Listbox lista_General_Pasajero_Carrera;
	Textbox textbox_tarifa, textbox_origen, textbox_destino;
	Datebox calendar_fecha;
	Window WinListaCarreras;
	Center centro;
	Usuario usuario;
	int ux=0;
	
	
	
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		
		Session session;
		session=Sessions.getCurrent();
		
		usuario= (Usuario)session.getAttribute("UsuarioSeleccionada");
		ux = usuario.getIdUsuario();
		//INICIAR EL ENTITY MANAGER---------------------------
		gh = new GeneralHome();
		//ABRIR CONEXION PARA OBTENER EL ENTITY MANAGER--------------------
		em = gh.initEntityManager();
		//A CADA ENTIDAD SE SETEA EL ENTITY MANAGER--------------------------
		ch = new CarreraHome();
		ch.setEntityManager(em);
		//TRANSICIONES------------------------
		//INICIAR LA TRANSICION
		em.getTransaction().begin();
		//cargarListaHabitacion();   //METODO CREADO EN ESTA CLASE
		cargarListaCarrera(usuario.getIdUsuario());
		//COMMIT DE LA TRANSACCION
		em.getTransaction().commit();
		//CERRAR EL ENTITY MANAGER (CERRAR CONEXION)
		gh.closeEntityManager(em);
	}

	
	public void cargarListaCarrera(int IdUsuario){
		//PRIMERO SE REALIZA UN METODO DE BUSQUEDA EN LIBROHOME
		ArrayList<Carrera> lista=(ArrayList<Carrera>) ch.findAllIdUsuario(IdUsuario);
		if(lista!=null){
			ListModelList<Carrera> listmodel = new ListModelList<Carrera>(lista);
			lista_General_Pasajero_Carrera.setModel(listmodel);
			//REFRESCAR LISTA
			lista_General_Pasajero_Carrera.renderAll();
		}else{
			alert("lista no encontrada");
		}
    }

	
public void onChange$textbox_tarifa(){
		
	filtrarCarreraPasajerosTodosFiltros();
		
	}

public void onChange$textbox_origen(){
	
	filtrarCarreraPasajerosTodosFiltros();
		
	}

public void onChange$textbox_destino(){
	
	filtrarCarreraPasajerosTodosFiltros();
		
	}

public void onChange$calendar_fecha(){
	
	filtrarCarreraPasajerosTodosFiltros();
	
			
	}


	public void filtrarCarreraPasajerosTodosFiltros(){
		//PRIMERO SE REALIZA UN METODO DE BUSQUEDA EN LIBROHOME
		gh = new GeneralHome();
		//ABRIR CONEXION PARA OBTENER EL ENTITY MANAGER--------------------
		em = gh.initEntityManager();
		//A CADA ENTIDAD SE SETEA EL ENTITY MANAGER--------------------------
		ch = new CarreraHome();
		
		ch.setEntityManager(em);
		//TRANSICIONES------------------------
		//INICIAR LA TRANSICION
		em.getTransaction().begin();
		
		ArrayList<Carrera> lista = (ArrayList<Carrera>) ch.findAllIdUsuarioFiltrosTodos(ux, textbox_tarifa.getValue(), textbox_origen.getValue(), textbox_destino.getValue());
		if(lista!=null){
			ListModelList<Carrera> listmodel = new ListModelList<Carrera>(lista);
			lista_General_Pasajero_Carrera.setModel(listmodel);
			//REFRESCAR LISTA
			lista_General_Pasajero_Carrera.renderAll();
		}else{
			alert("lista de carreras del pasajero no encontrada");
		}
		
		em.getTransaction().commit();
		//CERRAR EL ENTITY MANAGER (CERRAR CONEXION)
		gh.closeEntityManager(em);

		
	}
	
	
	
	
}







