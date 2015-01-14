package com.serviciosa.modelo;

// Generated 14/01/2015 08:56:38 AM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Tarifa generated by hbm2java
 */
@Entity
@Table(name = "tarifa", catalog = "aplicaciones")
public class Tarifa implements java.io.Serializable {

	private Integer idTarifa;
	private String tipoTarifa;
	private double valor;
	private String estado;
	private double tarifaArranque;
	private double costoKm;
	private double costoMinEspera;
	private double tarifaMinima;
	private double velocidadCritica;
	private Set<Carrera> carreras = new HashSet<Carrera>(0);

	public Tarifa() {
	}

	public Tarifa(String tipoTarifa, double valor, String estado,
			double tarifaArranque, double costoKm, double costoMinEspera,
			double tarifaMinima, double velocidadCritica) {
		this.tipoTarifa = tipoTarifa;
		this.valor = valor;
		this.estado = estado;
		this.tarifaArranque = tarifaArranque;
		this.costoKm = costoKm;
		this.costoMinEspera = costoMinEspera;
		this.tarifaMinima = tarifaMinima;
		this.velocidadCritica = velocidadCritica;
	}

	public Tarifa(String tipoTarifa, double valor, String estado,
			double tarifaArranque, double costoKm, double costoMinEspera,
			double tarifaMinima, double velocidadCritica, Set<Carrera> carreras) {
		this.tipoTarifa = tipoTarifa;
		this.valor = valor;
		this.estado = estado;
		this.tarifaArranque = tarifaArranque;
		this.costoKm = costoKm;
		this.costoMinEspera = costoMinEspera;
		this.tarifaMinima = tarifaMinima;
		this.velocidadCritica = velocidadCritica;
		this.carreras = carreras;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_tarifa", unique = true, nullable = false)
	public Integer getIdTarifa() {
		return this.idTarifa;
	}

	public void setIdTarifa(Integer idTarifa) {
		this.idTarifa = idTarifa;
	}

	@Column(name = "tipo_tarifa", nullable = false, length = 100)
	public String getTipoTarifa() {
		return this.tipoTarifa;
	}

	public void setTipoTarifa(String tipoTarifa) {
		this.tipoTarifa = tipoTarifa;
	}

	@Column(name = "valor", nullable = false, precision = 22, scale = 0)
	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Column(name = "estado", nullable = false, length = 1)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Column(name = "tarifa_arranque", nullable = false, precision = 22, scale = 0)
	public double getTarifaArranque() {
		return this.tarifaArranque;
	}

	public void setTarifaArranque(double tarifaArranque) {
		this.tarifaArranque = tarifaArranque;
	}

	@Column(name = "costo_km", nullable = false, precision = 22, scale = 0)
	public double getCostoKm() {
		return this.costoKm;
	}

	public void setCostoKm(double costoKm) {
		this.costoKm = costoKm;
	}

	@Column(name = "costo_min_espera", nullable = false, precision = 22, scale = 0)
	public double getCostoMinEspera() {
		return this.costoMinEspera;
	}

	public void setCostoMinEspera(double costoMinEspera) {
		this.costoMinEspera = costoMinEspera;
	}

	@Column(name = "tarifa_minima", nullable = false, precision = 22, scale = 0)
	public double getTarifaMinima() {
		return this.tarifaMinima;
	}

	public void setTarifaMinima(double tarifaMinima) {
		this.tarifaMinima = tarifaMinima;
	}

	@Column(name = "velocidad_critica", nullable = false, precision = 22, scale = 0)
	public double getVelocidadCritica() {
		return this.velocidadCritica;
	}

	public void setVelocidadCritica(double velocidadCritica) {
		this.velocidadCritica = velocidadCritica;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tarifa")
	public Set<Carrera> getCarreras() {
		return this.carreras;
	}

	public void setCarreras(Set<Carrera> carreras) {
		this.carreras = carreras;
	}

	
	public String toJsonCDCarrera() {
		return "{'idTarifa':" + idTarifa + ", 'tipoTarifa':'" + tipoTarifa
				+ "', 'valor':'" + valor + "'}";
	}

	public String toJsonCDTarifa() {
		return "{'idTarifa':" + idTarifa + ", 'tipoTarifa':'" + tipoTarifa
				+ "', 'valor':'" + valor + "'}";
	}
}
