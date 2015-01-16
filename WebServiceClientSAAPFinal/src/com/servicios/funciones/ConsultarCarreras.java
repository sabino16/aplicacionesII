/**
 * ConsultarCarreras.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.servicios.funciones;

public interface ConsultarCarreras extends java.rmi.Remote {
    public java.lang.String servicio_consultar_tarifa(java.lang.String tipoTarifa) throws java.rmi.RemoteException;
    public java.lang.String servicio_consultar_usuario(java.lang.String usuario) throws java.rmi.RemoteException;
    public java.lang.String servicio_consultar_carrera(int idCarrera) throws java.rmi.RemoteException;
    public java.lang.String servicio_consultar_usuario_origen_destino(java.lang.String parametro, java.lang.String usuario) throws java.rmi.RemoteException;
    public java.lang.String servicio_consultar_usuario_fechas(java.lang.String f_inicio, java.lang.String f_fin, java.lang.String usuario) throws java.rmi.RemoteException;
    public java.lang.String servicio_login(java.lang.String user, java.lang.String contrasena) throws java.rmi.RemoteException;
}
