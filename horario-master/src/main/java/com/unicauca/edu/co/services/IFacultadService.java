package com.unicauca.edu.co.services;

import org.springframework.http.ResponseEntity;

import com.unicauca.edu.co.model.Facultad;
import com.unicauca.edu.co.response.FacultadResponseRest;

public interface IFacultadService {

	public ResponseEntity<FacultadResponseRest> listar();
	public ResponseEntity<FacultadResponseRest> buscarById(String fac_cod);
	public ResponseEntity<FacultadResponseRest> guardar(Facultad facultad);
	public ResponseEntity<FacultadResponseRest> actualizar(Facultad facultad, String fac_cod);
	public ResponseEntity<FacultadResponseRest> eliminarById(String fac_cod);
	
}
