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
  
  public java.lang.String servicio_consultar_tarifa(java.lang.String tipoTarifa) throws java.rmi.RemoteException{
    if (consultarCarreras == null)
      _initConsultarCarrerasProxy();
    return consultarCarreras.servicio_consultar_tarifa(tipoTarifa);
  }
  
  public java.lang.String servicio_consultar_carrera(int idCarrera) throws java.rmi.RemoteException{
    if (consultarCarreras == null)
      _initConsultarCarrerasProxy();
    return consultarCarreras.servicio_consultar_carrera(idCarrera);
  }
  
  public java.lang.String servicio_consultar_usuario(java.lang.String usuario) throws java.rmi.RemoteException{
    if (consultarCarreras == null)
      _initConsultarCarrerasProxy();
    return consultarCarreras.servicio_consultar_usuario(usuario);
  }
  
  public java.lang.String servicio_login(java.lang.String user, java.lang.String contrasena) throws java.rmi.RemoteException{
    if (consultarCarreras == null)
      _initConsultarCarrerasProxy();
    return consultarCarreras.servicio_login(user, contrasena);
  }
  
  public java.lang.String servicio_consultar_usuario_fechas(java.lang.String f_inicio, java.lang.String f_fin, java.lang.String usuario) throws java.rmi.RemoteException{
    if (consultarCarreras == null)
      _initConsultarCarrerasProxy();
    return consultarCarreras.servicio_consultar_usuario_fechas(f_inicio, f_fin, usuario);
  }
  
  public java.lang.String servicio_consultar_usuario_origen_destino(java.lang.String parametro, java.lang.String usuario) throws java.rmi.RemoteException{
    if (consultarCarreras == null)
      _initConsultarCarrerasProxy();
    return consultarCarreras.servicio_consultar_usuario_origen_destino(parametro, usuario);
  }
  
  
}