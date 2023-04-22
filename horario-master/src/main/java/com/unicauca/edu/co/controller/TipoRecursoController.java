package com.unicauca.edu.co.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.edu.co.response.TipoRecursoResponseRest;
import com.unicauca.edu.co.services.ITipoRecursoService;

@CrossOrigin(origins = {"http://0.0.0.0:4200","http://localhost:4200","http://192.168.101.11:4200"})
@RestController
@RequestMapping("/api/v1")
public class TipoRecursoController {

	@Autowired
	private ITipoRecursoService tiporecursoService;
	
	//Listar tipos de recursos
	@GetMapping("/tiporecursos")
	private ResponseEntity<TipoRecursoResponseRest> listar(){
		ResponseEntity<TipoRecursoResponseRest> response = tiporecursoService.listar();
		return response;
	}
	
	//buscar tiporecurso por id
	@GetMapping("/tiporecursos/{cod_tiporecurso}")
	private ResponseEntity<TipoRecursoResponseRest> buscarPorId(@PathVariable String cod_tiporecurso){
		ResponseEntity<TipoRecursoResponseRest> response = tiporecursoService.buscarById(cod_tiporecurso);
		return response;
	}
	
	@GetMapping("/hijostiporecursos/{cod_padre_tiporecurso}")
	public ResponseEntity<TipoRecursoResponseRest> buscarHijosPorCodPadre(@PathVariable String cod_padre_tiporecurso){
		ResponseEntity<TipoRecursoResponseRest> response = tiporecursoService.listarHijosDePadreByCodPadre(cod_padre_tiporecurso);
		return response;
	}
}
