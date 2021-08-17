package com.restapi.restapi.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Integer idCliente;
	
	private String nombre;
	private String apellidos;
	private Integer edad;
	
	@Column(name = "ciudad_nacimiento")
	private String ciudadNacimiento;
	
	@Column(name = "id_tipo_de_documento")
	private Integer idTipoDocumento;
	
	@Column(name = "numero_identificacion")
	private String numeroIdentificacion;

	@Column(name = "foto_id")
	private String fotoId;


	
	@ManyToOne
	@JoinColumn(name = "id_tipo_de_documento", insertable = false, updatable = false)
	private TipoDocumento tipoDocumento;
	
	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getCiudadNacimiento() {
		return ciudadNacimiento;
	}

	public void setCiudadNacimiento(String ciudadNacimiento) {
		this.ciudadNacimiento = ciudadNacimiento;
	}

	public Integer getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(Integer idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getFotoId() {
		return fotoId;
	}

	public void setFotoId(String fotoId) {
		this.fotoId = fotoId;
	}
}
