package com.unicauca.edu.co.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.edu.co.model.Recurso;
import com.unicauca.edu.co.response.RecursoResponseRest;
import com.unicauca.edu.co.services.IRecursoService;

@CrossOrigin(origins = {"http://192.168.101.11:4200/","http://localhost:4200/"})
@RestController
@RequestMapping("/api/v1")
public class RecursoRestController {
	
	@Autowired
	private IRecursoService recursoService;
	
	//desasignar un recurso a otro recurso
	@PostMapping("/recursos/desasignar")
	private ResponseEntity<RecursoResponseRest> retirarRecursoaRecurso(
			@RequestParam("rec_codigo") Long rec_codigo,
			@RequestParam("rec_codigo2") Long rec_codigo2
			)
	{
		ResponseEntity<RecursoResponseRest> response = recursoService.desasignarRecursoaRecurso(rec_codigo, rec_codigo2);
		return response;
	}
	
	//Asignar un recurso a otro recurso
	@PostMapping("/recursos/asignar")
	private ResponseEntity<RecursoResponseRest> agregarRecursoaRecurso(
			@RequestParam("rec_codigo") Long rec_codigo,
			@RequestParam("rec_codigo2") Long rec_codigo2
			)
	{
		ResponseEntity<RecursoResponseRest> response = recursoService.asignarRecursoaRecurso(rec_codigo, rec_codigo2);
		return response;
	}
	
	//obtenemos todos los recursos
	@GetMapping("/recursos")
	private ResponseEntity<RecursoResponseRest> listarRecursos(){
		ResponseEntity<RecursoResponseRest> response = recursoService.listar();
		return response;
	}
	
	//busca recurso por id
	@GetMapping("/recursos/{id}")
	public ResponseEntity<RecursoResponseRest> buscarRecursoById(@PathVariable Long id){
		ResponseEntity<RecursoResponseRest> response = recursoService.buscarById(id);
		return response;
	}
	
	//buscar recurso por rec_codigo
	@GetMapping("/recursoscod/{cod_recurso}")
	public ResponseEntity<RecursoResponseRest> buscarRecursoRec_codigo(@PathVariable String cod_recurso){
		ResponseEntity<RecursoResponseRest> response = recursoService.buscarByRec_codigo(cod_recurso);
		return response;
	}
	
	//guardamos un recurso
	@PostMapping("/recursos")
	public ResponseEntity<RecursoResponseRest> guardarRecurso(
			@RequestParam("rec_codigo") String rec_codigo,
			@RequestParam("rectipo_codigo")String rectipo_codigo,
			@RequestParam("fac_codigo") String fac_codigo,
			@Nullable @RequestParam(value="rec_capmax") Integer capmax,
			@RequestParam("rec_nombre") String rec_nombre,
			@RequestParam("rec_decripcion")String rec_descripcion
			) throws IOException
	{
		Recurso recurso = new Recurso();
		recurso.setRec_codigo(rec_codigo);
		recurso.setRec_capmax(capmax);
		recurso.setRec_nombre(rec_nombre);
		recurso.setRec_descripcion(rec_descripcion);
		recurso.setEstado(false);
		ResponseEntity<RecursoResponseRest> response = recursoService.guardar(recurso,rectipo_codigo, fac_codigo);
		return response;
	}

	//actualizamos recurso
	@PutMapping("/recursos/{id_recurso}")
	public ResponseEntity<RecursoResponseRest> actulizarRecurso(
			@RequestParam("rec_codigo") String rec_codigo,
			@RequestParam("rectipo_codigo")String rectipo_codigo,
			@RequestParam("fac_codigo") String fac_codigo,
			@RequestParam(value="rec_capmax", required = false) String capmax,
			@RequestParam("rec_nombre") String rec_nombre,
			@RequestParam("rec_decripcion")String rec_descripcion,
			@PathVariable Long id_recurso)//id del recurso que se va a actualizar
{
		Recurso recurso = new Recurso();
		recurso.setRec_codigo(rec_codigo);
		if (capmax != null && !capmax.equals("null")) {
			recurso.setRec_capmax(Integer.parseInt(capmax));
		}
		recurso.setRec_nombre(rec_nombre);
		recurso.setRec_descripcion(rec_descripcion);
		ResponseEntity<RecursoResponseRest> response = recursoService.actualizar(recurso,id_recurso,rectipo_codigo,fac_codigo);
		return response;
	}
	
	//eliminar un recurso por id
	@DeleteMapping("/recursos/{id}")
	public ResponseEntity<RecursoResponseRest> eliminarRecurso(@PathVariable Long id){
		ResponseEntity<RecursoResponseRest> resposne = recursoService.eliminarById(id);
		return resposne;
	}
	
	//Recursos Auditorio Salon Sala por fac_codigo
	@GetMapping("/recursos/facaudisalasalon/{fac_codigo}")
	public ResponseEntity<RecursoResponseRest> recursosPorFacAudiSalaSalon(@PathVariable String fac_codigo){
		System.out.println("llamando al controller codigo: " + fac_codigo);
		ResponseEntity<RecursoResponseRest> response = recursoService.recursosPorFacultadAudiSalaSalon(fac_codigo);
		return response;
	}
	
	//recursos diferentes a auditorio sala salon por fac_codigo
	@GetMapping("/recursos/facudifaudisalasalon/{fac_codigo}")
	public ResponseEntity<RecursoResponseRest> recursosPorFacultadDiferenteAudiSalaSalon(@PathVariable String fac_codigo){
		ResponseEntity<RecursoResponseRest> response = recursoService.recursosPorFacultadDiferenteAudiSalaSalon(fac_codigo);
		return response;
	}
}
