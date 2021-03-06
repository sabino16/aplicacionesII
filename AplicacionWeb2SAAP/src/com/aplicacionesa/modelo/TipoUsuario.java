package com.aplicacionesa.modelo;

// Generated 14/01/2015 09:20:48 AM by Hibernate Tools 3.4.0.CR1

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
 * TipoUsuario generated by hbm2java
 */
@Entity
@Table(name = "tipo_usuario", catalog = "aplicaciones")
public class TipoUsuario implements java.io.Serializable {

	private Integer idTipousuario;
	private String descripcion;
	private String estado;
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);

	public TipoUsuario() {
	}

	public TipoUsuario(String descripcion, String estado) {
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public TipoUsuario(String descripcion, String estado, Set<Usuario> usuarios) {
		this.descripcion = descripcion;
		this.estado = estado;
		this.usuarios = usuarios;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_tipousuario", unique = true, nullable = false)
	public Integer getIdTipousuario() {
		return this.idTipousuario;
	}

	public void setIdTipousuario(Integer idTipousuario) {
		this.idTipousuario = idTipousuario;
	}

	@Column(name = "descripcion", nullable = false, length = 50)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "estado", nullable = false, length = 1)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoUsuario")
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
