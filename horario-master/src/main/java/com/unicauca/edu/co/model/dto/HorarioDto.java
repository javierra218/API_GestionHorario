package com.unicauca.edu.co.model.dto;

import java.io.Serializable;

public class HorarioDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long hor_id;
	private String hor_dia;
	private String hor_hora_inicio;
	private String hor_hora_fin;
	private Long recurso_id;
	private Long cusro_id;
	private String asig_nombre;
	private String cur_nombre;
	private String asig_color;
	
	public HorarioDto() {}
	
	public HorarioDto(Long hor_id, String hor_dia, String hor_hora_inicio, String hor_hora_fin, Long recurso_id,
			Long cusro_id) {
		this.hor_id = hor_id;
		this.hor_dia = hor_dia;
		this.hor_hora_inicio = hor_hora_inicio;
		this.hor_hora_fin = hor_hora_fin;
		this.recurso_id = recurso_id;
		this.cusro_id = cusro_id;
		
	}
	public HorarioDto(Long hor_id, String hor_dia, String hor_hora_inicio, String hor_hora_fin, Long recurso_id,
			Long cusro_id, String asig_nombre, String cur_nombre, String asig_color) {
		this.hor_id = hor_id;
		this.hor_dia = hor_dia;
		this.hor_hora_inicio = hor_hora_inicio;
		this.hor_hora_fin = hor_hora_fin;
		this.recurso_id = recurso_id;
		this.cusro_id = cusro_id;
		this.asig_nombre = asig_nombre;
		this.cur_nombre = cur_nombre;
		this.asig_color = asig_color;
	}
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
	public Long getRecurso_id() {
		return recurso_id;
	}
	public void setRecurso_id(Long recurso_id) {
		this.recurso_id = recurso_id;
	}
	public Long getCusro_id() {
		return cusro_id;
	}
	public void setCusro_id(Long cusro_id) {
		this.cusro_id = cusro_id;
	}
	public String getAsig_nombre() {
		return asig_nombre;
	}
	public void setAsig_nombre(String asig_nombre) {
		this.asig_nombre = asig_nombre;
	}
	public String getCur_nombre() {
		return cur_nombre;
	}
	public void setCur_nombre(String cur_nombre) {
		this.cur_nombre = cur_nombre;
	}
	public String getAsig_color() {
		return asig_color;
	}

	public void setAsig_color(String asig_color) {
		this.asig_color = asig_color;
	}
	@Override
	public String toString() {
		return "HorarioDto [hor_id=" + hor_id + ", hor_dia=" + hor_dia + ", hor_hora_inicio=" + hor_hora_inicio
				+ ", hor_hora_fin=" + hor_hora_fin + ", recurso_id=" + recurso_id + ", cusro_id=" + cusro_id
				+ ", asig_nombre=" + asig_nombre + ", cur_nombre=" + cur_nombre + "]";
	}
	
}
