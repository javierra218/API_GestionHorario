package com.unicauca.edu.co.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "departamento")
public class Departamento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String dep_codigo;
	private String dep_nombre;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Facultad facultad;

	public String getDep_codigo() {
		return dep_codigo;
	}
	public void setDep_codigo(String dep_codigo) {
		this.dep_codigo = dep_codigo;
	}
	public String getDep_nombre() {
		return dep_nombre;
	}
	public void setDep_nombre(String dep_nombre) {
		this.dep_nombre = dep_nombre;
	}
	public Facultad getFacultad() {
		return facultad;
	}
	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}
}
