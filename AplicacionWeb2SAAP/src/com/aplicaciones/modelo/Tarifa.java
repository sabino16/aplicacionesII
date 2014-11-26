package com.aplicaciones.modelo;

// Generated 25/11/2014 07:33:32 PM by Hibernate Tools 3.4.0.CR1

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
	private Set<Carrera> carreras = new HashSet<Carrera>(0);

	public Tarifa() {
	}

	public Tarifa(String tipoTarifa, double valor, String estado) {
		this.tipoTarifa = tipoTarifa;
		this.valor = valor;
		this.estado = estado;
	}

	public Tarifa(String tipoTarifa, double valor, String estado,
			Set<Carrera> carreras) {
		this.tipoTarifa = tipoTarifa;
		this.valor = valor;
		this.estado = estado;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tarifa")
	public Set<Carrera> getCarreras() {
		return this.carreras;
	}

	public void setCarreras(Set<Carrera> carreras) {
		this.carreras = carreras;
	}

}
