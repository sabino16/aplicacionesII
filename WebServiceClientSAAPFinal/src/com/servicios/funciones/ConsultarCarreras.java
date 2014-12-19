/**
 * ConsultarCarreras.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.servicios.funciones;

public interface ConsultarCarreras extends java.rmi.Remote {
    public java.lang.String consultardatoscarrera(int idCarrera) throws java.rmi.RemoteException;
    public java.lang.String listahistorial() throws java.rmi.RemoteException;
    public java.lang.String consultardatosusuario(int idUsuario) throws java.rmi.RemoteException;
    public java.lang.String consultarhistorial(int idUsuario) throws java.rmi.RemoteException;
}
