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
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

import com.aplicacionesa.modelo.Carrera;
import com.aplicacionesa.modelo.CarreraHome;
import com.aplicacionesa.modelo.GeneralHome;
import com.aplicacionesa.modelo.Reporte_valor_Carrera;

public class MostrarCarreraPorUsuario extends GenericForwardComposer<Component> {	
	EntityManagerFactory emfactory;
	GeneralHome gh;
	EntityManager em;
	CarreraHome ch;
	Reporte_valor_Carrera reporte;
	Date FechaInicial,FechaFinal;
	
	
	@Wire
	Listbox lista_MostrarCarreraFecha;
	Label lblUsuario;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		
		super.doAfterCompose(comp);
		Session session;
		session=Sessions.getCurrent();
		
		reporte= (Reporte_valor_Carrera)session.getAttribute("ReporteSeleccionado");
		FechaInicial = (Date)session.getAttribute("FechaInicial");
		FechaFinal = (Date)session.getAttribute("FechaFinal");
	
		gh = new GeneralHome();
		em = gh.initEntityManager();
		ch = new CarreraHome();
		ch.setEntityManager(em);
		em.getTransaction().begin();
		cargarListaCarreraPorUsuario();
		em.getTransaction().commit();
		//CERRAR EL ENTITY MANAGER (CERRAR CONEXION)
		gh.closeEntityManager(em);
		
	}
	
	public void cargarListaCarreraPorUsuario(){
		
		ArrayList<Carrera> lista=(ArrayList<Carrera>) ch.MostrarDetalleCarreraPorValor(reporte.getIdUsuario()
				, FechaInicial, FechaFinal);
		if(lista!=null){
			ListModelList<Carrera> listmodel = new ListModelList<Carrera>(lista);
			lista_MostrarCarreraFecha.setModel(listmodel);
			//REFRESCAR LISTA
			lblUsuario.setValue(reporte.getNombre()+ " "+ reporte.getApellido());
			lista_MostrarCarreraFecha.renderAll();
		}else{
			alert("lista no encontrada");
		}
	}
	
	
	
	
	
}
