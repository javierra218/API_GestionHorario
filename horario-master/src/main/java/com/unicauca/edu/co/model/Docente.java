package com.unicauca.edu.co.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="docente")
public class Docente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long doc_id;
	private String doc_codigo;
	private String doc_nombre;
	private String doc_tipovinculacion;
	private String doc_horasasignadas;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties ( {"hibernateLazyInitializer", "handler"})
	private Departamento departamento;
	
	public Long getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(Long doc_id) {
		this.doc_id = doc_id;
	}
	public String getDoc_codigo() {
		return doc_codigo;
	}
	public void setDoc_codigo(String doc_codigo) {
		this.doc_codigo = doc_codigo;
	}
	public String getDoc_nombre() {
		return doc_nombre;
	}
	public void setDoc_nombre(String doc_nombre) {
		this.doc_nombre = doc_nombre;
	}
	public String getDoc_tipovinculacion() {
		return doc_tipovinculacion;
	}
	public void setDoc_tipovinculacion(String doc_tipovinculacion) {
		this.doc_tipovinculacion = doc_tipovinculacion;
	}
	public String getDoc_horasasignadas() {
		return doc_horasasignadas;
	}
	public void setDoc_horasasignadas(String doc_horasasignadas) {
		this.doc_horasasignadas = doc_horasasignadas;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
}
