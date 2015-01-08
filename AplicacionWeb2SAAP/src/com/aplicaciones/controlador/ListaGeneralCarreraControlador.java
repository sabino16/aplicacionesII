package com.aplicaciones.controlador;

import java.util.ArrayList;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.zkoss.zk.ui.Component;
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
			Textbox textbox_usuario, textbox_tarifa, textbox_origen, textbox_destino, textbox_tiempo;
			Doublebox textbox_precio, textbox_km_recorridos;
			Datebox calendar_fecha;
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
			
			public void filtrar()
			{
				gh = new GeneralHome();
				em = gh.initEntityManager();
				ch = new CarreraHome();
				ch.setEntityManager(em);
				em.getTransaction().begin();

				if((textbox_precio.getValue()!=null)&&(textbox_km_recorridos.getValue()==null)
						&&(calendar_fecha.getValue()==null)){
					ArrayList<Carrera> lista=(ArrayList<Carrera>) ch.filtarcamposStringPrecioHQL(textbox_usuario.getValue().toString(),
							textbox_tarifa.getValue().toString(), textbox_origen.getValue().toString(),
							textbox_destino.getValue().toString(), textbox_tiempo.getValue().toString(),
							textbox_precio.getValue());
					if(lista!=null){
					ListModelList<Carrera> listmodel = new ListModelList<Carrera>(lista);
					lista_GeneralCarrera.setModel(listmodel);
					//REFRESCAR LISTA
					lista_GeneralCarrera.renderAll();
					}
					else{
						alert("lista de libros no encontrada");
					}
				}else
				{
					if((textbox_precio.getValue()==null)&&(textbox_km_recorridos.getValue()!=null)
							&&(calendar_fecha.getValue()==null)){
						ArrayList<Carrera> lista=(ArrayList<Carrera>) ch.filtarcamposStringKmHQL(textbox_usuario.getValue().toString(),
								textbox_tarifa.getValue().toString(), textbox_origen.getValue().toString(),
								textbox_destino.getValue().toString(), textbox_tiempo.getValue().toString(),
								textbox_km_recorridos.getValue());
						if(lista!=null){
						ListModelList<Carrera> listmodel = new ListModelList<Carrera>(lista);
						lista_GeneralCarrera.setModel(listmodel);
						//REFRESCAR LISTA
						lista_GeneralCarrera.renderAll();
						}
						else{
							alert("lista de libros no encontrada");
						}
					}else
					{
						if((textbox_precio.getValue()==null)&&(textbox_km_recorridos.getValue()==null)
								&&(calendar_fecha.getValue()!=null)){
							ArrayList<Carrera> lista=(ArrayList<Carrera>) ch.filtarcamposStringFechaHQL(textbox_usuario.getValue().toString(),
									textbox_tarifa.getValue().toString(), textbox_origen.getValue().toString(),
									textbox_destino.getValue().toString(), textbox_tiempo.getValue().toString(),
									calendar_fecha.getValue());
							if(lista!=null){
							ListModelList<Carrera> listmodel = new ListModelList<Carrera>(lista);
							lista_GeneralCarrera.setModel(listmodel);
							//REFRESCAR LISTA
							lista_GeneralCarrera.renderAll();
							}
							else{
								alert("lista de libros no encontrada");
							}
						}else{
							alert("falta");
						}
					}
				}
				
				
				em.getTransaction().commit();
				gh.closeEntityManager(em);
				
			}
			
			public void onChange$textbox_usuario(){
				alert("fecha: " + calendar_fecha.getValue());
				alert("usuario: " + textbox_usuario.getValue().toString());	
				alert("tarifa: " + textbox_tarifa.getValue().toString());
				alert("precio: " + textbox_precio.getValue());
				alert("origen: " + textbox_origen.getValue().toString());
				alert("destino: " + textbox_destino.getValue().toString());
				alert("km: " + textbox_km_recorridos.getValue());
			}
			
			public void onChange$textbox_tarifa(){
			
			}
			
			public void onChange$textbox_precio(){
				filtrar();
			}
			
			public void onChange$textbox_origen(){
				
			}
			
			public void onChange$textbox_destino(){
				
			}
			
			public void onChange$textbox_tiempo(){
				
			}
			
			public void onChange$textbox_km_recorridos(){
				filtrar();
			}
			
			public void onChange$calendar_fecha(){
				filtrar();
			}
}
