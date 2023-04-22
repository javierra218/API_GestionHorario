package com.unicauca.edu.co.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.edu.co.response.AsignaturaResponseRest;
import com.unicauca.edu.co.services.IAsignaturaService;

@CrossOrigin(origins = {"http://192.168.101.11:4200/","http://localhost:4200/"})
@RestController
@RequestMapping("/api/v1")
public class AsignaturaRestController {
	@Autowired
    private IAsignaturaService asignaturaService;

    //obtenemos todas las asignaturas
//    @GetMapping("/asignaturas")
//    private ResponseEntity<AsignaturaResponseRest> listarAsignaturas(){
//        ResponseEntity<AsignaturaResponseRest> response = asignaturaService.listar();
//        return response;
//    }

    //busca asignatura por id
//    @GetMapping("/asignatura/{id}")
//    private ResponseEntity<AsignaturaResponseRest> buscarAsignaturaPorId(@PathVariable("id") Long id){
//        ResponseEntity<AsignaturaResponseRest> response = asignaturaService.buscarById(id);
//        return response;
//    }


  //Asignatura por Facultad
  	@GetMapping("/asignaturas/facultad/{fac_codigo}")
  	public ResponseEntity<AsignaturaResponseRest> asignaturasPorFacultad(@PathVariable String fac_codigo){
  		ResponseEntity<AsignaturaResponseRest> response = asignaturaService.listaAsignaturaPorFacultad(fac_codigo);
  		return response;
  	}
}
