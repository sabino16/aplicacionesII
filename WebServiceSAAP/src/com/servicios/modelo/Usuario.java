package com.servicios.modelo;

// Generated 03/12/2014 01:14:00 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "usuario", catalog = "aplicaciones")
public class Usuario implements java.io.Serializable {

	private Integer idUsuario;
	private TipoUsuario tipoUsuario;
	private String user;
	private String pass;
	private String nombre;
	private String apellido;
	private String correo;
	private String cedula;
	private String estado;
	private Set<Carrera> carreras = new HashSet<Carrera>(0);

	public Usuario() {
	}

	public Usuario(TipoUsuario tipoUsuario, String user, String pass,
			String nombre, String apellido, String correo, String cedula,
			String estado) {
		this.tipoUsuario = tipoUsuario;
		this.user = user;
		this.pass = pass;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.cedula = cedula;
		this.estado = estado;
	}

	public Usuario(TipoUsuario tipoUsuario, String user, String pass,
			String nombre, String apellido, String correo, String cedula,
			String estado, Set<Carrera> carreras) {
		this.tipoUsuario = tipoUsuario;
		this.user = user;
		this.pass = pass;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.cedula = cedula;
		this.estado = estado;
		this.carreras = carreras;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_usuario", unique = true, nullable = false)
	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipousuario", nullable = false)
	public TipoUsuario getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Column(name = "user", nullable = false, length = 50)
	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Column(name = "pass", nullable = false, length = 50)
	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Column(name = "nombre", nullable = false, length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "apellido", nullable = false, length = 50)
	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Column(name = "correo", nullable = false, length = 50)
	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Column(name = "cedula", nullable = false, length = 50)
	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	@Column(name = "estado", nullable = false, length = 1)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Carrera> getCarreras() {
		return this.carreras;
	}

	public void setCarreras(Set<Carrera> carreras) {
		this.carreras = carreras;
	}

}
