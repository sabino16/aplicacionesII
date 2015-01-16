package com.aplicaciones.controlador;

import java.util.ArrayList;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
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

import com.aplicacionesa.modelo.Carrera;
import com.aplicacionesa.modelo.CarreraHome;
import com.aplicacionesa.modelo.GeneralHome;
import com.aplicacionesa.modelo.TarifaHome;
import com.aplicacionesa.modelo.TipoUsuarioHome;
import com.aplicacionesa.modelo.UsuarioHome;



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
			Window WinListaCarreras;
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
					alert("lista no encontrada");
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
						alert("lista no encontrada");
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
							alert("lista no encontrada");
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
								alert("lista no encontrada");
							}
						}else{
							
							if((textbox_precio.getValue()!=null)&&(textbox_km_recorridos.getValue()!=null)
									&&(calendar_fecha.getValue()==null)){
								ArrayList<Carrera> lista=(ArrayList<Carrera>) ch.filtarcamposStringKmPrecioHQL(textbox_usuario.getValue().toString(), 
										textbox_tarifa.getValue().toString(), textbox_origen.getValue().toString(), textbox_destino.getValue().toString(), 
										textbox_tiempo.getValue().toString(), textbox_precio.getValue(), textbox_km_recorridos.getValue());
								if(lista!=null){
								ListModelList<Carrera> listmodel = new ListModelList<Carrera>(lista);
								lista_GeneralCarrera.setModel(listmodel);
								//REFRESCAR LISTA
								lista_GeneralCarrera.renderAll();
								}
								else{
									alert("lista no encontrada");
								}
							}else{
								if((textbox_precio.getValue()==null)&&(textbox_km_recorridos.getValue()!=null)
										&&(calendar_fecha.getValue()!=null)){
									ArrayList<Carrera> lista=(ArrayList<Carrera>) ch.filtarcamposStringKmFechaHQL(textbox_usuario.getValue().toString(), 
											textbox_tarifa.getValue().toString(), textbox_origen.getValue().toString(), textbox_destino.getValue().toString(), 
											textbox_tiempo.getValue().toString(), textbox_km_recorridos.getValue(), calendar_fecha.getValue());
									if(lista!=null){
									ListModelList<Carrera> listmodel = new ListModelList<Carrera>(lista);
									lista_GeneralCarrera.setModel(listmodel);
									//REFRESCAR LISTA
									lista_GeneralCarrera.renderAll();
									}
									else{
										alert("lista no encontrada");
									}
								}else{
									if((textbox_precio.getValue()!=null)&&(textbox_km_recorridos.getValue()==null)
											&&(calendar_fecha.getValue()!=null)){
										
										ArrayList<Carrera> lista=(ArrayList<Carrera>) ch.filtarcamposStringPrecioFechaHQL(textbox_usuario.getValue().toString(), 
												textbox_tarifa.getValue().toString(), textbox_origen.getValue().toString(), textbox_destino.getValue().toString(), 
												textbox_tiempo.getValue().toString(), textbox_precio.getValue(), calendar_fecha.getValue());
										if(lista!=null){
										ListModelList<Carrera> listmodel = new ListModelList<Carrera>(lista);
										lista_GeneralCarrera.setModel(listmodel);
										//REFRESCAR LISTA
										lista_GeneralCarrera.renderAll();
										}
										else{
											alert("lista no encontrada");
										}
									}else{
										if((textbox_precio.getValue()!=null)&&(textbox_km_recorridos.getValue()!=null)
												&&(calendar_fecha.getValue()!=null)){
											
											ArrayList<Carrera> lista=(ArrayList<Carrera>) ch.filtarcamposStringPrecioKmFechaHQL(textbox_usuario.getValue().toString(), 
													textbox_tarifa.getValue().toString(), textbox_origen.getValue().toString(), textbox_destino.getValue().toString(), 
													textbox_tiempo.getValue().toString(), textbox_km_recorridos.getValue() ,textbox_precio.getValue(), calendar_fecha.getValue());
											if(lista!=null){
											ListModelList<Carrera> listmodel = new ListModelList<Carrera>(lista);
											lista_GeneralCarrera.setModel(listmodel);
											//REFRESCAR LISTA
											lista_GeneralCarrera.renderAll();
											}else{
												alert("lista no encontrada");
											}
										}
										else{
											if((textbox_precio.getValue()==null)&&(textbox_km_recorridos.getValue()==null)
													&&(calendar_fecha.getValue()==null)){
												ArrayList<Carrera> lista=(ArrayList<Carrera>) ch.filtarcamposStringHQL(textbox_usuario.getValue().toString(), 
														textbox_tarifa.getValue().toString(), textbox_origen.getValue().toString(), textbox_destino.getValue().toString(), 
														textbox_tiempo.getValue().toString());
												if(lista!=null){
												ListModelList<Carrera> listmodel = new ListModelList<Carrera>(lista);
												lista_GeneralCarrera.setModel(listmodel);
												//REFRESCAR LISTA
												lista_GeneralCarrera.renderAll();
												}else{
													alert("lista no encontrada");
												}
											}
											else{
												alert("La validacion no existe");
											}
											
										}
									}
								}
							}
						}
					}
				}
				
				
				em.getTransaction().commit();
				gh.closeEntityManager(em);
				
			}
			
			public void onChange$textbox_usuario(){
				filtrar();
			}
			
			public void onChange$textbox_tarifa(){
				filtrar();
			}
			
			public void onChange$textbox_precio(){
				filtrar();
			}
			
			public void onChange$textbox_origen(){
				filtrar();
			}
			
			public void onChange$textbox_destino(){
				filtrar();
			}
			
			public void onChange$textbox_tiempo(){
				filtrar();
			}
			
			public void onChange$textbox_km_recorridos(){
				filtrar();
			}
			
			public void onChange$calendar_fecha(){
				filtrar();
			}
			
			
			public void onSelect$lista_GeneralCarrera(){
				if(centro.getFirstChild()!=null){
					centro.removeChild(centro.getFirstChild());
				}
					Carrera CarreraSeleccionada = lista_GeneralCarrera.getSelectedItem().getValue();
					Session session;
					session=Sessions.getCurrent();
					session.setAttribute("CarreraSeleccionada", CarreraSeleccionada);
					Window win = (Window)Executions.createComponents("Reportes/VisualizarCarrera.zul", null, null);
					//Window win = (Window)Executions.createComponents("Reportes/VisualizarCarrera.zul", centro, null);
				}
			
}
