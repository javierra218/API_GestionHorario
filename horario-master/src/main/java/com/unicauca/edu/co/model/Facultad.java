package com.unicauca.edu.co.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="facultad")
public class Facultad implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String fac_codigo;
	private String fac_nombre;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties ( {"hibernateLazyInitializer", "handler"})
	private Ubicacion ubicacion;

	public String getFac_codigo() {
		return fac_codigo;
	}
	public void setFac_codigo(String fac_codigo) {
		this.fac_codigo = fac_codigo;
	}
	public String getFac_nombre() {
		return fac_nombre;
	}
	public void setFac_nombre(String fac_nombre) {
		this.fac_nombre = fac_nombre;
	}
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	
}
