package com.unicauca.edu.co.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="periodo")
public class Periodo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String per_codigo;
	private String per_nombre;
	private Date per_fechainicio;
	private Date per_fechafin;
	
	public String getPer_codigo() {
		return per_codigo;
	}
	public void setPer_codigo(String per_codigo) {
		this.per_codigo = per_codigo;
	}
	public String getPer_nombre() {
		return per_nombre;
	}
	public void setPer_nombre(String per_nombre) {
		this.per_nombre = per_nombre;
	}
	public Date getPer_fechainicio() {
		return per_fechainicio;
	}
	public void setPer_fechainicio(Date per_fechainicio) {
		this.per_fechainicio = per_fechainicio;
	}
	public Date getPer_fechafin() {
		return per_fechafin;
	}
	public void setPer_fechafin(Date per_fechafin) {
		this.per_fechafin = per_fechafin;
	}

}
