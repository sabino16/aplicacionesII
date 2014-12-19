package com.servicios.funciones;

public class ConsultarCarrerasProxy implements com.servicios.funciones.ConsultarCarreras {
  private String _endpoint = null;
  private com.servicios.funciones.ConsultarCarreras consultarCarreras = null;
  
  public ConsultarCarrerasProxy() {
    _initConsultarCarrerasProxy();
  }
  
  public ConsultarCarrerasProxy(String endpoint) {
    _endpoint = endpoint;
    _initConsultarCarrerasProxy();
  }
  
  private void _initConsultarCarrerasProxy() {
    try {
      consultarCarreras = (new com.servicios.funciones.ConsultarCarrerasServiceLocator()).getConsultarCarreras();
      if (consultarCarreras != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)consultarCarreras)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)consultarCarreras)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (consultarCarreras != null)
      ((javax.xml.rpc.Stub)consultarCarreras)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.servicios.funciones.ConsultarCarreras getConsultarCarreras() {
    if (consultarCarreras == null)
      _initConsultarCarrerasProxy();
    return consultarCarreras;
  }
  
  public java.lang.String consultardatoscarrera(int idCarrera) throws java.rmi.RemoteException{
    if (consultarCarreras == null)
      _initConsultarCarrerasProxy();
    return consultarCarreras.consultardatoscarrera(idCarrera);
  }
  
  public java.lang.String listahistorial() throws java.rmi.RemoteException{
    if (consultarCarreras == null)
      _initConsultarCarrerasProxy();
    return consultarCarreras.listahistorial();
  }
  
  public java.lang.String consultardatosusuario(int idUsuario) throws java.rmi.RemoteException{
    if (consultarCarreras == null)
      _initConsultarCarrerasProxy();
    return consultarCarreras.consultardatosusuario(idUsuario);
  }
  
  public java.lang.String consultarhistorial(int idUsuario) throws java.rmi.RemoteException{
    if (consultarCarreras == null)
      _initConsultarCarrerasProxy();
    return consultarCarreras.consultarhistorial(idUsuario);
  }
  
  
}