package com.unicauca.edu.co.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.edu.co.model.Horario;
import com.unicauca.edu.co.response.HorarioResponseRest;
import com.unicauca.edu.co.services.IHorarioService;

@CrossOrigin(origins = {"http://192.168.101.11:4200/","http://localhost:4200/"})
@RestController
@RequestMapping("/api/v1")
public class HorarioRestController {
	
	@Autowired
	private IHorarioService horarioService;
	
	//Obtener todos los horarios
	@GetMapping("/horarios")
	private ResponseEntity<HorarioResponseRest> listarHorario(){
		ResponseEntity<HorarioResponseRest> response = horarioService.listar();
		return response;
	}
	
	//metodo para buscar si x recurso(auditorio,salon,sala) esta ocupado un dia a las respectivas horas
	@GetMapping("/horario/buscaDiaHiniHfinEnRecurso")
	public ResponseEntity<HorarioResponseRest> buscarRecursoDiaHIniHFin(
			@RequestParam("recurso_id") Long recurso_id,
			@RequestParam("dia") String dia,
			@RequestParam("hinicio") String  hInicio,
			@RequestParam("hfin") String hFin){
		Horario horario = new Horario();
		horario.setHor_dia(dia);
		horario.setHor_hora_inicio(hInicio);
		horario.setHor_hora_fin(hFin);
		ResponseEntity<HorarioResponseRest> response = horarioService.buscarRecursoDiaHIniHFin(horario, recurso_id);
		return response;
	}
	
	//metodo para agregar horario un recurso una hinicio, hfin, y el curso
	@PostMapping("/horario/agregarDiaHiniHfinARecur")
	public ResponseEntity<HorarioResponseRest> guardarHorario(
			@RequestParam("recurso_id") Long recurso_id,
			@RequestParam("curso_id") Long curso_id,
			@RequestParam("dia") String dia,
			@RequestParam("hinicio") String hInicio,
			@RequestParam("hfin") String hFin){
		Horario horario = new Horario();
		horario.setHor_dia(dia);
		horario.setHor_hora_inicio(hInicio);
		horario.setHor_hora_fin(hFin);
		ResponseEntity<HorarioResponseRest> response = horarioService.asigHorarioaRecurso(horario, recurso_id, curso_id);
		return response;
	}
	
	//metodo para eliminar un horario de un recurso
	@DeleteMapping("/horario/desasignarHorDeRecur/{recurso_id}")
	public ResponseEntity<HorarioResponseRest> retirarHorario(
			@PathVariable("recurso_id") Long recurso_id){
		ResponseEntity<HorarioResponseRest> response = horarioService.desAsigHorarioaRecurso(recurso_id);
		return response;
	}
	
	//METODO QUE LISTA LOS HORARIOS QUE TIENE UN RECURSO
	@GetMapping("/horario/listaHorDeRecurso/{recurso_id}")
	public ResponseEntity<HorarioResponseRest> listarHorariosDeRecurso(
			@PathVariable("recurso_id") Long recurso_id){
		ResponseEntity<HorarioResponseRest> response = horarioService.listarHorariosDeRecurso(recurso_id);
		return response;
	}
	
}
