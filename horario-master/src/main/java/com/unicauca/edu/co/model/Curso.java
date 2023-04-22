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
@Table(name="curso")
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cur_id;
	private String cur_nombre;
	private Integer cur_capmax;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties ( {"hibernateLazyInitializer", "handler"})
	private Asignatura asignatura;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties ( {"hibernateLazyInitializer", "handler"})
	private Periodo periodo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties ( {"hibernateLazyInitializer", "handler"})
	private Docente docente;
	private Boolean cur_estado;
	
	
	public Boolean getCur_estado() {
		return cur_estado;
	}
	public void setCur_estado(Boolean cur_estado) {
		this.cur_estado = cur_estado;
	}
	//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recurso")
//	private List<Horario> horarios;
//	
//	public List<Horario> getHorarios() {
//		return horarios;
//	}
//	public void setHorarios(List<Horario> horarios) {
//		this.horarios = horarios;
//	}
	//getter and setter
	public Asignatura getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Periodo getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	public Long getCur_id() {
		return cur_id;
	}
	public void setCur_id(Long cur_id) {
		this.cur_id = cur_id;
	}
	public String getCur_nombre() {
		return cur_nombre;
	}
	public void setCur_nombre(String cur_nombre) {
		this.cur_nombre = cur_nombre;
	}
	public Integer getCur_capmax() {
		return cur_capmax;
	}
	public void setCur_capmax(Integer cur_capmax) {
		this.cur_capmax = cur_capmax;
	}
}
