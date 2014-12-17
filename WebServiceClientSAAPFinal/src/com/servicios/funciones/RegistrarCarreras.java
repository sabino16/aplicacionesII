/**
 * RegistrarCarreras.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.servicios.funciones;

public interface RegistrarCarreras extends java.rmi.Remote {
    public java.lang.String registrarusuario(java.lang.String nombres, java.lang.String apellidos, java.lang.String correo, java.lang.String cedula, java.lang.String user, java.lang.String contrasena) throws java.rmi.RemoteException;
    public java.lang.String registrar(int id_tarifa, int id_pasajero, java.lang.String user, java.lang.String contrasena, java.lang.String origen, java.lang.String destino, java.lang.String tiempo, double velocidad, double precio, java.lang.String fecha) throws java.rmi.RemoteException;
}
