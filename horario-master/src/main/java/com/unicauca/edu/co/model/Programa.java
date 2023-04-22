package com.unicauca.edu.co.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="programa")
public class Programa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String prog_codigo;
	private String prog_nombre;
	private String prog_color;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties ( {"hibernateLazyInitializer", "handler"})
	private Departamento departamento;
	
	public String getProg_codigo() {
		return prog_codigo;
	}
	public void setProg_codigo(String prog_codigo) {
		this.prog_codigo = prog_codigo;
	}
	public String getProg_nombre() {
		return prog_nombre;
	}
	public void setProg_nombre(String prog_nombre) {
		this.prog_nombre = prog_nombre;
	}
	public String getProg_color() {
		return prog_color;
	}
	public void setProg_color(String prog_color) {
		this.prog_color = prog_color;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
}
