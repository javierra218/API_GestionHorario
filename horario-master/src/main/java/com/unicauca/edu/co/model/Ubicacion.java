package com.unicauca.edu.co.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="ubicacion")
public class Ubicacion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String ubi_codigo;
	private String ubi_nombre;
	private String ubi_direccion;
	private String ubi_ciudad;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Ubicacion ubicacion;

	public String getUbi_codigo() {
		return ubi_codigo;
	}
	public void setUbi_codigo(String ubi_codigo) {
		this.ubi_codigo = ubi_codigo;
	}
	public String getUbi_nombre() {
		return ubi_nombre;
	}
	public void setUbi_nombre(String ubi_nombre) {
		this.ubi_nombre = ubi_nombre;
	}
	public String getUbi_direccion() {
		return ubi_direccion;
	}
	public void setUbi_direccion(String ubi_direccion) {
		this.ubi_direccion = ubi_direccion;
	}
	public String getUbi_ciudad() {
		return ubi_ciudad;
	}
	public void setUbi_ciudad(String ubi_ciudad) {
		this.ubi_ciudad = ubi_ciudad;
	}
	
}
