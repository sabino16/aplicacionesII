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
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.aplicaciones.modelo.Carrera;
import com.aplicaciones.modelo.GeneralHome;
import com.aplicaciones.modelo.Usuario;

public class VisualizarDatosCarreras extends GenericForwardComposer<Component> {

	
	EntityManagerFactory emfactory;
	GeneralHome gh;
	EntityManager em;
	Carrera carrera;
	
	
	@Wire
	Textbox textbox_apellidos,textbox_nombres,textbox_tarifa,
	textbox_origen,textbox_destino,textbox_tiempo,textbox_fecha;
	Doublebox textbox_KM_recorridos,textbox_precio,textbox_coord_Origen,textbox_coord_destino;
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
			textbox_apellidos.setValue(carrera.getUsuario().getApellido().toString());
			textbox_nombres.setValue(carrera.getUsuario().getNombre().toString());
			textbox_tarifa.setValue(carrera.getTarifa().toString());
			textbox_origen.setValue(carrera.getOrigen().toString());
			textbox_destino.setValue(carrera.getDestino().toString());
			textbox_tiempo.setValue(carrera.getTiempo().toString());
			textbox_fecha.setValue(carrera.getFecha().toString());
			textbox_KM_recorridos.setValue(carrera.getKmRecorridos());
			textbox_precio.setValue(carrera.getPrecio());
			
			
		}
	}

}
