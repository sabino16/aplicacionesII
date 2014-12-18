/**
 * ConsultarCarrerasServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.servicios.funciones;

public class ConsultarCarrerasServiceLocator extends org.apache.axis.client.Service implements com.servicios.funciones.ConsultarCarrerasService {

    public ConsultarCarrerasServiceLocator() {
    }


    public ConsultarCarrerasServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ConsultarCarrerasServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ConsultarCarreras
    private java.lang.String ConsultarCarreras_address = "http://localhost:8080/WebServiceSAAP/services/ConsultarCarreras";

    public java.lang.String getConsultarCarrerasAddress() {
        return ConsultarCarreras_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ConsultarCarrerasWSDDServiceName = "ConsultarCarreras";

    public java.lang.String getConsultarCarrerasWSDDServiceName() {
        return ConsultarCarrerasWSDDServiceName;
    }

    public void setConsultarCarrerasWSDDServiceName(java.lang.String name) {
        ConsultarCarrerasWSDDServiceName = name;
    }

    public com.servicios.funciones.ConsultarCarreras getConsultarCarreras() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ConsultarCarreras_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getConsultarCarreras(endpoint);
    }

    public com.servicios.funciones.ConsultarCarreras getConsultarCarreras(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.servicios.funciones.ConsultarCarrerasSoapBindingStub _stub = new com.servicios.funciones.ConsultarCarrerasSoapBindingStub(portAddress, this);
            _stub.setPortName(getConsultarCarrerasWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setConsultarCarrerasEndpointAddress(java.lang.String address) {
        ConsultarCarreras_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.servicios.funciones.ConsultarCarreras.class.isAssignableFrom(serviceEndpointInterface)) {
                com.servicios.funciones.ConsultarCarrerasSoapBindingStub _stub = new com.servicios.funciones.ConsultarCarrerasSoapBindingStub(new java.net.URL(ConsultarCarreras_address), this);
                _stub.setPortName(getConsultarCarrerasWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ConsultarCarreras".equals(inputPortName)) {
            return getConsultarCarreras();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://funciones.servicios.com", "ConsultarCarrerasService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://funciones.servicios.com", "ConsultarCarreras"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ConsultarCarreras".equals(portName)) {
            setConsultarCarrerasEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
