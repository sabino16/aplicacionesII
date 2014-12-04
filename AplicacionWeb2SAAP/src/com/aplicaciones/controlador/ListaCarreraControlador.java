package com.aplicaciones.controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

import com.aplicaciones.modelo.Carrera;
import com.aplicaciones.modelo.CarreraHome;
import com.aplicaciones.modelo.GeneralHome;




public class ListaCarreraControlador extends GenericForwardComposer<Component> {
	EntityManagerFactory emfactory;
	GeneralHome gh;
	EntityManager em;
	CarreraHome ch;
	
	@Wire
	Textbox textbox_Nombre, textbox_Apellidos, textbox_Placa;
	Listbox listaCarreras;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		
		cargarListaCarreras();   //METODO CREADO EN ESTA CLASE
		
		
	}	
	
	public void cargarListaCarreras(){
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
		
		ArrayList<Carrera> lista=(ArrayList<Carrera>) ch.findAll();
		if(lista!=null){
			ListModelList<Carrera> listmodel = new ListModelList<Carrera>(lista);
			listaCarreras.setModel(listmodel);
			//REFRESCAR LISTA
			listaCarreras.renderAll();
		}else{
			alert("lista de libros no encontrada");
		}
		//COMMIT DE LA TRANSACCION
			em.getTransaction().commit();
			//CERRAR EL ENTITY MANAGER (CERRAR CONEXION)
			gh.closeEntityManager(em);
	}
	
	public void filtrarCompleto(){
		em = gh.initEntityManager();
		ch.setEntityManager(em);
		em.getTransaction().begin();
		
		String nombres = textbox_Nombre.getValue();
		String apellidos = textbox_Apellidos.getValue();
		String placa = textbox_Placa.getValue();
		
		List<Carrera> lista = (List<Carrera>) ch.filtrarCompleto(nombres, apellidos, placa);
			
		if(lista!=null){	//TRABAJAR CON LA LISTA DE LA VISTA
			ListModelList<Carrera> listModel= new ListModelList<Carrera>(lista);
			listaCarreras.setModel(listModel);
			//REFRESCAR LISTA
			listaCarreras.renderAll();
		}
		em.getTransaction().commit();
		gh.closeEntityManager(em);
		}
	
	public void filtrarApellido(){
		em = gh.initEntityManager();
		ch.setEntityManager(em);
		em.getTransaction().begin();

		String apellidos = textbox_Apellidos.getValue();
		
		List<Carrera> lista = (List<Carrera>) ch.filtrarApellido(apellidos);
			
		if(lista!=null){	//TRABAJAR CON LA LISTA DE LA VISTA
			ListModelList<Carrera> listModel= new ListModelList<Carrera>(lista);
			listaCarreras.setModel(listModel);
			//REFRESCAR LISTA
			listaCarreras.renderAll();
		}
		em.getTransaction().commit();
		gh.closeEntityManager(em);
		}
	
	public void filtrarNombre(){
		em = gh.initEntityManager();
		ch.setEntityManager(em);
		em.getTransaction().begin();

		String nombres = textbox_Nombre.getValue();
		
		List<Carrera> lista = (List<Carrera>) ch.filtrarNombre(nombres);
			
		if(lista!=null){	//TRABAJAR CON LA LISTA DE LA VISTA
			ListModelList<Carrera> listModel= new ListModelList<Carrera>(lista);
			listaCarreras.setModel(listModel);
			//REFRESCAR LISTA
			listaCarreras.renderAll();
		}
		em.getTransaction().commit();
		gh.closeEntityManager(em);
		}
	
	public void filtrarPlaca(){
		em = gh.initEntityManager();
		ch.setEntityManager(em);
		em.getTransaction().begin();

		String placa = textbox_Placa.getValue();
		
		List<Carrera> lista = (List<Carrera>) ch.filtrarPlaca(placa);
			
		if(lista!=null){	//TRABAJAR CON LA LISTA DE LA VISTA
			ListModelList<Carrera> listModel= new ListModelList<Carrera>(lista);
			listaCarreras.setModel(listModel);
			//REFRESCAR LISTA
			listaCarreras.renderAll();
		}
		em.getTransaction().commit();
		gh.closeEntityManager(em);
		}
	

}
