package com.aplicaciones.controlador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.aplicacionesa.modelo.Carrera;
import com.aplicacionesa.modelo.GeneralHome;


public class VisualizarDatosCarreras extends GenericForwardComposer<Component> {

	
	EntityManagerFactory emfactory;
	GeneralHome gh;
	EntityManager em;
	Carrera carrera;
	
	
	@Wire
	
	Label lbl_apellidos,lbl_nombres,lbl_tarifa,
	lbl_origen,lbl_destino,lbl_tiempo,lbl_fecha,
	lbl_KM_recorridos,lbl_precio,lbl_coord_Origen,lbl_coord_destino;
	Window WinVisualizarCarreras;
	
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		
		
		Session session;
		session=Sessions.getCurrent();
		
		carrera= (Carrera)session.getAttribute("CarreraSeleccionada");
		
		if(carrera!=null){
			//cargar datos en el formulario mediante la session	
			lbl_apellidos.setValue(carrera.getUsuario().getApellido().toString());
			lbl_nombres.setValue(carrera.getUsuario().getNombre().toString());
			lbl_tarifa.setValue(carrera.getTarifa().getTipoTarifa());
			lbl_origen.setValue(carrera.getOrigen().toString());
			lbl_destino.setValue(carrera.getDestino().toString());
			lbl_tiempo.setValue(carrera.getTiempo().toString());
			lbl_fecha.setValue(carrera.getFecha().toString());
			lbl_KM_recorridos.setValue(""+carrera.getKmRecorridos());
			lbl_precio.setValue(""+carrera.getPrecio());
			lbl_coord_Origen.setValue("lat="+carrera.getLatitudOrigen() +"  long="+carrera.getLongitudOrigen());
			lbl_coord_destino.setValue("lat="+carrera.getLatitudDestino() +"  long="+carrera.getLongitudDestino());
		}
	}

}
