package com.unicauca.edu.co.model.dto;

public class RecursoDto {
	
	private Long Rec_id;
	private String Rec_codigo;
	private String Fac_codigo;
	private String Rec_descripcion;
	private Integer Rec_capmax;
	private String Rec_nombre;
	private String Rectipo_codigo;
	private String Ubi_codigo;
	
	public RecursoDto(Long rec_id, String rec_codigo, String fac_codigo, String rec_descripcion, Integer rec_capmax,
			String rec_nombre, String rectipo_codigo, String ubi_codigo) {
		Rec_id = rec_id;
		Rec_codigo = rec_codigo;
		Fac_codigo = fac_codigo;
		Rec_descripcion = rec_descripcion;
		Rec_capmax = rec_capmax;
		Rec_nombre = rec_nombre;
		Rectipo_codigo = rectipo_codigo;
		Ubi_codigo = ubi_codigo;
	}
	public Long getRec_id() {
		return Rec_id;
	}
	public void setRec_id(Long rec_id) {
		Rec_id = rec_id;
	}
	public String getRec_codigo() {
		return Rec_codigo;
	}
	public void setRec_codigo(String rec_codigo) {
		Rec_codigo = rec_codigo;
	}
	public String getFac_codigo() {
		return Fac_codigo;
	}
	public void setFac_codigo(String fac_codigo) {
		Fac_codigo = fac_codigo;
	}
	public String getRec_descripcion() {
		return Rec_descripcion;
	}
	public void setRec_descripcion(String rec_descripcion) {
		Rec_descripcion = rec_descripcion;
	}
	public Integer getRec_capmax() {
		return Rec_capmax;
	}
	public void setRec_capmax(Integer rec_capmax) {
		Rec_capmax = rec_capmax;
	}
	public String getRec_nombre() {
		return Rec_nombre;
	}
	public void setRec_nombre(String rec_nombre) {
		Rec_nombre = rec_nombre;
	}
	public String getRectipo_codigo() {
		return Rectipo_codigo;
	}
	public void setRectipo_codigo(String rectipo_codigo) {
		Rectipo_codigo = rectipo_codigo;
	}
	public String getUbi_codigo() {
		return Ubi_codigo;
	}
	public void setUbi_codigo(String ubi_codigo) {
		Ubi_codigo = ubi_codigo;
	}
}
