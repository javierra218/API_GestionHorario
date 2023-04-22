package com.unicauca.edu.co.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tiporecurso")
public class Tiporecurso implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	//@JsonBackReference//evita traer el atributo del codigo
	private String rectipo_codigo;
	private String rectipo_nombre;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties ( {"hibernateLazyInitializer", "handler"})
	private Tiporecurso tiporecurso;
	//@JsonBackReference//evita traer el padre
	//@JsonManagedReference
	

	public String getRectipo_codigo() {
		return rectipo_codigo;
	}
	public void setRectipo_codigo(String rectipo_codigo) {
		this.rectipo_codigo = rectipo_codigo;
	}
	public String getRectipo_nombre() {
		return rectipo_nombre;
	}
	public void setRectipo_nombre(String rectipo_nombre) {
		this.rectipo_nombre = rectipo_nombre;
	}
	public Tiporecurso getTiporecurso() {
		return tiporecurso;
	}
	public void setTiporecurso(Tiporecurso tiporecurso) {
		this.tiporecurso = tiporecurso;
	}
	
}
