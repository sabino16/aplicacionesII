package com.aplicacionesa.modelo;

public class Reporte_valor_Carrera {

	private Integer idUsuario;
	private String nombre;
	private String apellido;
	private double valor_total;
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public double getValor_total() {
		return valor_total;
	}
	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}
	
	public Reporte_valor_Carrera(Integer idUsuario, String nombre,
			String apellido, double valor_total) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.valor_total = valor_total;
	}
	
	public Reporte_valor_Carrera() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
