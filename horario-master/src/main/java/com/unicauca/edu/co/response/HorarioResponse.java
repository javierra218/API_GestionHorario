package com.unicauca.edu.co.response;

import java.util.List;

import com.unicauca.edu.co.model.Horario;
import com.unicauca.edu.co.model.dto.HorarioDto;

public class HorarioResponse {

	private List<Horario> horario;

	private List<HorarioDto> horarioDto;
	
	public List<Horario> getHorario() {
		return horario;
	}
	public void setHorario(List<Horario> horario) {
		this.horario = horario;
	}
	public List<HorarioDto> getHorarioDto() {
		return horarioDto;
	}
	public void setHorarioDto(List<HorarioDto> horarioDto) {
		this.horarioDto = horarioDto;
	}
}
