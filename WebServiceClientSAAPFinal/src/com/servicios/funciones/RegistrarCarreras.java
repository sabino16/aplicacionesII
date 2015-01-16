/**
 * RegistrarCarreras.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.servicios.funciones;

public interface RegistrarCarreras extends java.rmi.Remote {
    public boolean validacionusuario(java.lang.String userr) throws java.rmi.RemoteException;
    public boolean registrarusuario(java.lang.String nombres, java.lang.String apellidos, java.lang.String correo, java.lang.String cedula, java.lang.String user, java.lang.String contrasena) throws java.rmi.RemoteException;
    public int registrarcarrera(int id_tarifa, java.lang.String user, java.lang.String origen, java.lang.String destino, java.lang.String tiempo, double km_recorridos, double precio, java.lang.String fecha, double latitud_origen, double longitud_origen, double latitud_destino, double longitud_destino) throws java.rmi.RemoteException;
    public boolean iniciarsesion(java.lang.String user, java.lang.String contrasena) throws java.rmi.RemoteException;
}
