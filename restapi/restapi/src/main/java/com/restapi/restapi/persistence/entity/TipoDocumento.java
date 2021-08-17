package com.restapi.restapi.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tipo_documento")
public class TipoDocumento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_documento")
	private Integer idTipoDocumento;
	
	private String nombre;
	
	@OneToMany(mappedBy = "tipoDocumento")
	private List<Cliente> clientes;
	
	

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Integer getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(Integer idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
