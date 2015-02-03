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
import org.zkoss.zul.Datebox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Window;

import com.aplicacionesa.modelo.Carrera;
import com.aplicacionesa.modelo.CarreraHome;
import com.aplicacionesa.modelo.GeneralHome;
import com.aplicacionesa.modelo.Reporte_valor_Carrera;
import com.aplicacionesa.modelo.TarifaHome;
import com.aplicacionesa.modelo.TipoUsuarioHome;
import com.aplicacionesa.modelo.UsuarioHome;

public class ReporteValorControlador extends GenericForwardComposer<Component>{

	EntityManagerFactory emfactory;
	GeneralHome gh;
	EntityManager em;
	CarreraHome ch;
	TarifaHome th;
	UsuarioHome uh;
	TipoUsuarioHome tu;
	
	@Wire
	Listbox lista_GeneralReporte;
	Datebox calendar_fecha1, calendar_fecha2;
	Window WinReportevalor;
	Center centro;
	Button button_buscar;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
	}

	public void cargarlista(){
		gh = new GeneralHome();
		em = gh.initEntityManager();
		ch = new CarreraHome();
		ch.setEntityManager(em);
		em.getTransaction().begin();
		
		ArrayList<Reporte_valor_Carrera> lista=(ArrayList<Reporte_valor_Carrera>) 
				ch.listar_reporte(calendar_fecha1.getValue(), calendar_fecha2.getValue());
		if(lista!=null){
			ListModelList<Reporte_valor_Carrera> listmodel = new ListModelList<Reporte_valor_Carrera>(lista);
			lista_GeneralReporte.setModel(listmodel);
			//REFRESCAR LISTA
			lista_GeneralReporte.renderAll();
		}else{
			alert("lista no encontrada");
		}
		
		em.getTransaction().commit();
		gh.closeEntityManager(em);
	}
	
	public void onClick$button_buscar(){
		if((calendar_fecha2.getValue()!=null)&&(calendar_fecha1.getValue()!=null)){
			if(calendar_fecha1.getValue().before(calendar_fecha2.getValue()) ){
				cargarlista();
			}else{
				alert("La segunda fecha debe ser mayor que la primera");
			}	
		}else{
			alert("Faltan Datos");
		}
	}
	
	public void onSelect$lista_GeneralReporte(){
		Reporte_valor_Carrera ReporteSeleccionado = lista_GeneralReporte.getSelectedItem().getValue();
		
		//if(centro.getFirstChild()!=null){
		//	centro.removeChild(centro.getFirstChild());
		//}
		Session session;
		session=Sessions.getCurrent();
		session.setAttribute("ReporteSeleccionado", ReporteSeleccionado);
		session.setAttribute("FechaInicial",calendar_fecha1.getValue());
		session.setAttribute("FechaFinal",calendar_fecha2.getValue());
		
		Window win = (Window)Executions.createComponents("Reportes/MostrarDetalleCarreraPorFecha.zul", null, null);
		//execution.sendRedirect("Reportes/MostrarDetalleCarreraPorFecha.zul");
	}
	
}
