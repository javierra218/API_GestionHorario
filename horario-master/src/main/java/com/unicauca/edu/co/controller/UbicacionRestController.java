package com.unicauca.edu.co.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.edu.co.response.UbicacionResponseRest;
import com.unicauca.edu.co.services.IUbicacionService;

@CrossOrigin(origins = {"http://192.168.101.11:4200/","http://localhost:4200/"})
@RestController
@RequestMapping("/api/v1")
public class UbicacionRestController {

	@Autowired
	private IUbicacionService ubicacionService;
	
	
	//listar ubicaciones
	@GetMapping("/ubicaciones")
	private ResponseEntity<UbicacionResponseRest> listarUbicaciones(){
		ResponseEntity<UbicacionResponseRest> response = ubicacionService.listar();
		return response;
	}
	
	//Buscar ubicacion por cod_ubicacion	
	@GetMapping("/ubicaciones/{cod_ubi}")
	private ResponseEntity<UbicacionResponseRest> buscarPorId(@PathVariable("cod_ubi") String cod_ubi){
		ResponseEntity<UbicacionResponseRest> response = ubicacionService.buscarById(cod_ubi);
		return response;
	}
}
