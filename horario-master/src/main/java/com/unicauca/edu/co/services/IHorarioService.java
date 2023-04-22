package com.unicauca.edu.co.services;

import org.springframework.http.ResponseEntity;

import com.unicauca.edu.co.model.Horario;
import com.unicauca.edu.co.response.HorarioResponseRest;

public interface IHorarioService {

	public ResponseEntity<HorarioResponseRest> listar();
	public ResponseEntity<HorarioResponseRest> buscarById();
	public ResponseEntity<HorarioResponseRest> buscarRecursoDiaHIniHFin(Horario horario, Long recurso_id);
	public ResponseEntity<HorarioResponseRest> asigHorarioaRecurso(Horario horario, Long recurso_id, Long curso_id);
	public ResponseEntity<HorarioResponseRest> desAsigHorarioaRecurso(Long recurso_id);
	public ResponseEntity<HorarioResponseRest> listarHorariosDeRecurso(Long horario_id);
}
