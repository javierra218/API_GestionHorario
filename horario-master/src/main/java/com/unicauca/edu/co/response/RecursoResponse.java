package com.unicauca.edu.co.response;

import java.util.List;

import com.unicauca.edu.co.model.Recurso;
import com.unicauca.edu.co.model.dto.RecursoDto;

public class RecursoResponse {
	
	private List<Recurso> recurso;
	
	private List<RecursoDto> recursoDto;

	public List<RecursoDto> getRecursoDto() {
		return recursoDto;
	}

	public void setRecursoDto(List<RecursoDto> recursoDto) {
		this.recursoDto = recursoDto;
	}

	public List<Recurso> getRecurso() {
		return recurso;
	}

	public void setRecurso(List<Recurso> recurso) {
		this.recurso = recurso;
	}
	
}
