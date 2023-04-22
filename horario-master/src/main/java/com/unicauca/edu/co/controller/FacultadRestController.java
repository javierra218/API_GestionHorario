package com.unicauca.edu.co.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.edu.co.response.FacultadResponseRest;
import com.unicauca.edu.co.services.IFacultadService;

@CrossOrigin(origins = {"http://192.168.101.11:4200/","http://localhost:4200/"})
@RestController
@RequestMapping("/api/v1")
public class FacultadRestController {

	@Autowired
	private IFacultadService facultadService;
	
	//listar las facultades
	@GetMapping("/facultades")
	private ResponseEntity<FacultadResponseRest> listarFacultades(){
		ResponseEntity<FacultadResponseRest> response = facultadService.listar();
		return response;
	}
	
	//buscar facultad por fac_codigo
	@GetMapping("/facultades/{id}")
	private ResponseEntity<FacultadResponseRest> buscarPorId(@PathVariable("id") String fac_codigo){
		ResponseEntity<FacultadResponseRest> response = facultadService.buscarById(fac_codigo);
		return response;
	}
}
