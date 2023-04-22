package com.unicauca.edu.co.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.unicauca.edu.co.response.CursoResponseRest;
import com.unicauca.edu.co.services.ICursoService;


@CrossOrigin(origins = {"http://192.168.101.11:4200/","http://localhost:4200/"})
@RestController
@RequestMapping("/api/v1")
public class CursoRestController {

    @Autowired
    private ICursoService cursoService;

    //obtenemos todos los cursos
    @GetMapping("/cursos")
    private ResponseEntity<CursoResponseRest> listarCursos(){
        ResponseEntity<CursoResponseRest> response = cursoService.listar();
        return response;
    }

    //busca curso por id
    @GetMapping("/cursos/{id}")
    private ResponseEntity<CursoResponseRest> buscarCursoPorId(@PathVariable("id") Long id){
        ResponseEntity<CursoResponseRest> response = cursoService.buscarById(id);
        return response;
    }

    //eliminamos un curso
    @DeleteMapping("/cursos/{id}")
    private ResponseEntity<CursoResponseRest> eliminarCurso(@PathVariable("id") Long id){
        ResponseEntity<CursoResponseRest> response = cursoService.eliminarById(id);
        return response;
    }
    
  //Curso por Facultad
  	@GetMapping("/cursos/facultad/{fac_codigo}")
  	public ResponseEntity<CursoResponseRest> cursosPorFacultad(@PathVariable String fac_codigo){
  		ResponseEntity<CursoResponseRest> response = cursoService.cursosPorFacultad(fac_codigo);
  		return response;
  	}
  	
  //Curso por Asignatura
  	@GetMapping("/cursos/asignatura/{asig_codigo}")
  	public ResponseEntity<CursoResponseRest> cursosPorAsig(@PathVariable String asig_codigo){
  		System.out.println("llamando "+asig_codigo);
  		ResponseEntity<CursoResponseRest> response = cursoService.cursosPorAsig(asig_codigo);
  		return response;
  	}
}