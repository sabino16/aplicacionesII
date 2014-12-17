package com.servicios.funciones;

public class RegistrarCarrerasProxy implements com.servicios.funciones.RegistrarCarreras {
  private String _endpoint = null;
  private com.servicios.funciones.RegistrarCarreras registrarCarreras = null;
  
  public RegistrarCarrerasProxy() {
    _initRegistrarCarrerasProxy();
  }
  
  public RegistrarCarrerasProxy(String endpoint) {
    _endpoint = endpoint;
    _initRegistrarCarrerasProxy();
  }
  
  private void _initRegistrarCarrerasProxy() {
    try {
      registrarCarreras = (new com.servicios.funciones.RegistrarCarrerasServiceLocator()).getRegistrarCarreras();
      if (registrarCarreras != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)registrarCarreras)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)registrarCarreras)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (registrarCarreras != null)
      ((javax.xml.rpc.Stub)registrarCarreras)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.servicios.funciones.RegistrarCarreras getRegistrarCarreras() {
    if (registrarCarreras == null)
      _initRegistrarCarrerasProxy();
    return registrarCarreras;
  }
  
  public java.lang.String registrarusuario(java.lang.String nombres, java.lang.String apellidos, java.lang.String correo, java.lang.String cedula, java.lang.String user, java.lang.String contrasena, java.lang.String estado) throws java.rmi.RemoteException{
    if (registrarCarreras == null)
      _initRegistrarCarrerasProxy();
    return registrarCarreras.registrarusuario(nombres, apellidos, correo, cedula, user, contrasena, estado);
  }
  
  public java.lang.String registrar(int id_tarifa, int id_pasajero, java.lang.String user, java.lang.String contrasena, java.lang.String origen, java.lang.String destino, java.lang.String tiempo, double velocidad, double precio, java.lang.String fecha, java.lang.String estado) throws java.rmi.RemoteException{
    if (registrarCarreras == null)
      _initRegistrarCarrerasProxy();
    return registrarCarreras.registrar(id_tarifa, id_pasajero, user, contrasena, origen, destino, tiempo, velocidad, precio, fecha, estado);
  }
  
  
}