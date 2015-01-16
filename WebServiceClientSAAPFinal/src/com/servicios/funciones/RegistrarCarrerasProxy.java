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
  
  public boolean validacionusuario(java.lang.String userr) throws java.rmi.RemoteException{
    if (registrarCarreras == null)
      _initRegistrarCarrerasProxy();
    return registrarCarreras.validacionusuario(userr);
  }
  
  public boolean registrarusuario(java.lang.String nombres, java.lang.String apellidos, java.lang.String correo, java.lang.String cedula, java.lang.String user, java.lang.String contrasena) throws java.rmi.RemoteException{
    if (registrarCarreras == null)
      _initRegistrarCarrerasProxy();
    return registrarCarreras.registrarusuario(nombres, apellidos, correo, cedula, user, contrasena);
  }
  
  public int registrarcarrera(int id_tarifa, java.lang.String user, java.lang.String origen, java.lang.String destino, java.lang.String tiempo, double km_recorridos, double precio, java.lang.String fecha, double latitud_origen, double longitud_origen, double latitud_destino, double longitud_destino) throws java.rmi.RemoteException{
    if (registrarCarreras == null)
      _initRegistrarCarrerasProxy();
    return registrarCarreras.registrarcarrera(id_tarifa, user, origen, destino, tiempo, km_recorridos, precio, fecha, latitud_origen, longitud_origen, latitud_destino, longitud_destino);
  }
  
  public boolean iniciarsesion(java.lang.String user, java.lang.String contrasena) throws java.rmi.RemoteException{
    if (registrarCarreras == null)
      _initRegistrarCarrerasProxy();
    return registrarCarreras.iniciarsesion(user, contrasena);
  }
  
  
}