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
@Table(name="horario")
public class Horario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long hor_id;
	private String hor_dia;
//	@Temporal(TemporalType.TIME)
	private String hor_hora_inicio;
//	@Temporal(TemporalType.TIME)
	private String hor_hora_fin;
	
//	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Recurso recurso;
	
//	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Curso curso;

	//getters and setters
	public Long getHor_id() {
		return hor_id;
	}
	public void setHor_id(Long hor_id) {
		this.hor_id = hor_id;
	}
	public String getHor_dia() {
		return hor_dia;
	}
	public void setHor_dia(String hor_dia) {
		this.hor_dia = hor_dia;
	}
	public String getHor_hora_inicio() {
		return hor_hora_inicio;
	}
	public void setHor_hora_inicio(String hor_hora_inicio) {
		this.hor_hora_inicio = hor_hora_inicio;
	}
	public String getHor_hora_fin() {
		return hor_hora_fin;
	}
	public void setHor_hora_fin(String hor_hora_fin) {
		this.hor_hora_fin = hor_hora_fin;
	}
	public Recurso getRecurso() {
		return recurso;
	}
	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
