package com.aplicaciones.controlador;

import java.util.ArrayList;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Center;
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

public class ListaGeneralCarreraControlador extends GenericForwardComposer<Component>{
	
	//VARIABLES DEL MODELO A UTILIZAR
			EntityManagerFactory emfactory;
			GeneralHome gh;
			EntityManager em;
			CarreraHome ch;
			TarifaHome th;
			UsuarioHome uh;
			TipoUsuarioHome tu;
			
		@Wire
			Listbox lista_GeneralCarrera;
			Textbox textbox_usuario, textbox_tarifa, textbox_origen, textbox_destino;
			Doublebox textbox_precio, textbox_km_recorridos;
			Calendar calendar_fecha;
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
				ch = new CarreraHome();
				ch.setEntityManager(em);
				//TRANSICIONES------------------------
				//INICIAR LA TRANSICION
				em.getTransaction().begin();
				//cargarListaHabitacion();   //METODO CREADO EN ESTA CLASE
				cargarListaCarrera();
				//COMMIT DE LA TRANSACCION
				em.getTransaction().commit();
				//CERRAR EL ENTITY MANAGER (CERRAR CONEXION)
				gh.closeEntityManager(em);
			}
			
			public void cargarListaCarrera(){
				//PRIMERO SE REALIZA UN METODO DE BUSQUEDA EN LIBROHOME
				ArrayList<Carrera> lista=(ArrayList<Carrera>) ch.findAllHQL();
				if(lista!=null){
					ListModelList<Carrera> listmodel = new ListModelList<Carrera>(lista);
					lista_GeneralCarrera.setModel(listmodel);
					//REFRESCAR LISTA
					lista_GeneralCarrera.renderAll();
				}else{
					alert("lista de libros no encontrada");
				}
				
		}
}
